package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Email_Transfer extends JFrame implements ActionListener {

    JLabel jLabel,jLabel1;
    JTextField email;

    JButton next,backButton;
    String pin;
    public Email_Transfer(String pin){

        this.pin=pin;

        jLabel=new JLabel("Transfer Money");
        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("Arial",Font.BOLD,24));
        jLabel.setBounds(320, 100, 500, 30);
        add(jLabel);


        jLabel1=new JLabel("Enter your email:");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Arial",Font.PLAIN,18));
        jLabel1.setBounds(250, 150, 500, 30);
        add(jLabel1);

        email=new JTextField(15);
        email.setFont(new Font("Arial",Font.PLAIN,16));
        email.setBounds(250, 190, 300, 30);
        add(email);

        next=new JButton("Next");
        next.setForeground(Color.BLACK);
        next.setBackground(Color.LIGHT_GRAY);
        next.setFont(new Font("Arial",Font.PLAIN,18));
        next.setBounds(480, 240, 100, 30);
        next.addActionListener(this);
        add(next);

        backButton=new JButton("Back");
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFont(new Font("Arial",Font.PLAIN,16));
        backButton.setBounds(360,240,100,30);
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
        if (e.getSource()==next){
            String Email=email.getText();
            if (Email.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter email!");
            }else {
                new Transfer(pin);
                setVisible(false);
            }
        } else if (e.getSource()==backButton) {
            new Main_Class(pin);
            setVisible(false);

        }

    }
    public static void main(String[] args) {
        new Email_Transfer("");

    }


}
