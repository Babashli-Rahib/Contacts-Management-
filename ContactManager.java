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
