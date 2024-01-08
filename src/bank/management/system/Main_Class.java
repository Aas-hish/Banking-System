package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    JLabel jLabel;

    JButton depositButton,transferButton,infoButton,statementButton,balanceButton,createAccButton,cancel;
    String pin;
    public Main_Class(String pin){
        this.pin=pin;


        jLabel=new JLabel("Please select the operation");
        jLabel.setFont(new Font("Arail",Font.BOLD,24));
        jLabel.setBounds(270, 100, 500, 30);
        jLabel.setForeground(Color.WHITE);
        add(jLabel);

        depositButton=new JButton("Deposit");
        depositButton.setForeground(Color.BLACK);
        depositButton.setBackground(Color.LIGHT_GRAY);
        depositButton.setFont(new Font("Arial",Font.PLAIN,16));
        depositButton.setBounds(220,150,150,30);
        depositButton.addActionListener(this);
        add(depositButton);

        statementButton=new JButton("Mini Statement");
        statementButton.setForeground(Color.BLACK);
        statementButton.setBackground(Color.LIGHT_GRAY);
        statementButton.setFont(new Font("Arial",Font.PLAIN,16));
        statementButton.setBounds(220,190,150,30);
        statementButton.addActionListener(this);
        add(statementButton);

        createAccButton=new JButton("Create Account");
        createAccButton.setForeground(Color.BLACK);
        createAccButton.setBackground(Color.LIGHT_GRAY);
        createAccButton.setFont(new Font("Arial",Font.PLAIN,16));
        createAccButton.setBounds(220,230,150,30);
        createAccButton.addActionListener(this);
        add(createAccButton);

        transferButton=new JButton("Transfer");
        transferButton.setForeground(Color.BLACK);
        transferButton.setBackground(Color.LIGHT_GRAY);
        transferButton.setFont(new Font("Arial",Font.PLAIN,16));
        transferButton.setBounds(450,150,150,30);
        transferButton.addActionListener(this);
        add(transferButton);

        balanceButton=new JButton("Balance Inquiry");
        balanceButton.setForeground(Color.BLACK);
        balanceButton.setBackground(Color.LIGHT_GRAY);
        balanceButton.setFont(new Font("Arial",Font.PLAIN,16));
        balanceButton.setBounds(450,190,150,30);
        balanceButton.addActionListener(this);
        add(balanceButton);

        infoButton=new JButton("Account Info");
        infoButton.setForeground(Color.BLACK);
        infoButton.setBackground(Color.LIGHT_GRAY);
        infoButton.setFont(new Font("Arial",Font.PLAIN,16));
        infoButton.setBounds(450,230,150,30);
        infoButton.addActionListener(this);
        add(infoButton);

        cancel=new JButton("Cancel");
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.LIGHT_GRAY);
        cancel.setFont(new Font("Arial",Font.PLAIN,16));
        cancel.setBounds(370,330,150,30);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
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
        try{
            if (e.getSource()==depositButton){
                new Deposit(pin);
                setVisible(false);
            } else if (e.getSource()==createAccButton) {
                new SignUp();
                setVisible(false);
            } else if (e.getSource()==transferButton) {
                new Email_Transfer(pin);
                setVisible(false);
            }else if (e.getSource()==balanceButton){
                new Balance_Inquiry(pin);
                setVisible(false);
            } else if (e.getSource()==infoButton) {
                new AccountInfo(pin);
                setVisible(false);
            } else if (e.getSource()==statementButton) {
                new MiniStatement(pin);
                setVisible(false);
            } else if (e.getSource()==cancel) {
                System.exit(0);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Main_Class("");

    }


}
