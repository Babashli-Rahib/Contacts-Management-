import java.util.Scanner;
import java.util.List;

public class ContactsMenu {
    private ContactManager manager;
    private Scanner scanner;
    private final String DATA_FILE = "data/contacts.txt";

    public ContactsMenu(ContactManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

      public void start() {
        manager.loadContacts(DATA_FILE);
        while (true) {
            System.out.println("\n--- Contacts Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. List Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Sort Contacts");
            System.out.println("5. Advanced Filter (Bonus)");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": addContact(); break;
                case "2": listContacts(); break;
                case "3": searchContact(); break;
                case "4": sortContacts(); break;
                case "5": advancedFilter(); break;
                case "6": manager.saveContacts(DATA_FILE); System.exit(0);
                default: System.out.println("Invalid option. Please enter a number between 1 and 6.");
            }
        }
    }

    private void addContact() {
        String name, phone, email, address, birthday, company;
        while (true) {
            System.out.print("Enter Name (Last_First): ");
            name = scanner.nextLine();
            if (!ContactUtils.isNotEmpty(name)) { 
                System.out.println("Name cannot be empty."); continue; 
            }
            break;
        }
        while (true) {
            System.out.print("Enter Phone Number: ");
            phone = scanner.nextLine();
            if (!ContactUtils.isNotEmpty(phone)) { 
                System.out.println("Phone cannot be empty."); 
                continue; }
            if (!ContactUtils.isValidPhone(phone)) { 
                System.out.println("Phone must be numeric."); continue; 
            }
            break;
        }
        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            if (!ContactUtils.isNotEmpty(email)) { 
                System.out.println("Email cannot be empty."); 
                continue; }
            if (!ContactUtils.isValidEmail(email)) { System.out.println("Invalid email format."); 
                continue; }
            break;
        }
        while (true) {
            System.out.print("Enter Address (Line_City): ");
            address = scanner.nextLine();
            if (!ContactUtils.isNotEmpty(address)) { 
                System.out.println("Address cannot be empty."); continue; }
            break;
        }
        while (true) {
            System.out.print("Enter Birthday (DD/MM/YYYY): ");
            birthday = scanner.nextLine();
            if (!ContactUtils.isNotEmpty(birthday)) { 
                System.out.println("Birthday cannot be empty."); continue; }
            break;
        }
        while (true) {
            System.out.print("Enter Company: ");
            company = scanner.nextLine();
            if (!ContactUtils.isNotEmpty(company)) { 
                System.out.println("Company cannot be empty."); continue; }
            break;
        }
        manager.addContact(new Contact(name, phone, email, address, birthday, company));
        System.out.println("Contact added successfully.");
    }
private void listContacts() {
        List<Contact> contacts = manager.getContacts();
        System.out.println("\nTotal Contacts: " + contacts.size());
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    private void searchContact() {
        System.out.print("Search by Name/Phone/Email/Address/Birthday/Company: ");
        String query = scanner.nextLine().toLowerCase();
        Contact c = manager.searchContact(query);
        if (c != null) {
            System.out.println(c);
            System.out.print("Edit (E) / Delete (D) / Back (B): ");
            String action = scanner.nextLine().toUpperCase();
            if (action.equals("D")) {
                manager.deleteContact(c);
                System.out.println("Contact deleted.");
            } else if (action.equals("E")) {
                editContact(c);
            } else if (!action.equals("B")) {
                System.out.println("Invalid action. Returning to menu.");
            }
        } else {
            System.out.println("No matching contact found.");
        }
    }
