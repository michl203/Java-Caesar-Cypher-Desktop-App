package Ceasar_App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
public class DecryptionPanel extends JPanel{
	private JTextField txtPhraseID;
	private JTable table;
	private CeasarUserDAO UserDAO = new CeasarUserDAO();
	private LoginFrame loginFrame = new LoginFrame(UserDAO);
	private CeasarDecryption cd;
	private JTextField txtCN;
	private int loggedInUserID;
	private JTextField txtUsername;
	public DecryptionPanel() {
      initializeComponents();     
    }
	
		  private void initializeComponents() {
			  setBackground(new Color(169, 169, 169));
				
				setLayout(null);
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 215, 0));
				panel.setBounds(41, 71, 1008, 638);
				panel.setBorder(new TitledBorder(null, "Decryption ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				add(panel);
				panel.setLayout(null);
				
		        final JTextArea textDecrypted = new JTextArea();
				textDecrypted.setBounds(10, 55, 344, 376);
				panel.add(textDecrypted);
				
				JLabel lblEncryptedText = new JLabel("Decrypted Text");
				lblEncryptedText.setBounds(104, 11, 139, 38);
				lblEncryptedText.setFont(new Font("Times New Roman", Font.BOLD, 20));
				panel.add(lblEncryptedText);
				
				JButton btnNewButton = new JButton("Decrypt Text/Read Encrypted Text");
				btnNewButton.setBounds(461, 506, 358, 65);
				btnNewButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				       
				     //Get chosen phraseId from the user.
				    	int phraseID = Integer.parseInt(txtPhraseID.getText());
				       
				    //Call the retrievePhrase method from CeasarUserDAO class
				    	String PhraseText = UserDAO.retrievePhrases(phraseID);
				       
				    //Decrypt the phrase from the database using the CeasarDecrypt method.
				        int ceasarnum = Integer.parseInt(txtCN.getText());
				    	cd = new CeasarDecryption(PhraseText, ceasarnum);
				    	String PhraseTextDecrypt = cd.CeasarDecrypt(PhraseText, ceasarnum);
				    //Set the JTextArea with the decrypted text
				     textDecrypted.setText(PhraseTextDecrypt);
				    
				    }
				    
				});
				btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
				panel.add(btnNewButton);
				
				JLabel lblNewLabel_2 = new JLabel("Enter PhraseID To Decrypt");
				lblNewLabel_2.setBounds(10, 442, 237, 52);
				lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
				panel.add(lblNewLabel_2);
				
				txtPhraseID = new JTextField();
				txtPhraseID.setBounds(230, 451, 69, 38);
				panel.add(txtPhraseID);
				txtPhraseID.setColumns(10);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(372, 21, 591, 474);
				panel.add(panel_2);
			    panel_2.setLayout(null);
			        
			    // Create the table
			    table = new JTable();
			        	        
			    JScrollPane scrollPane = new JScrollPane();
			    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			    scrollPane.setBounds(0, 0, 591, 474);
			    panel_2.add(scrollPane);
			    scrollPane.setViewportView(table);
			        	        
			    JLabel txtCeasarNum = new JLabel("Enter your Ceasar Number");
			    txtCeasarNum.setFont(new Font("Times New Roman", Font.BOLD, 18));
			    txtCeasarNum.setBounds(10, 511, 215, 43);
			    panel.add(txtCeasarNum);
			        	        
			    txtCN = new JTextField();
			    txtCN.setColumns(10);
			    txtCN.setBounds(230, 515, 69, 38);
			    panel.add(txtCN);
			        	        
			        	        JLabel lblEnterYourUsername = new JLabel("Enter your username");
			        	        lblEnterYourUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
			        	        lblEnterYourUsername.setBounds(10, 575, 169, 15);
			        	        panel.add(lblEnterYourUsername);
			        	        
			        	        txtUsername = new JTextField();
			        	        txtUsername.setColumns(10);
			        	        txtUsername.setBounds(179, 565, 120, 38);
			        	        panel.add(txtUsername);
			        	        
			        	        JTextArea textID = new JTextArea();
			        	        textID.setBounds(315, 565, 63, 36);
			        	        panel.add(textID);
			        	        
			        	        JLabel lblNewLabel = new JLabel("Your ID");
			        	        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
			        	        lblNewLabel.setBounds(320, 544, 69, 14);
			        	        panel.add(lblNewLabel);
			        	        
			        	        JButton btnGetID = new JButton("Get ID");
			        	        btnGetID.addActionListener(new ActionListener(){
			        	        	public void actionPerformed(ActionEvent e) {
			     				       
			       				     //Get the users username from text field.
			       				    	String userName = txtUsername.getText();
			       				       
			       				    //Call the getUserIDByUsername method from the UserDAO class
			       				    	int ID = UserDAO.getUserIDByUsername(userName);
			       				       
			       				    //Set the JTextArea textID with the parsed integer value of userID
			       				   String  userID = Integer.toString(ID);
			       				      textID.setText(userID);
			       				    }
			       				    
			       				});
			        	        
			        	        btnGetID.setFont(new Font("Times New Roman", Font.BOLD, 18));
			        	        btnGetID.setBounds(47, 604, 89, 23);
			        	        panel.add(btnGetID);
			        	        table_load();
			     
			    JLabel lblNewLabel_1 = new JLabel("Decryption Tool");
			    lblNewLabel_1.setBounds(410, 28, 248, 38);
				lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
				add(lblNewLabel_1);
			}
		    
	
	      public void table_load() {
	       
	            try {
	            Connection connection = UserDAO.getConnection();
	            String selectSQL = "SELECT PhraseID as 'Phrase ID', UserID as 'User ID'"
	            + ", Phrase_Text as 'Phrases', Creation_Date as 'Date Created' FROM user_phrases";
	            PreparedStatement prepareStatement = connection.prepareStatement(selectSQL);
	           
	            ResultSet rs = prepareStatement.executeQuery();

	            // Assuming "table" is the reference to your JTable
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	           
	             } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error loading data from the database.");
	        }
	    
	       
	    }
	}
	


