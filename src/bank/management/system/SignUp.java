package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {
    JLabel jLabel1, lineLabel, labelPersonalDetail, labelName, labelFathName, labelDOB, labelGender, labelMarital, labelEmail, labelAddress, labelState;
    JTextField textFieldName, textFieldFathName, textFieldEmail, textFieldAddress, textFieldState;
    JDateChooser jDateChooser;
    JRadioButton maleButton, femaleButton, marriedButton, unmarriedButton;
    JButton cancelButton,jButton;
    Random random = new Random();
    long rNum = random.nextLong(1000);


    SignUp() {
        super("User Details");

        jLabel1 = new JLabel("Form No: " + rNum);
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        jLabel1.setBounds(530, 30, 500, 30);
        add(jLabel1);

        jLabel1 = new JLabel("Application Form " );
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setFont(new Font("Monotype Corsiva", Font.BOLD, 38));
        jLabel1.setBounds(230, 30, 500, 30);
        add(jLabel1);

        lineLabel = new JLabel("_____________________________");
        lineLabel.setForeground(Color.BLACK);
        lineLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        lineLabel.setBounds(230, 40, 500, 30);
        add(lineLabel);

        labelPersonalDetail = new JLabel("Personal Detail:");
        labelPersonalDetail.setForeground(Color.BLACK);
        labelPersonalDetail.setFont(new Font("Arial", Font.BOLD, 18));
        labelPersonalDetail.setBounds(100, 70, 150, 30);
        add(labelPersonalDetail);


        labelName = new JLabel("Name: ");
        labelName.setForeground(Color.BLACK);
        labelName.setFont(new Font("Arial", Font.PLAIN, 20));
        labelName.setBounds(40, 110, 200, 30);
        add(labelName);

        textFieldName = new JTextField(15);
        textFieldName.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldName.setBounds(170, 110, 300, 30);
        add(textFieldName);

        labelFathName = new JLabel("Father Name: ");
        labelFathName.setForeground(Color.BLACK);
        labelFathName.setFont(new Font("Arial", Font.PLAIN, 20));
        labelFathName.setBounds(40, 150, 200, 30);
        add(labelFathName);

        textFieldFathName = new JTextField(15);
        textFieldFathName.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldFathName.setBounds(170, 150, 300, 30);
        add(textFieldFathName);

        labelDOB = new JLabel("DOB: ");
        labelDOB.setForeground(Color.BLACK);
        labelDOB.setFont(new Font("Arial", Font.PLAIN, 20));
        labelDOB.setBounds(40, 190, 300, 30);
        add(labelDOB);

        jDateChooser = new JDateChooser();
        jDateChooser.setForeground(new Color(105, 105, 105));
        jDateChooser.setFont(new Font("Arial", Font.PLAIN, 16));
        jDateChooser.setBounds(170, 190, 300, 30);
        add(jDateChooser);

        labelGender = new JLabel("Gender:");
        labelGender.setForeground(Color.BLACK);
        labelGender.setFont(new Font("Arial", Font.PLAIN, 20));
        labelGender.setBounds(40, 230, 100, 30);
        add(labelGender);

        maleButton = new JRadioButton("Male");
        maleButton.setOpaque(false);
        maleButton.setFont(new Font("Arial", Font.PLAIN, 18));
        maleButton.setBounds(170, 230, 100, 30);
        add(maleButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setOpaque(false);
        femaleButton.setFont(new Font("Arial", Font.PLAIN, 18));
        femaleButton.setBounds(300, 230, 100, 30);
        add(femaleButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(maleButton);
        buttonGroup.add(femaleButton);

        labelMarital = new JLabel("Marital Status:");
        labelMarital.setForeground(Color.BLACK);
        labelMarital.setFont(new Font("Arial", Font.PLAIN, 20));
        labelMarital.setBounds(40, 270, 200, 30);
        add(labelMarital);

        marriedButton = new JRadioButton("Married");
        marriedButton.setOpaque(false);
        marriedButton.setFont(new Font("Arial", Font.PLAIN, 18));
        marriedButton.setBounds(170, 270, 100, 30);
        add(marriedButton);

        unmarriedButton = new JRadioButton("UnMarried");
        unmarriedButton.setOpaque(false);
        unmarriedButton.setFont(new Font("Arial", Font.PLAIN, 18));
        unmarriedButton.setBounds(300, 270, 150, 30);
        add(unmarriedButton);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(marriedButton);
        buttonGroup1.add(unmarriedButton);

        labelEmail = new JLabel("Email: ");
        labelEmail.setForeground(Color.BLACK);
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        labelEmail.setBounds(40, 310, 200, 30);
        add(labelEmail);

        textFieldEmail = new JTextField(15);
        textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldEmail.setBounds(170, 310, 300, 30);
        add(textFieldEmail);

        labelAddress = new JLabel("Address: ");
        labelAddress.setForeground(Color.BLACK);
        labelAddress.setFont(new Font("Arial", Font.PLAIN, 20));
        labelAddress.setBounds(40, 350, 200, 30);
        add(labelAddress);

        textFieldAddress = new JTextField(15);
        textFieldAddress.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldAddress.setBounds(170, 350, 300, 30);
        add(textFieldAddress);

        labelState = new JLabel("State: ");
        labelState.setForeground(Color.BLACK);
        labelState.setFont(new Font("Arial", Font.PLAIN, 20));
        labelState.setBounds(40, 390, 200, 30);
        add(labelState);

        textFieldState = new JTextField(15);
        textFieldState.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldState.setBounds(170, 390, 300, 30);
        add(textFieldState);

        jButton = new JButton("NEXT");
        jButton.setForeground(Color.BLACK);
        jButton.setBackground(Color.LIGHT_GRAY);
        jButton.setFont(new Font("Arial", Font.PLAIN, 18));
        jButton.setBounds(620, 390, 100, 40);
        jButton.addActionListener(this);
        add(jButton);

        cancelButton = new JButton("CANCEL");
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBackground(Color.LIGHT_GRAY);
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cancelButton.setBounds(480, 390, 100, 40);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image image1 = imageIcon3.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image1);
        JLabel jLabel1 = new JLabel(imageIcon2);
        jLabel1.setBounds(500, 150, 250, 200);
        add(jLabel1);

        //setting up background
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bgsignup.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(0, 0, 800, 500);
        add(jLabel);

        //Setting up frame
        setLayout(null);
        setUndecorated(true);
        setSize(800, 500);
        setLocation(380, 150);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton) {
            long formNo = rNum;
            String name = textFieldName.getText();
            String fatherName = textFieldFathName.getText();
            String dob = ((JTextField) jDateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (maleButton.isSelected()) {
                gender = "Male";
            } else if (femaleButton.isSelected()) {
                gender = "Female";
            }

            String marital = null;
            if (marriedButton.isSelected()) {
                marital = "married";
            } else if (unmarriedButton.isSelected()) {
                marital = "unmarried";
            }
            String email = textFieldEmail.getText();
            String address = textFieldAddress.getText();
            String state = textFieldState.getText();

            try {
                if (name.isEmpty() || fatherName.isEmpty() || dob.isEmpty()
                        || gender.isEmpty() || marital.isEmpty() || email.isEmpty()
                        || address.isEmpty() || state.isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "All Fields Are Mandatory");
                } else {
                    Con con = new Con();
                    String q = "insert into User values('" + formNo + "','" + name + "','" + fatherName + "','" + dob + "','" + gender + "','" + marital + "','" + email + "','" + address + "','" + state + "')";
                    con.statement.executeUpdate(q);
                    new SignUp2(formNo, textFieldName);
                    setVisible(false);
                }

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(SignUp.this, "All Fields Are Mandatory");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource()==cancelButton) {
            new Login();
            setVisible(false);

        }


    }

    public static void main(String[] args) {
        new SignUp();

    }


}
