package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp2 extends JFrame implements ActionListener {
    JLabel form, jLabel1, lineLabel, jLabel2, panNum, adharNum, account, accountNum, pin, pinNum, accType;
    JTextField textFieldPan, textFieldAdhar;
    JRadioButton saving, fixDeposit, currentAcc, recDepositAcc;
    JButton submitButton, cancelButton;
    ButtonGroup buttonGroup;
    long formNo;
    String name;

    SignUp2(long formNo, JTextField textFieldName) {
        super("User Details");

        this.formNo = formNo;
        this.name=textFieldName.getText();



        form = new JLabel("Form No: " + formNo);
        form.setForeground(Color.BLACK);
        form.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        form.setBounds(530, 30, 500, 30);
        add(form);

        jLabel1 = new JLabel("Application Form ");
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setFont(new Font("Monotype Corsiva", Font.BOLD, 38));
        jLabel1.setBounds(230, 30, 500, 30);
        add(jLabel1);

        lineLabel = new JLabel("_____________________________");
        lineLabel.setForeground(Color.BLACK);
        lineLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        lineLabel.setBounds(230, 40, 500, 30);
        add(lineLabel);

        jLabel2 = new JLabel("Additional Detail:");
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 18));
        jLabel2.setBounds(100, 70, 200, 30);
        add(jLabel2);

        panNum = new JLabel("PAN Number:");
        panNum.setForeground(Color.BLACK);
        panNum.setFont(new Font("Arial", Font.PLAIN, 18));
        panNum.setBounds(40, 110, 200, 30);
        add(panNum);

        textFieldPan = new JTextField(15);
        textFieldPan.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldPan.setBounds(170, 110, 300, 30);
        add(textFieldPan);

        adharNum = new JLabel("Aadhaar No:");
        adharNum.setForeground(Color.BLACK);
        adharNum.setFont(new Font("Arial", Font.PLAIN, 18));
        adharNum.setBounds(40, 150, 200, 30);
        add(adharNum);

        textFieldAdhar = new JTextField(15);
        textFieldAdhar.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldAdhar.setBounds(170, 150, 300, 30);
        add(textFieldAdhar);

        account = new JLabel("Account No:");
        account.setForeground(Color.BLACK);
        account.setFont(new Font("Arial", Font.PLAIN, 18));
        account.setBounds(40, 210, 200, 30);
        add(account);

        accountNum = new JLabel("XXXX-XXXX-XXXX-0010");
        accountNum.setForeground(Color.BLACK);
        accountNum.setFont(new Font("Arial", Font.PLAIN, 18));
        accountNum.setBounds(170, 210, 300, 30);
        add(accountNum);

        accountNum = new JLabel("(Account number must be 16 digits)");
        accountNum.setForeground(Color.BLACK);
        accountNum.setFont(new Font("Arial", Font.PLAIN, 14));
        accountNum.setBounds(170, 230, 300, 30);
        add(accountNum);

        pin = new JLabel("PIN No:");
        pin.setForeground(Color.BLACK);
        pin.setFont(new Font("Arial", Font.PLAIN, 18));
        pin.setBounds(40, 270, 200, 30);
        add(pin);

        pinNum = new JLabel("XXXX");
        pinNum.setForeground(Color.BLACK);
        pinNum.setFont(new Font("Arial", Font.PLAIN, 18));
        pinNum.setBounds(170, 270, 300, 30);
        add(pinNum);

        pinNum = new JLabel("(Pin must be 4 digits)");
        pinNum.setForeground(Color.BLACK);
        pinNum.setFont(new Font("Arial", Font.PLAIN, 14));
        pinNum.setBounds(170, 290, 300, 30);
        add(pinNum);

        accType = new JLabel("Account Type:");
        accType.setForeground(Color.BLACK);
        accType.setFont(new Font("Arial", Font.PLAIN, 18));
        accType.setBounds(40, 330, 200, 30);
        add(accType);

        saving = new JRadioButton("Saving Account");
        saving.setForeground(Color.BLACK);
        saving.setOpaque(false);
        saving.setFont(new Font("Arial", Font.PLAIN, 16));
        saving.setBounds(45, 360, 150, 30);
        add(saving);

        fixDeposit = new JRadioButton("Fix Deposit");
        fixDeposit.setForeground(Color.BLACK);
        fixDeposit.setOpaque(false);
        fixDeposit.setFont(new Font("Arial", Font.PLAIN, 16));
        fixDeposit.setBounds(210, 360, 150, 30);
        add(fixDeposit);

        currentAcc = new JRadioButton("Current Account");
        currentAcc.setForeground(Color.BLACK);
        currentAcc.setOpaque(false);
        currentAcc.setFont(new Font("Arial", Font.PLAIN, 16));
        currentAcc.setBounds(45, 390, 150, 30);
        add(currentAcc);

        recDepositAcc = new JRadioButton("Recurring Deposit Account");
        recDepositAcc.setForeground(Color.BLACK);
        recDepositAcc.setOpaque(false);
        recDepositAcc.setFont(new Font("Arial", Font.PLAIN, 16));
        recDepositAcc.setBounds(210, 390, 250, 30);
        add(recDepositAcc);

        buttonGroup=new ButtonGroup();
        add(saving);
        add(currentAcc);
        add(fixDeposit);
        add(recDepositAcc);



        submitButton = new JButton("SUBMIT");
        submitButton.setForeground(Color.BLACK);
        submitButton.setBackground(Color.LIGHT_GRAY);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        submitButton.setBounds(600, 390, 100, 40);
        submitButton.addActionListener(this);
        add(submitButton);

        cancelButton = new JButton("CANCEL");
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBackground(Color.LIGHT_GRAY);
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cancelButton.setBounds(450, 390, 100, 40);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image image1 = imageIcon3.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image1);
        JLabel jLabel1 = new JLabel(imageIcon2);
        jLabel1.setBounds(500, 150, 250, 200);
        add(jLabel1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bgsignup.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(0, 0, 800, 500);
        add(jLabel);

        setLayout(null);
        setSize(800, 500);
        setLocation(380, 150);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            long formNO = formNo;
            String panNo = textFieldPan.getText();
            String aadharNo = textFieldAdhar.getText();

            Random random = new Random();
            long cn = (random.nextLong() % 90000000L) + 143271000000000L;
            String cardNo = "" + Math.abs(cn);

            long pn = (random.nextLong() % 9000) + 1000;
            String pinNo = "" + Math.abs(pn);

            String accountType = null;
            if (saving.isSelected()) {
                accountType = "Saving Account";
            } else if (fixDeposit.isSelected()) {
                accountType = "Fix Deposit";
            } else if (currentAcc.isSelected()) {
                accountType = "Current Account";
            } else if (recDepositAcc.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            try {
                if (panNo.isEmpty() || aadharNo.isEmpty() || accountType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Fields Are Mandatory");
                } else {
                    Con con=new Con();
                    String q = "insert into User2 values('" + formNo + "','" + panNo + "','" + aadharNo + "','" + cardNo + "','" + pinNo + "','" + accountType + "')";
                    String l = "insert into login values('" + formNo + "','"+name+"','" + cardNo + "','" + pinNo + "')";
                    con.statement.executeUpdate(q);
                    con.statement.executeUpdate(l);
                    JOptionPane.showMessageDialog(null,"Account No: "+cardNo+"\nPin No: "+pinNo);
                    new Deposit(pinNo);
                    setVisible(false);

                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "All Fields Are Mandatory");
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        else if (e.getSource()==cancelButton){
            new Login();
            setVisible(false);
        }

    }


    public static void main(String[] args) {
        new SignUp2(0,null);
    }

}
