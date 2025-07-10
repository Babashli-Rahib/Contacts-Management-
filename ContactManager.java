import java.util.*;
import java.io.*;

public class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void loadContacts(String filename) {
        contacts.clear();
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                if (parts.length == 6) {
                    contacts.add(new Contact(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing contacts file found.");
        }
    }
 public void saveContacts(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Contact c : contacts) {
                writer.println(c.getName() + "," + c.getPhoneNumber() + "," + c.getEmail() + "," + c.getAddress() + "," + c.getBirthday() + "," + c.getCompany());
            }
            System.out.println("Contacts saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving contacts.");
        }
    }
public void addContact(Contact c) {
        contacts.add(c);
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public int getContactCount() {
        return contacts.size();
    }
