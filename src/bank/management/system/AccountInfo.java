package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class AccountInfo extends JFrame implements ActionListener {
    String pin;
    JButton backButton;
    String accountNum,accountType,holderName;
    JLabel jLabel,jLabel1,jLabel2,jLabel3;
    AccountInfo(String pin){
        this.pin=pin;

        try {
            Con con=new Con();
            ResultSet resultSet=con.statement.executeQuery("select * from User2 where pin_no = '"+pin+"'");
            if (resultSet.next()){
                accountNum = resultSet.getNString("card_no");
                accountType = resultSet.getNString("account_type");
            }
            ResultSet resultSet1=con.statement.executeQuery("select * from login where pin_no = '"+pin+"'");
            if (resultSet1.next()){
                holderName = resultSet1.getNString("name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        jLabel=new JLabel("Account Details");
        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("Arial",Font.BOLD,24));
        jLabel.setBounds(340,100,200,30);
        add(jLabel);

        jLabel3=new JLabel("Holder Name :  "+ holderName);
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setFont(new Font("Arial",Font.PLAIN,18));
        jLabel3.setBounds(250,140,400,30);
        add(jLabel3);

        jLabel1=new JLabel("Account Number :  "+ accountNum);
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Arial",Font.PLAIN,18));
        jLabel1.setBounds(250,170,400,30);
        add(jLabel1);

        jLabel2=new JLabel("Account Type :  "+ accountType);
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setFont(new Font("Arial",Font.PLAIN,18));
        jLabel2.setBounds(250,200,400,30);
        add(jLabel2);

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
            if (e.getSource()==backButton){
                new Main_Class(pin);
                setVisible(false);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AccountInfo("");

    }


}
