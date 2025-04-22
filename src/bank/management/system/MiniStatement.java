package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    JLabel miniLabel;
    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(150, 100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(100, 20, 200, 20);
        bank.setFont(new Font("System", Font.BOLD, 16));
        add(bank);

        JLabel card = new JLabel("Card No: ");
        card.setBounds(20, 60, 400, 20);
        add(card);

        miniLabel = new JLabel();
        miniLabel.setBounds(20, 100, 400, 400);
        miniLabel.setFont(new Font("System", Font.PLAIN, 12));
        add(miniLabel);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank_transactions WHERE pin = '" + pinnumber + "' ORDER BY date DESC LIMIT 5");

            StringBuilder statement = new StringBuilder("<html>");
            while (rs.next()) {
                statement.append(rs.getString("date")).append("&nbsp;&nbsp;")
                         .append(rs.getString("type")).append("&nbsp;&nbsp;Rs ")
                         .append(rs.getString("amount")).append("<br><br>");
            }
            statement.append("</html>");
            miniLabel.setText(statement.toString());

            // Show masked card number (if available)
            ResultSet cardRs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
            if (cardRs.next()) {
                String cardno = cardRs.getString("cardnumber");
                card.setText("<html>Card No: " + cardno.substring(0, 4) + "XXXXXXXX" + cardno.substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("1234");
    }
}
