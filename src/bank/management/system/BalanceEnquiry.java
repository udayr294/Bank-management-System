package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame {
    JLabel balanceLabel;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons copy/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Your Current Account Balance:");
        text.setBounds(200, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        balanceLabel = new JLabel();
        balanceLabel.setBounds(250, 330, 400, 20);
        balanceLabel.setForeground(Color.YELLOW);
        balanceLabel.setFont(new Font("System", Font.BOLD, 20));
        image.add(balanceLabel);

        int balance = 0;

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank_transactions WHERE pin = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equalsIgnoreCase("Withdrawal")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        balanceLabel.setText("Rs " + balance);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("1234");
    }
}
