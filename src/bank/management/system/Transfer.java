package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transfer extends JFrame implements ActionListener {

    JLabel jLabel, jLabel1;
    JTextField amount, accNum;
    JButton transfer,back;
    String pin;
    Transfer(String pin) {

        this.pin=pin;

        jLabel = new JLabel("Transfer Money");
        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("Arial", Font.BOLD, 24));
        jLabel.setBounds(320, 90, 500, 30);
        add(jLabel);

        jLabel1 = new JLabel("Enter Account Number:");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 18));
        jLabel1.setBounds(220, 120, 500, 30);
        add(jLabel1);

        jLabel1 = new JLabel("(must be 16 digits)");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        jLabel1.setBounds(410, 120, 200, 30);
        add(jLabel1);

        accNum = new JTextField(15);
        accNum.setFont(new Font("Arial", Font.PLAIN, 16));
        accNum.setBounds(220, 160, 250, 30);
        add(accNum);

        jLabel1 = new JLabel("Enter Amount:");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 18));
        jLabel1.setBounds(220, 200, 500, 30);
        add(jLabel1);

        amount = new JTextField(15);
        amount.setFont(new Font("Arial", Font.PLAIN, 16));
        amount.setBounds(220, 240, 250, 30);
        add(amount);

        transfer = new JButton("Transfer");
        transfer.setForeground(Color.BLACK);
        transfer.setBackground(Color.LIGHT_GRAY);
        transfer.setFont(new Font("Arial", Font.PLAIN, 18));
        transfer.setBounds(490, 240, 120, 30);
        transfer.addActionListener(this);
        add(transfer);

        back=new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.LIGHT_GRAY);
        back.setFont(new Font("Arial", Font.PLAIN, 18));
        back.setBounds(490, 190, 120, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image image = imageIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(0, 0, 800, 500);
        add(jLabel);

        setLayout(null);
        setUndecorated(true);
        setSize(800, 500);
        setLocation(380, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == transfer) {
                String accountNo = accNum.getText();
                String Amount = amount.getText();
                Date date = new Date();

                if (accountNo.isEmpty() || Amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill both fields");
                } else {
                    if (!checkAccountValid(accountNo)) {
                        JOptionPane.showMessageDialog(null, "Invalid Account Number");
                    } else {
                        Con con = new Con();
                        ResultSet resultSet=con.statement.executeQuery("select * from deposit where pin_no='"+pin+"'");
                        int balance=0;
                        while (resultSet.next()) {
                            if (resultSet.getString("type").equals("Deposit")){
                                balance += Integer.parseInt(resultSet.getString("Amount"));
                            }else {
                                balance -= Integer.parseInt(resultSet.getString("Amount"));
                            }
                        }
                        if (balance<Integer.parseInt(Amount)){
                            JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        }else {
                            con.statement.executeUpdate("insert into deposit values('" + pin + "','" + date + "','Transfer','" + Amount + "')");
                            JOptionPane.showMessageDialog(null, "Rs." + Amount + " transfer successfully");
                            setVisible(false);
                            new Main_Class(pin);
                        }

                    }
                }

            } else if (e.getSource()==back) {
                new Main_Class(pin);
                setVisible(false);

            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    private boolean checkAccountValid(String accountNo) {

        String regex = "^[0-9]{16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(accountNo);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new Transfer("");
    }


}
