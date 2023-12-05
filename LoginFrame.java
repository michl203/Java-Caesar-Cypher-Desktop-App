package Ceasar_App;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField passwordField;
    private JButton btnRegister;
    private JButton btnLogin;
    private CeasarUserDAO userDao;
    public LoginFrame(CeasarUserDAO userDao) {
    	getContentPane().setBackground(new Color(255, 0, 0));
        this.userDao = userDao;
        setTitle("Login");
        setSize(866, 615);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 0, 0));
        panel.setBounds(134, 111, 538, 367);
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblUsername.setBounds(44, 53, 94, 46);
        panel.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(177, 55, 329, 46);
        panel.add(txtUsername);
        txtUsername.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblPassword.setBounds(44, 162, 94, 46);
        panel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(177, 164, 329, 46);
        panel.add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnLogin.setBounds(177, 247, 329, 51);
        panel.add(btnLogin);
        btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create an instance of the RegistrationFrame
                RegistrationFrame registrationFrame = new RegistrationFrame();
                // Make the registrationFrame visible
                registrationFrame.setVisible(true);
            }
        });
        btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnRegister.setBounds(224, 305, 235, 51);
        panel.add(btnRegister);
        
        JLabel lblNewLabel_2 = new JLabel("New? Create an account!");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(19, 316, 195, 31);
        panel.add(lblNewLabel_2);
       

        JLabel lblNewLabel_1 = new JLabel("Ceasar Cypher Application");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblNewLabel_1.setBounds(232, 57, 357, 40);
        getContentPane().add(lblNewLabel_1);
    }

    public JButton getLoginBut() {
        return btnLogin;
    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

   
}
