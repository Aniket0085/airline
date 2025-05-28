package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, cancellationno;
    JButton flight, fetchButton;

    public Cancel() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random random = new Random();

        JLabel heading = new JLabel("CANCEL FLIGHT");
        heading.setBounds(180, 20, 300, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 120, 230, 200);
        add(image);

        JLabel Iblaadhar = new JLabel("PNR Number");
        Iblaadhar.setBounds(60, 80, 150, 25);
        Iblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Iblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);

        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 150, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel Iblname = new JLabel("Name");
        Iblname.setBounds(60, 130, 150, 25);
        Iblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Iblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 200, 25);
        add(tfname);

        JLabel Iblcancelno = new JLabel("Cancellation No");
        Iblcancelno.setBounds(60, 180, 150, 25);
        Iblcancelno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Iblcancelno);

        cancellationno = new JLabel("CAN-" + random.nextInt(1000000));
        cancellationno.setBounds(220, 180, 200, 25);
        add(cancellationno);

        flight = new JButton("Cancel");
        flight.setBackground(Color.RED);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 230, 150, 30);
        flight.addActionListener(this);
        add(flight);

        setSize(650, 400);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String PNR = tfpnr.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into cancel = '" + PNR + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                } else {
                    JOptionPane.showMessageDialog(null, "No reservation found for this PNR.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == flight) {
            String pnr = tfpnr.getText();
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel the flight?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Conn conn = new Conn();
                    String query = "DELETE FROM reservation WHERE pnr = '" + pnr + "'";
                    int result = conn.s.executeUpdate(query);

                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Reservation Cancelled Successfully.");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cancellation Failed. No matching reservation.");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Cancel();
    }
}
