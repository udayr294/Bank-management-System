package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religion, category, occupation, education, income;
    String formno;
    JDateChooser dateChooser;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Railway", Font.BOLD, 20));
        rel.setBounds(100, 140, 100, 30);
        add(rel);

        String valReligions[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligions);
        religion.setBounds(300, 140, 400, 30);
        add(religion);

        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Railway", Font.BOLD, 20));
        cat.setBounds(100, 190, 200, 30);
        add(cat);

        String valCategory[] = {"GENERAL", "OBC", "EBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        add(category);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Railway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String incomeCategory[] = {"NULL", "<500000", ">=500000", "UPTO 1000000"};
        income = new JComboBox<>(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        add(income);

        JLabel edu = new JLabel("Educational Qualification:");
        edu.setFont(new Font("Railway", Font.BOLD, 20));
        edu.setBounds(100, 290, 300, 30);
        add(edu);

        String educationValues[] = {"NON GRADUATE", "GRADUATE", "B.TECH", "BSC", "BCA", "Other"};
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 330, 400, 30);
        add(education);

        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Railway", Font.BOLD, 20));
        occ.setBounds(100, 380, 200, 30);
        add(occ);

        String occupationValues[] = {"FARMING", "TEACHING", "MANAGEMENT", "DOCTOR", "ENGINEER", "Other"};
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 380, 400, 30);
        add(occupation);

        JLabel panLabel = new JLabel("PAN No:");
        panLabel.setFont(new Font("Railway", Font.BOLD, 20));
        panLabel.setBounds(100, 430, 200, 30);
        add(panLabel);

        pan = new JTextField();
        pan.setFont(new Font("Railway", Font.BOLD, 20));
        pan.setBounds(300, 430, 400, 30);
        add(pan);

        JLabel aadharLabel = new JLabel("Aadhar Card No:");
        aadharLabel.setFont(new Font("Railway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 480, 200, 30);
        add(aadharLabel);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Railway", Font.BOLD, 20));
        aadhar.setBounds(300, 480, 400, 30);
        add(aadhar);

        JLabel seniorLabel = new JLabel("Senior Citizen:");
        seniorLabel.setFont(new Font("Railway", Font.BOLD, 20));
        seniorLabel.setBounds(100, 530, 200, 30);
        add(seniorLabel);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 530, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(400, 530, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel existingLabel = new JLabel("Existing Account:");
        existingLabel.setFont(new Font("Railway", Font.BOLD, 20));
        existingLabel.setBounds(100, 580, 200, 30);
        add(existingLabel);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 580, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(400, 580, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);     
        
        next = new JButton("Next");
        next.setBounds(600, 675, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setOpaque(true);
        next.setBorderPainted(false);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 750);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = syes.isSelected() ? "Yes" : "No";
        String existingaccount = eyes.isSelected() ? "Yes" : "No";

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo (formno, religion, category, income, educational, occupation, pan_no, aadhar_card_number, senior_citizen, existing_account) VALUES ('"
        + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '"
        + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";

            c.s.executeUpdate(query);

            // Go to next page (SignupThree assumed to exist)
            setVisible(false);
                new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
