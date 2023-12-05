package Ceasar_App;
//Import necessary libraries and packages
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CeasarUser {
//Fields of the CeasarUser Class
private String userName;
private String userPasswordHash;


// Create instance of CeasarUserDAO class to use in this class
CeasarUserDAO cud = new CeasarUserDAO();
//CeasarUser constructor (no need for setter methods)
public CeasarUser(String u, String p) {
	   this.userName = u;
	   this.userPasswordHash =  hashPassword(p);
	  
}

//CeasarUser accessor methods
public String getUserName() {
	return userName;
}
public String getUserPasswordHash() {
	return userPasswordHash;
}


//Method to hash the password using SHA-256
public String hashPassword(String password) {
 try {
     // Create a MessageDigest instance for SHA-256 hashing
     MessageDigest md = MessageDigest.getInstance("SHA-256");

     // Convert the password string to bytes and add them to the digest
     md.update(password.getBytes());

     // Generate the hashed bytes
     byte[] bytes = md.digest();

     // Convert the hashed bytes to a hexadecimal representation
     StringBuilder stringBuilder = new StringBuilder();
     for (byte aByte : bytes) {
         // Convert each byte to its hexadecimal equivalent
         stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
     }

     // Return the hashed password as a hexadecimal string
     return stringBuilder.toString();
 } catch (NoSuchAlgorithmException e) {
     // Handle exceptions related to unavailable algorithms
     e.printStackTrace();
     return null; // Return null if an exception occurs
 }
}

/* 
PASSWORD HASHING:
-----------------
- Password hashing is a technique used to secure passwords by converting them into a hashed, 
  non-reversible format.
- It is necessary because storing plain text passwords can lead to security vulnerabilities. 
  Hashing ensures that even if the database is compromised, attackers cannot retrieve the original 
  passwords.
- The SHA-256 hashing algorithm used here generates a unique fixed-size hash for each input, 
  providing a high level of security.
- HASHING PROCESS:
    1. **Initialization**: Create a MessageDigest instance using SHA-256.
    2. **Update Digest**: Add the password bytes to the digest for hashing.
    3. **Generate Hash**: Obtain the hashed bytes using the digest's `digest()` method.
    4. **Convert to Hexadecimal**: Convert the hashed bytes to a human-readable hexadecimal format.
    5. **Return Hash**: Provide the hashed password as a hexadecimal string.
*/



}
