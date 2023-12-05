package Ceasar_App;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
public class RegistrationFrame extends JFrame{
private JTextField usernameField;


private JTextField txtUsername;
private JPasswordField passwordField_1;
private JButton btnRegister;
public RegistrationFrame() {
	getContentPane().setBackground(new Color(255, 0, 0));
    setTitle("Registration");
    setSize(866, 615);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    getContentPane().setLayout(null);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(255, 0, 0));
    panel.setBounds(134, 111, 570, 377);
    panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
    getContentPane().add(panel);
    panel.setLayout(null);
  

    // Continue adding components for username, password, email, and registration button
    // Add JLabels, JTextFields, JPasswordFields, JButton for registration, and set their positions and sizes accordingly
    
    // Don't forget to set up action listeners for the registration button
    JButton btnRegister = new JButton("Register");
    btnRegister.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Retrieve information from fields
            String username = txtUsername.getText();
            String password = new String(passwordField_1.getPassword());
         

          
            
            // Insert new user into the database
            CeasarUser newUser = new CeasarUser(username, password);
            CeasarUserDAO userDao = new CeasarUserDAO();

            boolean registrationSuccess = userDao.insertCeasarUser(newUser);

            if (registrationSuccess) {
                // Inform the user about successful registration
                JOptionPane.showMessageDialog(null, "Registration successful!");
            } else {
                // Inform the user about registration failure
                JOptionPane.showMessageDialog(null, "Registration failed. Please try again.");
            }
        }
    });
    btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
    btnRegister.setBounds(119, 300, 329, 51);
    panel.add(btnRegister);
    
    JLabel lblUsername = new JLabel("Username");
    lblUsername.setForeground(new Color(255, 255, 255));
    lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
    lblUsername.setBounds(63, 63, 107, 51);
    panel.add(lblUsername);
  
    
    txtUsername = new JTextField();
    txtUsername.setBounds(195, 69, 329, 42);
    panel.add(txtUsername);
    txtUsername.setColumns(10);
    
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setForeground(new Color(255, 255, 255));
    lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
    lblPassword.setBounds(63, 185, 107, 51);
    panel.add(lblPassword);
    
    passwordField_1 = new JPasswordField();
    passwordField_1.setBounds(195, 191, 329, 42);
    panel.add(passwordField_1);
    
    JLabel lblNewLabel_1 = new JLabel("Enter your new account information!");
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setBackground(new Color(255, 255, 255));
    lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
    lblNewLabel_1.setBounds(63, 30, 353, 22);
    panel.add(lblNewLabel_1);
    
    JLabel Title = new JLabel("Register a new account today!");
    Title.setForeground(new Color(255, 255, 255));
    Title.setFont(new Font("Times New Roman", Font.BOLD, 30));
    Title.setBounds(211, 51, 386, 53);
    getContentPane().add(Title);

  
}
public JButton getRegisterButton() {
    return btnRegister;
}
}
