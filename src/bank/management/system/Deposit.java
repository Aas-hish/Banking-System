package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener {
    JLabel jLabel1;
    JTextField depositAmt;

    JButton depositButton,backButton;

    String pinNo;

    public Deposit(String pinNo) {
        super("Deposit");

        this.pinNo=pinNo;


        jLabel1 = new JLabel("Enter Amount To Deposit");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 24));
        jLabel1.setBounds(270, 100, 500, 30);
        add(jLabel1);

        depositAmt=new JTextField(20);
        depositAmt.setFont(new Font("Arial", Font.BOLD, 16));
        depositAmt.setBounds(290, 150, 250, 30);
        add(depositAmt);

        depositButton=new JButton("Deposit");
        depositButton.setForeground(Color.BLACK);
        depositButton.setBackground(Color.LIGHT_GRAY);
        depositButton.setFont(new Font("Arial",Font.PLAIN,16));
        depositButton.setBounds(450,200,150,30);
        depositButton.addActionListener(this);
        add(depositButton);

        backButton=new JButton("Back");
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Arial",Font.PLAIN,16));
        backButton.setBounds(450,240,150,30);
        backButton.addActionListener(this);
        add(backButton);



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
            String amount=depositAmt.getText();
            Date date=new Date();
            if (e.getSource()==depositButton){
                if (amount.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter amount!");
                }
                else {
                    Con con=new Con();
                    String q="insert into deposit values('"+pinNo+"','"+date+"','Deposit','"+amount+"')";
                    con.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Amount: "+amount+"\nDeposited Successfully");
                    depositAmt.setText("");
                }
            } else if (e.getSource()==backButton) {

                new Main_Class(pinNo);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new Deposit("");
    }


}
