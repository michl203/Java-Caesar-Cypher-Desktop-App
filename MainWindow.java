package Ceasar_App;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
	  private JTabbedPane tabbedPane;
	  private CeasarUserDAO userDao;
	  private JButton btnRegister;
	  private LoginFrame loginFrame;
	  private int loggedInUserID;
	    private boolean validateUserCredentials(String username, String password) {
	        int userID = userDao.getUserIDByUsername(username);

	        if (userID != -1) {
	            String storedPasswordHash = userDao.getUserPasswordHashFromDB(userID);

	            if (storedPasswordHash != null) {
	                // Hash the entered password for comparison
	            	// Instantiate CeasarUser and call hashPassword
	            	String enteredPasswordHash = new CeasarUser(username, password).hashPassword(password); 
	             
	                return enteredPasswordHash.equals(storedPasswordHash);
	            }
	        }

	        return false; // User not found or password retrieval error
	    }
	  
	
	  public MainWindow() {
		    
	        setTitle("Ceasar Cypher Application");
	        setSize(949, 721);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        userDao = new CeasarUserDAO();
	        initializeComponents();
	        addComponentsToFrame();
	    }

	    private void initializeComponents() {
	        tabbedPane = new JTabbedPane();
	        loginFrame = new LoginFrame(userDao);
	      
	     // Create instances of your panels
	    EncryptionPanel encryptionPanel = new EncryptionPanel(loginFrame);
	    DecryptionPanel decryptionPanel = new DecryptionPanel();
	    //Add panels to tabs
	    tabbedPane.addTab("Encryption", encryptionPanel);
	    tabbedPane.addTab("Decryption", decryptionPanel);
	    getContentPane().add(tabbedPane);
	    }
	    
	    private void addComponentsToFrame() {
	        getContentPane().add(tabbedPane, BorderLayout.CENTER);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            
	            final MainWindow mainWindow = new MainWindow(); // Create an instance of MainWindow
             
	            // Adding ActionListener for the login button using the loginFrame instance created in MainWindow
	                mainWindow.loginFrame.getLoginBut().addActionListener(e -> {
	                String username = mainWindow.loginFrame.getUsername();
	                String password = mainWindow.loginFrame.getPassword();

	              
	                boolean isAuthenticated = mainWindow.validateUserCredentials(username, password);

	                if (isAuthenticated) {
	                	JOptionPane.showMessageDialog(null, "Successful Login!");
	                    mainWindow.setVisible(true); // Show the MainWindow after successful authentication
	                    mainWindow.loginFrame.dispose();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
	                }
	            });
	            mainWindow.loginFrame.setVisible(true); // Show the login frame
	        });
	    }
	}



