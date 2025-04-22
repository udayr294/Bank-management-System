package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1, r2, r3, r4;
    ButtonGroup accountGroup;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    
    
    SignupThree(String formno) {
        this.formno= formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 80, 400, 30);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 15));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Raleway", Font.BOLD, 15));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 15));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);
        
        r4 = new JRadioButton("Recurrent Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 15));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);
        
        // Grouping radio buttons
        accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 15));
        card.setBounds(100, 300, 200, 30);
        add(card);
       
        
        JLabel carddetails=new JLabel("Enter Your 16 Digits Numbers:");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 330, 250, 30);
        add(carddetails);
        
        
        JLabel cardnumber=new JLabel("XXXX-XXXX-XXXX-9128");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 15));
        cardnumber.setBounds(330, 300, 400, 30);
        add(cardnumber);
       
        
        
       JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 15));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
       
        
        JLabel pinnumber=new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 15));
        pinnumber.setBounds(330, 370, 400, 30);
        add(pinnumber);
        
        
        JLabel pinDetails = new JLabel("Enter Your 4 Digit PIN");
        pinDetails.setFont(new Font("Raleway", Font.PLAIN, 12));
        pinDetails.setBounds(100, 400, 250, 20);
        add(pinDetails); 
       
        
         JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 15));
        services.setBounds(100, 450, 200, 30);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.setBackground(Color.WHITE);       
        c1.setBounds(100, 490, 250, 30);
        add(c1);
        
        c2=new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        c2.setBackground(Color.WHITE);      
        c2.setBounds(350, 490, 250, 30);
        add(c2);
        
        c3=new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBackground(Color.WHITE);      
        c3.setBounds(100, 530, 250, 30);
        add(c3);
        
        c4=new JCheckBox("EMAIL & SMS ALERTS");
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBackground(Color.WHITE);      
        c4.setBounds(350, 530, 250, 30);
        add(c4);
        
        c5=new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBackground(Color.WHITE);      
        c5.setBounds(100, 570, 250, 30);
        add(c5);
        
        c6=new JCheckBox("E STATEMENT");
        c6.setFont(new Font("Raleway", Font.BOLD, 15));
        c6.setBackground(Color.WHITE);      
        c6.setBounds(350, 570, 250, 30);
        add(c6);
        
        c7=new JCheckBox("I HEARE BY DECLARES THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE");
        c7.setFont(new Font("Raleway", Font.BOLD, 15));
        c7.setBackground(Color.WHITE);      
        c7.setBounds(100, 620, 700, 12);
        add(c7);
        
        
        submit=new JButton ("Submit") ;
        submit.setBackground (Color. BLACK) ; 
        submit.setForeground (Color. WHITE) ;
        submit.setFont (new Font ("Raleway", Font. BOLD,14));
        submit.setBounds(250, 670, 100, 30); 
        submit.setOpaque(true);
        submit.addActionListener(this);
        submit.setBorderPainted(false);
        add(submit);
        
        cancel=new JButton ("Cancel") ;
        cancel.setBackground (Color. BLACK) ; 
        cancel.setForeground (Color. WHITE) ;
        cancel.setFont (new Font ("Raleway", Font. BOLD,14));
        cancel.setBounds(400, 670, 100, 30);
        cancel.setOpaque(true);
        cancel.addActionListener(this);
        cancel.setBorderPainted(false);
        
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        
       
     
        
        setSize(850, 800);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
           String accountType=null; 
           if(r1.isSelected()){
               accountType="Saving Account";            
         }else if(r2.isSelected()){
             accountType="Fixed deposite Account";
         }else if(r3.isSelected()) {
             accountType="Current Account";
         }  else if(r4.isSelected()){
             accountType="Recurrent Deposite Account";
         } 
           
           
           Random random=new Random();
           String cardnumber = "" + Math.abs((random.nextLong() % 9000000000000000L) + 1000000000000000L);

           String pinnumber=""+Math.abs(random.nextLong()% 90000L+10000L);
           String facility="";
           if(c1.isSelected()){
               facility=facility+"ATM card";
           }
           else if(c2.isSelected()){
               facility=facility+"Internet Banking";
           }
           else if(c3.isSelected()){
               facility=facility+"Mobile Banking";
           }
           else if(c4.isSelected()){
               facility=facility+"EMAIL & SMS ALERTS";
           }
           else if(c5.isSelected()){
               facility=facility+"CHEQUE BOOK";
           }
           else if(c6.isSelected()){
               facility=facility+"E STATEMENT";
           }
           try{
               if(accountType.equals(" ")){
                   JOptionPane.showMessageDialog(null,"Account Type is Required");
                   setVisible(false);
                   new Deposit(pinnumber).setVisible(false);
               }else {
                   Conn c=new Conn();
                   String query1 = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";

                   c.s.executeUpdate(query1);
               }
           }catch(Exception e){
               System.out.println(e);
           }
        } 
           
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new SignupThree("");
    }
}
