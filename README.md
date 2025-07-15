# Contacts-Management-
Contacts Management System

This is a simple and user-friendly *Contacts Management System* written in Java. You can easily add, search, edit, delete, and sort your personal or work contacts using a menu in the console.

 Features

- *Add Contact:* Add a new contact with name, phone, email, address, birthday, company name, and city.
- *List Contacts:* See all your contacts in a list.
- *Search:* Quickly find contacts by name, phone, email, address, birthday, or company.
- *Edit or Delete:* Edit or delete any contact you find.
- *Sort:* Sort contacts by name, phone, email, address, birthday, or company (ascending or descending).
- *Advanced Filter:* Filter contacts by any combination of fields at once.
- *Data Saving:* All contacts are saved in data/contacts.txt and loaded automatically.
- *Simple Menu:* Easy-to-use menu in the console.

 Folder Structure

Contacts-Management--main/
│
├── Company.java
├── Contact.java
├── ContactManager.java
├── ContactsApp.java
├── ContactsMenu.java
├── ContactUtils.java
├── README.md
└── data
    └── contacts.txt

 Contact Data Format

Contacts are saved in this format:


Name,Phone,Email,Address,Birthday,Company,City


*Example:*

Ali_Karimli,+994 10 234 43 23,ali@gmail.com,Gunesli_34,29/06/2005,ADA,Baku
Quliyeva_Aysel,+994 10 987 65 43,aysel.quliyeva@gmail.com,456 Elm St_Ganja,15/05/1985,Google,
```

 How to Use

 1. Setup

No extra libraries are needed. Just Java SE is enough.

 2. Run the Program

1. Open your terminal and go to the project folder:
   
   cd Contacts-Management--main
   
2. Compile all .java files:
   
   javac *.java
   
3. Start the program:
   
   java ContactsApp

3. Menu Guide

When you start the program, you will see this menu:


--- Contacts Management System ---
1. Add Contact
2. List Contacts
3. Search Contact
4. Sort Contacts
5. Advanced Filter (Bonus)
6. Save and Exit
Choose an option:


- 1: Add a new contact. You must enter all fields in the correct format.
- 2: See all your contacts.
- 3: Search by any field, then edit or delete the result.
- 4: Sort contacts by any field you want.
- 5: Filter contacts by several fields at once.
- 6: Save all changes and exit the program.

 4. Notes

- When adding or editing a contact, the program will ask you to enter the data in the correct format. If you make a mistake, it will warn you.
- All your contacts are saved automatically in data/contacts.txt.
