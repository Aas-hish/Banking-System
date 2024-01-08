package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    JLabel jLabel1, jLabel2;
    String pin;
    JButton back;
    JScrollPane jScrollPane;

    MiniStatement(String pin) {

        this.pin = pin;

        jLabel1 = new JLabel("Statement");
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 32));
        jLabel1.setBounds(320, 30, 200, 30);
        add(jLabel1);

        jLabel2 = new JLabel();
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 18));
        jLabel2.setBounds(100, 100, 500, 350);
        add(jLabel2);

        jScrollPane = new JScrollPane(jLabel2);
        jScrollPane.setBounds(100, 100, 500, 300);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(jScrollPane);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.LIGHT_GRAY);
        back.setFont(new Font("Arial", Font.PLAIN, 18));
        back.setBounds(550, 420, 120, 30);
        back.addActionListener(this);
        add(back);


        try {
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from deposit where pin_no = '" + this.pin + "'");
            while (resultSet.next()) {
                jLabel2.setText(jLabel2.getText() + "<html>" +"&nbsp;&nbsp;"+ "You " + resultSet.getString("type") + "&nbsp;&nbsp;" + resultSet.getString("Amount") + "&nbsp;&nbsp;" + "on " + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "<br><br><html>");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }



        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bgsignup.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(0, 0, 800, 500);
        add(jLabel);

        //Setting up frame
        setLayout(null);
//        setUndecorated(true);
        setSize(800, 500);
        setLocation(380, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Main_Class(pin);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }


}
