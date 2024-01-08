package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel jLabel1, jLabel2, jLabel3;
    JTextField jTextField;
    JPasswordField jPasswordField;
    JButton button1, button2, button3;

    Login() {
        super("Bank Management System");

        //Setting up text
        jLabel1 = new JLabel("Welcome To Bank");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Monotype Corsiva", Font.BOLD, 44));
        jLabel1.setBounds(450, 30, 400, 40);
        add(jLabel1);

        jLabel2 = new JLabel("Account No: ");
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 28));
        jLabel2.setBounds(400, 90, 200, 30);
        add(jLabel2);

        jTextField = new JTextField(15);
        jTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        jTextField.setBounds(570, 90, 200, 30);
        add(jTextField);

        jLabel3 = new JLabel("PIN: ");
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 28));
        jLabel3.setBounds(450, 140, 200, 30);
        add(jLabel3);

        jPasswordField = new JPasswordField(15);
        jPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        jPasswordField.setBounds(570, 140, 200, 30);
        add(jPasswordField);

        button1 = new JButton("SIGN IN");
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.LIGHT_GRAY);
        button1.setFont(new Font("Arial", Font.PLAIN, 14));
        button1.setBounds(500, 200, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.LIGHT_GRAY);
        button2.setFont(new Font("Arial", Font.PLAIN, 14));
        button2.setBounds(630, 200, 100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.LIGHT_GRAY);
        button3.setFont(new Font("Arial", Font.PLAIN, 14));
        button3.setBounds(500, 240, 230, 30);
        button3.addActionListener(this);
        add(button3);


        //Setting Background into frame
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/background.png"));
        Image image = imageIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(0, 0, 800, 500);
        add(jLabel);

        //setting up frame
        setLayout(null);
        setSize(800, 500);
        setLocation(380, 150);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                String accountNum=jTextField.getText();
                String pin=jPasswordField.getText();

                if (accountNum.isBlank() || pin.isBlank()) {
                    JOptionPane.showMessageDialog(Login.this, "Fill both details!");
                } else {
                    Con con=new Con();
                    String q = "select * from login where card_no = '"+accountNum+"'and pin_no = '"+pin+"'";
                    ResultSet resultSet= con.statement.executeQuery(q);
                    if (resultSet.next()){
                        new Main_Class(pin);
                        setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Invalid Account Number or Pin Number!");
                    }

                }

            } else if (e.getSource() == button2) {
                jTextField.setText("");
                jPasswordField.setText("");

            } else if (e.getSource() == button3) {
               new SignUp();
               setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();

    }


}
