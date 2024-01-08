package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance_Inquiry extends JFrame implements ActionListener {
    JLabel jLabel;
    String pin;
    JButton back;
    Balance_Inquiry(String pin){
        this.pin=pin;

        int balance=0;
        try {
            Con con = new Con();
            ResultSet resultSet = con.statement.executeQuery("select * from deposit where pin_no = '"+pin+"'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        jLabel=new JLabel("Your Current Balance is " +"\n"+ balance);
        jLabel.setForeground(Color.BLACK);
        jLabel.setFont(new Font("Arial",Font.BOLD,22));
        jLabel.setBounds(220,140,500,30);
        add(jLabel);

        back=new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.LIGHT_GRAY);
        back.setFont(new Font("Arial", Font.PLAIN, 18));
        back.setBounds(450, 240, 120, 30);
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
    public void actionPerformed(ActionEvent E) {
        try {
            if (E.getSource()==back){
                new Main_Class(pin);
                setVisible(false);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Balance_Inquiry("");
    }


}
