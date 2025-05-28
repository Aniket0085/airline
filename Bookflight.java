package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Bookflight extends JFrame implements ActionListener {

    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton bookflight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;

    public Bookflight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel Iblaadhar = new JLabel("Aadhar");
        Iblaadhar.setBounds(60, 80, 150, 25);
        Iblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Iblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);

        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel Iblname = new JLabel("Name");
        Iblname.setBounds(60, 130, 150, 25);
        Iblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblname.setForeground(Color.BLUE);
        add(Iblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);

        JLabel Iblnationality = new JLabel("Nationality");
        Iblnationality.setBounds(60, 180, 150, 25);
        Iblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblnationality.setForeground(Color.BLUE);
        add(Iblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);

        JLabel Ibladdress = new JLabel("Address");
        Ibladdress.setBounds(60, 230, 150, 25);
        Ibladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Ibladdress.setForeground(Color.BLUE);
        add(Ibladdress);

        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

        JLabel Iblgender = new JLabel("Gender");
        Iblgender.setBounds(60, 280, 150, 25);
        Iblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Iblgender);

        labelgender = new JLabel();
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);

        JLabel IblSource = new JLabel("Source");
        IblSource.setBounds(60, 330, 150, 25);
        IblSource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(IblSource);

        source = new Choice();
        source.setBounds(220, 330, 120, 25);
        add(source);

        JLabel Ibldest = new JLabel("Destination");
        Ibldest.setBounds(60, 380, 150, 25);
        Ibldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibldest);

        destination = new Choice();
        destination.setBounds(220, 380, 120, 25);
        add(destination);

        try {
            Conn c = new Conn();
            String query = "SELECT DISTINCT source, destination FROM flight";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);

        JLabel Iblfname = new JLabel("Flight Name");
        Iblfname.setBounds(60, 430, 150, 25);
        Iblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblfname.setForeground(Color.BLUE);
        add(Iblfname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);

        JLabel Iblcode = new JLabel("Flight Code");
        Iblcode.setBounds(60, 480, 150, 25);
        Iblcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Iblcode.setForeground(Color.BLUE);
        add(Iblcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);

        JLabel Ibldate = new JLabel("Date of Travel");
        Ibldate.setBounds(60, 530, 150, 25);
        Ibldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Ibldate.setForeground(Color.BLUE);
        add(Ibldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        JLabel Iblimage = new JLabel(new ImageIcon(i2));
        Iblimage.setBounds(550, 80, 500, 410);
        add(Iblimage);

        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);

        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String aadhar = tfaadhar.getText();

            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM passenger WHERE aadhar = '" + aadhar + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "No passenger found with given Aadhar");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == flight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();

            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM flight WHERE source = '" + src + "' AND destination = '" + dest + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No flights found for this route.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == bookflight) {
            Random random = new Random();
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

            try {
                Conn conn = new Conn();
                String pnr = "PNR-" + random.nextInt(1000000);
                String ticket = "TIC-" + random.nextInt(10000);

                String query = "INSERT INTO reservation VALUES ('" + pnr + "', '" + ticket + "', '" + aadhar + "', '" + name + "','" + nationality + "','" + flightname + "', '" + flightcode + "', '" + src + "','" + dest + "', '" + ddate + "')";

                int result = conn.s.executeUpdate(query);

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Flight Booked Successfully!\nPNR: " + pnr);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to book flight");
                }
                
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Bookflight();
    }
}
