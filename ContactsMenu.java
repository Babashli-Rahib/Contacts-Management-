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
