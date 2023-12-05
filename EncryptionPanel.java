package Ceasar_App;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EncryptionPanel extends JPanel {
	// Reference to LoginFrame
	private LoginFrame loginFrame;
	private JTextField txtCeasarNum;

	

    
	
      public EncryptionPanel(final LoginFrame loginFrame) {
      	setBackground(new Color(169, 169, 169));
            this.loginFrame = loginFrame; // Assign the passed LoginFrame instance
            setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBorder(new TitledBorder(null, "Encryption ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(52, 71, 755, 616);
		add(panel);
		panel.setLayout(null);
		
		final JTextArea txtPlain = new JTextArea();
		txtPlain.setBounds(10, 55, 344, 376);
		panel.add(txtPlain);
		
		final JTextArea txtEncryted = new JTextArea();
		txtEncryted.setBounds(401, 55, 344, 376);
		panel.add(txtEncryted);
		
		JLabel lblNewLabel = new JLabel("Plain Text");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(123, 11, 111, 38);
		panel.add(lblNewLabel);
		
		JLabel lblEncryptedText = new JLabel("Encrypted Text");
		lblEncryptedText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEncryptedText.setBounds(481, 11, 139, 38);
		panel.add(lblEncryptedText);
		
		JButton btnEncrypt = new JButton("Encrypt Text/ Save Encrypted Text");
		btnEncrypt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        CeasarUserDAO ce = new CeasarUserDAO();
		     // Get the username from a text field of Login Frame Class
		        String username = loginFrame.getUsername();
		    	
		       int userID =  ce.getUserIDByUsername(username);// Replace 'yourUsernameField' with your actual username input field
		        
		        // Get the text to encrypt from a text field or any input source
		        String textToEncrypt = txtPlain.getText(); // Replace 'yourTextField' with your actual text field
                //Get CeasarNum from user!
	            int ceasarnum =  Integer.parseInt(txtCeasarNum.getText());
		        // Get the user's ID based on the username using the method you provided
		        int userId = ce.getUserIDByUsername(username);

		        if (userId != -1) {
		            // User ID retrieved successfully, proceed with encryption and insertion
		            CeasarEncryption enc = new CeasarEncryption(textToEncrypt, ceasarnum); // Instantiate your encryption helper class
		            // Perform encryption
		            String encryptedTxt = enc.CeasarEncrypt(textToEncrypt, ceasarnum);
		          
		            // Set the encrypted text in the txtEncrypted JTextArea
		            txtEncryted.setText(encryptedTxt);
		            // Insert the encrypted text into the database using the obtained user ID
		            boolean insertionSuccess = ce.insertPhrases(encryptedTxt, userId);
                    
		            if (insertionSuccess) {
		                // Successful insertion
		            	 JOptionPane.showMessageDialog(null, "Phrase inserted successfully");
		                // You can add further actions or notifications here
		            } else {
		                // Insertion failed
		            	JOptionPane.showMessageDialog(null, "Error. The phrase was not entered! " );
		                // Handle the failure or provide feedback to the user
		            }
		        } else {
		            // User not found or error while retrieving user ID
		            System.out.println("User not found or error retrieving user ID.");
		            // Handle the scenario where the user is not found or there's an error
		        }
		    }
		});
		btnEncrypt.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnEncrypt.setBounds(10, 472, 504, 65);
		panel.add(btnEncrypt);
		
		txtCeasarNum = new JTextField();
		txtCeasarNum.setBounds(564, 487, 154, 47);
		panel.add(txtCeasarNum);
		txtCeasarNum.setColumns(10);
		
		JLabel lblNum = new JLabel("Choose Ceasar Number!");
		lblNum.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNum.setBounds(557, 442, 173, 34);
		panel.add(lblNum);
		
		JButton btnHelp = new JButton("Need Help?");
		btnHelp.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "You need to enter your text in the plain text area."
		    + " Then, after that you need choose a Ceasar Number (between 1-5) to use in the encryption process.\n"
		    + "Be sure to remember your number for decryption purposes since this application will not store it!");		    	
		        }
		    });
		btnHelp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHelp.setBounds(564, 545, 156, 38);
		panel.add(btnHelp);
		
		JLabel lblNewLabel_1 = new JLabel("Encryption Tool");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel_1.setBounds(310, 32, 248, 38);
		add(lblNewLabel_1);
	}
}
