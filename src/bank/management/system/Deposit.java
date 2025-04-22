package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit, back;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons copy/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter Deposit Amount");
        text.setBounds(200, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Railway", Font.BOLD, 22));
        amount.setBounds(200, 330, 300, 30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(200, 380, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(360, 380, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String depositAmount = amount.getText();

            if (depositAmount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter an amount to deposit.");
                return;
            }

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO bank_transactions (pin, date, type, amount) VALUES ('" + pinnumber + "', NOW(), 'Deposit', '" + depositAmount + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + depositAmount + " Deposited Successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
