package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Home extends JFrame implements ActionListener {
    
    public Home() {
      
       setLayout(null);
       
       ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(0,0,1600,800);
       add(image);
       
       JLabel heading = new JLabel("AIR INDIA WELCOME YOU");
       heading.setBounds(500,20,1000,40);
       heading.setForeground(Color.BLUE);
       heading.setFont(new Font("Tohome",Font.PLAIN,36));
       image.add(heading);
       
       JMenuBar menubar = new JMenuBar();
       setJMenuBar(menubar);
       
       JMenu details = new JMenu("Details");
       menubar.add(details);
       
       JMenuItem flightDetails = new JMenuItem("Flight Details");
       flightDetails.addActionListener(this);
       details.add(flightDetails);
       
        JMenuItem customerDetails = new JMenuItem("Add customer Details");
        customerDetails.addActionListener(this);
       details.add(customerDetails);
       
        JMenuItem bookflight = new JMenuItem("book flight");
        bookflight.addActionListener(this);
       details.add( bookflight);
       
        JMenuItem journeyDetails = new JMenuItem("journey Details");
        journeyDetails.addActionListener(this);
       details.add( journeyDetails);
       
        JMenuItem ReservationDetails = new JMenuItem("Reservation Details");
       details.add(ReservationDetails );
       
        JMenuItem ticketCancellation = new JMenuItem("Cancel ticket");
       details.add(ticketCancellation);
        
       JMenu ticket= new JMenu("ticket");
       menubar.add(ticket);
       
       JMenuItem boardingpass = new JMenuItem("Boarding pass");
       ticket.add(boardingpass);

       

        setTitle("Airline Management Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ✅ Correct method name
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if(text.equals("Add customer Details")){
             new AddCustomer();
            
        }else if(text.equals("Flight Details")){
            new flightInfo();
        }else if (text.equals("Book flight")){
            new Bookflight();
        }else if(text.equals("Journey Details")){
            new JourneyDetails();
        }
       
    }

    public static void main(String[] args) {
        new Home();
    }
}