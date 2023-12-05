package Ceasar_App;

public class CeasarEncryption {
private String UserPhrase;
private String EncryptPhrase;
private int CeasarNum;

//Constructor
public CeasarEncryption(String phrase, int num) {
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

//Method to encrypt a user's string phrase
public String CeasarEncrypt(String phrase, int CeasarNum) {
	   char [] phraseArray = phrase.toCharArray();
	   
	   //Loop through char array of user phrase, increasing the char value (or position) by CeasarNum Value
	   for(int i =0; i<phraseArray.length; i++) {
		   phraseArray[i] += CeasarNum;
	   }
	   
	   EncryptPhrase = new String(phraseArray);
	   return EncryptPhrase;
}

}
