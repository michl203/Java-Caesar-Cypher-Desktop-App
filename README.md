

---
**DISCLAIMER!! I USED CHAT-GPT TO AID IN THE CREATION OF THIS README FILE AS THIS IS MY FIRST GITHUB PROJECT!!**
**CHAT-GPT WAS USED TO FORMAT AND ORGANIZE THE README, I CREATED ALL THE CONTENT THOUGH!**

# Java Caesar Cipher Desktop Application Project
### By Michael Ambeguia

## Purpose

The purpose of this project is to have a desktop application that enables users to encrypt or decrypt "secret phrases" using a simple Caesar Cipher algorithm. This project was undertaken as a personal project to enhance my Java programming skills and delve into cryptography and security concepts like secure password storage and user authentication. This is my first project upload on Github as well! I enjoyed this project and had a ton of fun creating it and learning new aspects of Java programming.


## Features

### Key Features

| Feature                            | Description                                                | Class Location            |
|------------------------------------|------------------------------------------------------------|---------------------------|
| GUI                                | User interaction through Java Swing GUI components          | MainWindow.java           |
|                                    |                                                            | RegistrationFrame.java    |
|                                    |                                                            | LoginFrame.java           |
|                                    |                                                            |  DecryptionPanel.java      |
|                                    |                                                             | EncryptionPanel.java      |
| Encryption Algorithm               | Caesar Cipher based encryption for user phrases             | CeasarEncryption.java     |
| Decryption Algorithm               | Caesar Cipher based decryption for user phrases             | CeasarDecryption.java     |
| User Authentication                | Basic user authentication to control application access     | MainWindow.java           |
| Registration                       | New user registration for access to the application         | RegistrationFrame.java    |
| Hashing of User Passwords          | Usage of SHA-256 for password hashing                       | CeasarUser.java           |
| Use of a Database                  | JDBC connection to MySQL to store user info and phrases     | CeasarUserDAO.java        |
| Various Security Measures          | Parameterized SQL queries to prevent SQL injection          | CeasarUser.java           |
|                                    |                                                            | CeasarUserDAO.java        |

### Features Not Included

| Feature                            | Reasoning                                                 |
|------------------------------------|-----------------------------------------------------------|
| Unique views for individual users  | Difficulty in displaying phrases based on user ID         |
| Salting Passwords                  | Not implemented; essential for commercial use standards    |
| Ability to update phrases          | Considered redundant as secret phrases are typically fixed |
| Locking mechanisms for login       | Lack of implementation awareness for locking mechanisms    |

## Skills Demonstrated

### Technical Skills

- **JDBC** for database connectivity and interactions.
- Usage of **Parameterized statements** for secure SQL queries.
- Working with **Java Swing** components (JFrames, JTables, JTextAreas, etc.).
- Event Listeners/Action Listeners for UI functionality.
- **Cryptography** using a Caesar Cipher algorithm for encryption/decryption.
- Creation of a **Java Executable JAR file** with a desktop shortcut.
- Embracing **Object-Oriented Programming (OOP)** principles:
  - Abstraction for hiding functionalities.
  - Encapsulation for data and behavior confinement.
  - Modular coding using classes.
- **Security Best Practices** such as password hashing and SQL query security.
- **Database Design**
-  **Enforcing Data Integrity** using entity integrity and referential integrity.
- Writing SQL queries (SELECT, UPDATE, INSERT).

### User Information (Fake Users)

| Username       | Password   |
|----------------|------------|
| mich2438       | Es7pirit   |
| MrPutin12      | Hjj21wa!   |
| Krabs_Eugene   | iLuv$$$    |
| agent_M        | j9sh2mQka  |
---
**HERE IS A BRIEF OVERVIEW OF THE PROJECT STRUCTURE**

![Caesar Cypher Overview drawio](https://github.com/michl203/Java-Caesar-Cypher-Desktop-App/assets/110306237/057f3b01-58f7-4fd2-9b13-0a29ce923390)
____________________________________________________________________________________________________________________________

**STEPS TO RUN THE APPLICATION**
1. Gather all the java files for this repository and doownload them onto your device.
2. Go into your IDE and create a new Java package uisng the files from the repository.
3. Make your MySQl database using a similar schema to mine. Look at the SQL files provided in the repository.
4. Change necessary parts of the source code suhc as the JDBC class information (make sure it pertains to your own database)
5. Once everything is connected, test the application in your IDE.
6. Now, create a executeble JAR file for the application on your device in your IDE.
7. After the JAR file is created you can go to its file path on your device, right click it, and create a shortcut for it.


____________________________________________________________________________________________________________________________
**LEGAL AND USE INFORMATION**
Creative Commons Legal Code

Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)

This work is licensed under the Creative Commons Attribution-NonCommercial 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/4.0/ or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.

Feel free to:
-Use my application if you'd like
-Adapt it, and even fix parts
- Copy and redistribute it

Under the following terms:

- Attribution — You must give appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use.
- NonCommercial — You may not use the material for commercial purposes.

