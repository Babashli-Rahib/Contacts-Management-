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
        String name, phone, email, address, birthday, companyName, companyCity;
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
           System.out.print("Enter Company Name: ");
            companyName = scanner.nextLine();
            if (!ContactUtils.isNotEmpty(companyName)) { 
                System.out.println("Company name cannot be empty."); 
                continue; 
            }
            break;
        }
        while (true) {
            System.out.print("Enter Company City: ");
            companyCity = scanner.nextLine();
            if (!ContactUtils.isNotEmpty(companyCity)) { 
                System.out.println("Company city cannot be empty."); 
                continue; 
            }
            break;
        }
        Company company = new Company(companyName, companyCity);
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
        List<Contact> results = manager.searchContacts(query);
        if (results.size() > 0) {
            System.out.println("\nTotal Matches: " + results.size());
            for (Contact c : results) {
                System.out.println(c);
            }
            System.out.print("Edit (E) / Delete (D) / Back (B): ");
            String action = scanner.nextLine().toUpperCase();
            if (action.equals("D")) {
                System.out.print("Enter the name of the contact to delete: ");
                String delName = scanner.nextLine();
                Contact toDelete = null;
                for (Contact c : results) {
                    if (c.getName().equalsIgnoreCase(delName)) {
                        toDelete = c;
                        break;
                    }
                }
                if (toDelete != null) {
                    manager.deleteContact(toDelete);
                    System.out.println("Contact deleted.");
                } else {
                    System.out.println("No contact with that name in the results.");
                }
            } else if (action.equals("E")) {
               System.out.print("Enter the name of the contact to edit: ");
                String editName = scanner.nextLine();
                Contact toEdit = null;
                for (Contact c : results) {
                    if (c.getName().equalsIgnoreCase(editName)) {
                        toEdit = c;
                        break;
                    }
                }
                if (toEdit != null) {
                    editContact(toEdit);
                } else {
                    System.out.println("No contact with that name in the results.");
                } 
            } else if (!action.equals("B")) {
                System.out.println("Invalid action. Returning to menu.");
            }
        } else {
            System.out.println("No matching contact found.");
        }
    }
    private void editContact(Contact c) {
        String input;
        System.out.print("New Phone (" + c.getPhoneNumber() + "): ");
        input = scanner.nextLine();
        if (ContactUtils.isNotEmpty(input)) {
            if (ContactUtils.isValidPhone(input)) c.setPhoneNumber(input);
            else System.out.println("Invalid phone. Keeping previous value.");
        }
        System.out.print("New Email (" + c.getEmail() + "): ");
        input = scanner.nextLine();
        if (ContactUtils.isNotEmpty(input)) {
            if (ContactUtils.isValidEmail(input)) c.setEmail(input);
            else System.out.println("Invalid email. Keeping previous value.");
        }
        System.out.print("New Address (" + c.getAddress() + "): ");
        input = scanner.nextLine();
        if (ContactUtils.isNotEmpty(input)) c.setAddress(input);
        System.out.print("New Birthday (" + c.getBirthday() + "): ");
        input = scanner.nextLine();
        if (ContactUtils.isNotEmpty(input)) c.setBirthday(input);
        String oldCompanyName = "";
        String oldCompanyCity = "";
        if (c.getCompany() != null) {
            oldCompanyName = c.getCompany().getName();
            oldCompanyCity = c.getCompany().getCity();
        }
        System.out.print("New Company Name (" + oldCompanyName + "): ");
        String companyName = scanner.nextLine();
        if (!ContactUtils.isNotEmpty(companyName)) companyName = oldCompanyName;
        System.out.print("New Company City (" + oldCompanyCity + "): ");
        String companyCity = scanner.nextLine();
        if (!ContactUtils.isNotEmpty(companyCity)) companyCity = oldCompanyCity;
        c.setCompany(new Company(companyName, companyCity));
        System.out.println("Contact updated.");
    }
    private void sortContacts() {
        System.out.println("Sort by: 1-Name 2-Phone 3-Email 4-Address 5-Birthday 6-Company");
        String choice = scanner.nextLine();
        try {
            int attr = Integer.parseInt(choice);
            manager.sortContacts(attr);
            System.out.println("Contacts sorted.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
        }
    }
private void advancedFilter() {
        System.out.println("Enter filter values (leave blank to ignore an attribute):");
        System.out.print("Name (Last_First): ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Address (Line_City): ");
        String address = scanner.nextLine();
        System.out.print("Birthday (DD/MM/YYYY): ");
        String birthday = scanner.nextLine();
        System.out.print("Company: ");
        String company = scanner.nextLine();
        List<Contact> results = manager.advancedFilter(name, phone, email, address, birthday, company);
        System.out.println("\nTotal Matches: " + results.size());
        for (Contact c : results) {
            System.out.println(c);
        }
        if (results.size() > 0) {
            System.out.print("Edit (E) / Delete (D) / Back (B): ");
            String action = scanner.nextLine().toUpperCase();
            if (action.equals("D")) {
                System.out.print("Enter the name of the contact to delete: ");
                String delName = scanner.nextLine();
                Contact toDelete = null;
                for (Contact c : results) {
                    if (c.getName().equalsIgnoreCase(delName)) {
                        toDelete = c;
                        break;
                    }
                }
                if (toDelete != null) {
                    manager.deleteContact(toDelete);
                    System.out.println("Contact deleted.");
                } else {
                    System.out.println("No contact with that name in the results.");
                }
            } else if (action.equals("E")) {
                System.out.print("Enter the name of the contact to edit: ");
                String editName = scanner.nextLine();
                Contact toEdit = null;
                for (Contact c : results) {
                    if (c.getName().equalsIgnoreCase(editName)) {
                        toEdit = c;
                        break;
                    }
                }
                if (toEdit != null) {
                    editContact(toEdit);
                } else {
                    System.out.println("No contact with that name in the results.");
                }
            } else if (!action.equals("B")) {
                System.out.println("Invalid action. Returning to menu.");
            }
        } else {
            System.out.println("No matching contacts found.");
        }
    }
}
