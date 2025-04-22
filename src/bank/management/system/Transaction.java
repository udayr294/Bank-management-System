package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber.trim();
        setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons copy/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Title
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(200, 300, 400, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Buttons
        deposit = new JButton("Deposit");
        withdraw = new JButton("Cash Withdrawal");
        fastCash = new JButton("Fast Cash");
        miniStatement = new JButton("Mini Statement");
        pinChange = new JButton("PIN Change");
        balanceEnquiry = new JButton("Balance Enquiry");
        exit = new JButton("Exit");

        // Set bounds
        deposit.setBounds(170, 350, 150, 30);
        withdraw.setBounds(355, 350, 150, 30);
        fastCash.setBounds(170, 400, 150, 30);
        miniStatement.setBounds(355, 400, 150, 30);
        pinChange.setBounds(170, 450, 150, 30);
        balanceEnquiry.setBounds(355, 450, 150, 30);
        exit.setBounds(262, 510, 150, 30); // Centered Exit button

        // Add listeners and buttons
        for (JButton btn : new JButton[]{deposit, withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit}) {
            btn.addActionListener(this);
            image.add(btn);
        }

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinnumber).setVisible(true); // Don't close this window
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transaction("1234");
    }
}
