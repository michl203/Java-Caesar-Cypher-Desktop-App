package Ceasar_App;

public class CeasarDecryption {
//Fields
private String UserPhrase;
private String EncryptPhrase;
private int CeasarNum;

//Constructor
public CeasarDecryption(String phrase, int num) {
	UserPhrase = phrase;
	CeasarNum = num;
}
//Accessor method
public String getPhrase() {
	return UserPhrase;
}
public int getCeasarNum() {
	return CeasarNum;
}
//Method to decrypt a user's string phrase.
//Users need to input the CeasarEncrypt method into the parameter field encryptedPhrase!
public String CeasarDecrypt(String encryptedPhrase, int CeasarNum) {
	   char [] phraseArray = encryptedPhrase.toCharArray();
	   
	   //Loop through char array of user phrase, increasing the char value (or position) by CeasarNum Value
	   for(int i =0; i<phraseArray.length; i++) {
		   phraseArray[i] -= CeasarNum;
	   }
	   
	   EncryptPhrase = new String(phraseArray);
	   return EncryptPhrase;
}
}
