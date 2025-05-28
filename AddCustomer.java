package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfphone,tfaadhar,tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading  = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220,20,500,35);
        heading.setFont(new Font("Tohoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
         JLabel Iblname  = new JLabel("Name");
        Iblname.setBounds(60,80,150,25);
       Iblname.setFont(new Font("Tohoma",Font.PLAIN,16));
        Iblname.setForeground(Color.BLUE);
        add(Iblname);
        
       tfname = new JTextField();
       tfname.setBounds(220,80,150,25);
         add(tfname); 
         
           JLabel Iblnationality = new JLabel("nationality");
        Iblnationality.setBounds(60,130,150,25);
       Iblnationality.setFont(new Font("Tohoma",Font.PLAIN,16));
        Iblnationality.setForeground(Color.BLUE);
        add(Iblnationality);
        
     tfnationality = new JTextField();
      tfnationality.setBounds(220,130,150,25);
       add(tfnationality);
         
            JLabel Iblaadhar = new JLabel("Aadhar number");
        Iblaadhar .setBounds(60,180,150,25);
       Iblaadhar .setFont(new Font("Tohoma",Font.PLAIN,16));
        Iblaadhar .setForeground(Color.BLUE);
        add(Iblaadhar );
        
         tfaadhar = new JTextField();
       tfaadhar.setBounds(220,180,150,25);
         add(tfaadhar);
         
            JLabel Ibladdress = new JLabel("Address");
       Ibladdress.setBounds(60,230,150,25);
       Ibladdress.setFont(new Font("Tohoma",Font.PLAIN,16));
        Ibladdress.setForeground(Color.BLUE);
        add(Ibladdress);
        
         tfaddress = new JTextField();
       tfaddress.setBounds(220,230,150,25);
         add( tfaddress);
         
           
            JLabel Iblgender = new JLabel("Gender");
       Iblgender.setBounds(60,280,150,25);
      Iblgender.setFont(new Font("Tohoma",Font.PLAIN,16));
        Iblgender.setForeground(Color.BLUE);
        add(Iblgender);
        
         ButtonGroup gendergroup = new ButtonGroup();
         
          rbmale = new JRadioButton("Male");
         rbmale.setBounds(220,280,70,25);
         rbmale.setBackground(Color.WHITE);
         add(rbmale);
         
          rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
         rbfemale.setBackground(Color.WHITE);
         add(rbfemale);
         
         gendergroup.add(rbmale);
         gendergroup.add(rbfemale);
         
            
        JLabel Iblphone = new JLabel("phone");
       Iblphone.setBounds(60,330,150,25);
      Iblphone.setFont(new Font("Tohoma",Font.PLAIN,16));
       Iblphone.setForeground(Color.BLUE);
        add(Iblphone);
        
         tfphone = new JTextField();
       tfphone .setBounds(220,330,150,25);
         add(  tfphone );
         
         JButton save = new JButton("SAVE");
         save.setBackground(Color.BLACK);
         save.setForeground(Color.WHITE);
         save.setBounds(220,380,150,30);
         save.addActionListener(this);
         add(save);
         
         ImageIcon image = new  ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
         JLabel Iblimage = new JLabel(image);
         Iblimage.setBounds(400,80,280,400);
         add(Iblimage);
      
      
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)  {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if (rbmale.isSelected()){
            gender = "Male";
        }else{
            gender = "female";
        }
        try{
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"' ,'"+aadhar+"','"+gender+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            
            setVisible(false);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[]args){
        
        new AddCustomer();
        
    }
    
}