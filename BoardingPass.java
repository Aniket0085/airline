package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, tfnationality, Iblsrc, Ibldest, labelfname, labelfcode, labeldate;
    JButton fetchButton;

    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);

        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 50, 300, 35);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);

        JLabel Iblaadhar = new JLabel("PNR DETAILS");
        Iblaadhar.setBounds(60, 100, 150, 25);
        Iblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Iblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);

        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel Iblname = new JLabel("NAME");
        Iblname.setBounds(60, 140, 150, 25);
        Iblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblname.setForeground(Color.BLUE);
        add(Iblname);

        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);

        JLabel Iblnationality = new JLabel("NATIONALITY");
        Iblnationality.setBounds(60, 180, 150, 25);
        Iblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblnationality.setForeground(Color.BLUE);
        add(Iblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);

        JLabel Ibladdress = new JLabel("SRC");
        Ibladdress.setBounds(60, 220, 150, 25);
        Ibladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Ibladdress.setForeground(Color.BLUE);
        add(Ibladdress);

        Iblsrc = new JLabel();
        Iblsrc.setBounds(220, 220, 150, 25);
        add(Iblsrc);

        JLabel Iblgender = new JLabel("DEST");
        Iblgender.setBounds(60, 260, 150, 25);
        Iblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblgender.setForeground(Color.BLUE);
        add(Iblgender);

        Ibldest = new JLabel();
        Ibldest.setBounds(220, 260, 150, 25);
        add(Ibldest);

        JLabel Iblfname = new JLabel("Flight Name");
        Iblfname.setBounds(60, 300, 150, 25);
        Iblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblfname.setForeground(Color.BLUE);
        add(Iblfname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 300, 150, 25);
        add(labelfname);

        JLabel Iblcode = new JLabel("Flight Code");
        Iblcode.setBounds(60, 340, 150, 25);
        Iblcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblcode.setForeground(Color.BLUE);
        add(Iblcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(220, 340, 150, 25);
        add(labelfcode);

        JLabel Ibldate = new JLabel("Date");
        Ibldate.setBounds(60, 380, 150, 25);
        Ibldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Ibldate.setForeground(Color.BLUE);
        add(Ibldate);

        labeldate = new JLabel();
        labeldate.setBounds(220, 380, 150, 25);
        add(labeldate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        JLabel Iblimage = new JLabel(new ImageIcon(i2));
        Iblimage.setBounds(600, 0, 300, 300);
        add(Iblimage);

        setSize(1000, 500);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String pnr = tfpnr.getText();

            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM reservation WHERE PNR = '" + pnr + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    Iblsrc.setText(rs.getString("src"));
                    Ibldest.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "No reservation found with given PNR.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}