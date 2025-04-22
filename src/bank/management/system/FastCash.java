
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons copy/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Title text
        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Fast cash buttons
        hundred = new JButton("Rs 100");
        hundred.setBounds(170, 330, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355, 330, 150, 30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thousand = new JButton("Rs 1000");
        thousand.setBounds(170, 380, 150, 30);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355, 380, 150, 30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170, 430, 150, 30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(355, 430, 150, 30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("Back");
        back.setBounds(262, 480, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    String amount = "";

    if (ae.getSource() == back) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
        return;
    } else if (ae.getSource() == hundred) {
        amount = "100";
    } else if (ae.getSource() == fiveHundred) {
        amount = "500";
    } else if (ae.getSource() == thousand) {
        amount = "1000";
    } else if (ae.getSource() == twoThousand) {
        amount = "2000";
    } else if (ae.getSource() == fiveThousand) {
        amount = "5000";
    } else if (ae.getSource() == tenThousand) {
        amount = "10000";
    }

    // Safeguard: Check if amount is set
    if (amount.equals("")) {
        JOptionPane.showMessageDialog(null, "Please select a withdrawal amount");
        return;
    }

    try {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("SELECT * FROM bank_transactions WHERE pin = '" + pinnumber + "'");
        int balance = 0;

        while (rs.next()) {
                String type = rs.getString("type");
                int transactionAmount = rs.getInt("amount");

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += transactionAmount;  // Add deposit amount to balance
                } else if (type.equalsIgnoreCase("Withdrawal")) {
                    balance -= transactionAmount;  // Subtract withdrawal amount from balance
                }
            }
        
       
        int withdrawAmount = Integer.parseInt(amount);
        if (balance < withdrawAmount) {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
            return;
        }
        
        Date date =new Date();
        

        // Insert fast cash transaction
        String query = "INSERT INTO bank_transactions (pin, date, type, amount) VALUES ('" + pinnumber + "', NOW(), 'Withdrawal', '" + withdrawAmount + "')";
        conn.s.executeUpdate(query);

        JOptionPane.showMessageDialog(null, "Rs " + withdrawAmount + " Debited Successfully");
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}


    public static void main(String[] args) {
        new FastCash("");
    }
}
