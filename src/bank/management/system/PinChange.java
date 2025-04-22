package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinText, rePinText;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons copy/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 300, 400, 25);
        image.add(text);

        JLabel pinLabel = new JLabel("New PIN:");
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setBounds(200, 340, 150, 25);
        image.add(pinLabel);

        pinText = new JPasswordField();
        pinText.setBounds(300, 340, 150, 25);
        image.add(pinText);

        JLabel rePinLabel = new JLabel("Re-Enter PIN:");
        rePinLabel.setForeground(Color.WHITE);
        rePinLabel.setBounds(200, 380, 150, 25);
        image.add(rePinLabel);

        rePinText = new JPasswordField();
        rePinText.setBounds(300, 380, 150, 25);
        image.add(rePinText);

        change = new JButton("Change");
        change.setBounds(200, 430, 100, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(350, 430, 100, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            String newPin = String.valueOf(pinText.getPassword());
            String rePin = String.valueOf(rePinText.getPassword());

            if (!newPin.equals(rePin)) {
                JOptionPane.showMessageDialog(null, "Entered PINs do not match.");
                return;
            }

            if (newPin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a new PIN.");
                return;
            }

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("UPDATE bank_transactions SET pin = '" + newPin + "' WHERE pin = '" + pinnumber + "'");
                conn.s.executeUpdate("UPDATE login SET pin = '" + newPin + "' WHERE pin = '" + pinnumber + "'");
                conn.s.executeUpdate("UPDATE signupthree SET pin = '" + newPin + "' WHERE pin = '" + pinnumber + "'");

                JOptionPane.showMessageDialog(null, "PIN changed successfully.");

                setVisible(false);
                new Transaction(newPin).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("1234");
    }
}
