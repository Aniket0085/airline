package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton submit, reset, close;
    JTextField tfusername;
    JPasswordField tfPassword;

    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Username Label
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);

        // Password Label
        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(130, 60, 200, 20);
        add(tfPassword);

        // Buttons
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 25);
        reset.addActionListener(this);
        add(reset);

        submit = new JButton("Submit");
        submit.setBounds(190, 120, 120, 25);
        submit.addActionListener(this);
        add(submit);

        close = new JButton("Close");
        close.setBounds(120, 160, 120, 25);
        close.addActionListener(this);
        add(close);

        setTitle("Airline Management Login");
        setSize(400, 250);
        setLocation(600, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ✅ Correct method name
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = tfusername.getText();
            String password = new String(tfPassword.getPassword());
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username = '"+username+"'and password = '"+password+"'";
              ResultSet rs =   c.s.executeQuery(query);
              
           if (rs.next()){
               new Home();
               setVisible(false);
               
           } else {
               JOptionPane.showMessageDialog(null,"invalid Username or Password");
               setVisible(false);
           }
              
            } catch (Exception e){
                 e.printStackTrace();
            }

         
        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfPassword.setText("");

        } else if (ae.getSource() == close) {
            setVisible(false);
            dispose(); // Clean exit
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}