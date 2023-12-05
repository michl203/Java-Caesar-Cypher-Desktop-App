package Ceasar_App;
//Import Necessary libraries and packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class CeasarUserDAO2 {
private String dbUrl;
private String uName;
private String password;
//Holds the JDBC connection object!
private Connection con;


	//JDBC Connection Constructor
    public CeasarUserDAO2() {
	this.con= getConnection();
    }
					 
	//Method to establish the connection between application and MySQL database.
   public static Connection getConnection() {
    Connection con = null;
	String  dbUrl = "jdbc:mysql://localhost:3306/ceasar_cypher_app";
	String uName = "Your Username";
	String  password = "Your Password";

	    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection(dbUrl, uName, password);
		} catch (ClassNotFoundException | SQLException ex) {
	    ex.printStackTrace();}
         return con;
   }  
   
   //Methods related to user registration and user management
   
   //Method to insert User information into usercredentials table in ceasar_cypher_app database.
   //This is for registration purposes only!!! New users will be the ones interacting with this!!
   public boolean insertCeasarUser(CeasarUser ceasaruser) {
       try {
           String insertSql = "INSERT INTO usercredentials (Username, PasswordHash) VALUES (?, ?)";
           PreparedStatement prepareStatement = con.prepareStatement(insertSql);
           prepareStatement.setString(1, ceasaruser.getUserName());
           prepareStatement.setString(2, ceasaruser.getUserPasswordHash());
         
           prepareStatement.executeUpdate();
           return true;
       } catch (SQLException e) {
    	   JOptionPane.showMessageDialog(null, "Error. You were not registered. Try Again!");
           e.printStackTrace();
           return false;
       }
   }
   
   //Method to get userID based on username.
   public int getUserIDByUsername(String username) {
	    try {
	        String selectSql = "SELECT UserID FROM usercredentials WHERE Username = ?";
	        PreparedStatement prepareStatement = con.prepareStatement(selectSql);
	        prepareStatement.setString(1, username);

	        ResultSet resultSet = prepareStatement.executeQuery();
           
	        if (resultSet.next()) {
	            return resultSet.getInt("UserID"); // Return the retrieved UserID
	        }
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(null, "User ID was not found!");
	        e.printStackTrace();
	    }

	    return -1; // Return -1 to indicate user not found or error
	}
   
   //Method to retrieve user's hashed password for login validation purposes.
   public String getUserPasswordHashFromDB(int userID) {
       try {
           String selectSql = "SELECT PasswordHash FROM usercredentials WHERE UserID = ?";
           PreparedStatement prepareStatement = con.prepareStatement(selectSql);
           prepareStatement.setInt(1, userID);

           ResultSet resultSet = prepareStatement.executeQuery();

           if (resultSet.next()) {
               return resultSet.getString("PasswordHash"); // Return the retrieved PasswordHash
           }
       } catch (SQLException e) {
    	   JOptionPane.showMessageDialog(null, "The password was not found!!" );
           e.printStackTrace();
       }

       return null; // Return null if user not found or error in password retrieval
   }
   
   //Method to insert phrases into the database.
   public boolean insertPhrases(String phrase, int id) {
	   try {
           String insertSql = "INSERT INTO user_phrases (userID, Phrase_Text) VALUES (?, ?)";
           PreparedStatement prepareStatement = con.prepareStatement(insertSql);
           prepareStatement.setInt(1, id);
           prepareStatement.setString(2, phrase);
         
           prepareStatement.executeUpdate();
     
           return true;
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
   }
   
   //Method to retrieve user phrases.
   public String retrievePhrases(int phraseID) {
	    try {
	        String selectSql = "SELECT Phrase_Text FROM user_phrases WHERE PhraseID = ?";
	        PreparedStatement prepareStatement = con.prepareStatement(selectSql);
	        prepareStatement.setInt(1, phraseID);

	        ResultSet resultSet = prepareStatement.executeQuery();

	        if (resultSet.next()) {
	            return resultSet.getString("Phrase_Text"); // Return the retrieved Phrase_Text
	        } else {
	            // Handle cases where the phraseID does not exist
	        	 JOptionPane.showMessageDialog(null, "Phrase not found for the given ID: " + phraseID);
	            return null;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log the SQL exception for debugging purposes
	        return null; // Return null in case of SQL error
	    }
   }  
  }

   
   
   
   
	   
 
		

