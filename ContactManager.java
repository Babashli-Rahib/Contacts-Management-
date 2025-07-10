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
   public Contact searchContact(String query) {
        String q = query.toLowerCase();
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(q) ||
                c.getPhoneNumber().toLowerCase().contains(q) ||
                c.getEmail().toLowerCase().contains(q) ||
                c.getAddress().toLowerCase().contains(q) ||
                c.getBirthday().toLowerCase().contains(q) ||
                c.getCompany().toLowerCase().contains(q)) {
                return c;
            }
        }
        return null;
    }

    public boolean deleteContact(Contact c) {
        return contacts.remove(c);
    }

    public void sortContacts(int attribute) {
        Comparator<Contact> comparator;
        switch (attribute) {
            case 1: comparator = Comparator.comparing(Contact::getName); break;
            case 2: comparator = Comparator.comparing(Contact::getPhoneNumber); break;
            case 3: comparator = Comparator.comparing(Contact::getEmail); break;
            case 4: comparator = Comparator.comparing(Contact::getAddress); break;
            case 5: comparator = Comparator.comparing(Contact::getBirthday); break;
            case 6: comparator = Comparator.comparing(Contact::getCompany); break;
            default: return;
        }
        contacts.sort(comparator);
    }

    public List<Contact> advancedFilter(String name, String phone, String email, String address, String birthday, String company) {
        List<Contact> results = new ArrayList<>();
        for (Contact c : contacts) {
            if ((!ContactUtils.isNotEmpty(name)     || c.getName().toLowerCase().contains(name.toLowerCase())) &&
                (!ContactUtils.isNotEmpty(phone)    || c.getPhoneNumber().toLowerCase().contains(phone.toLowerCase())) &&
                (!ContactUtils.isNotEmpty(email)    || c.getEmail().toLowerCase().contains(email.toLowerCase())) &&
                (!ContactUtils.isNotEmpty(address)  || c.getAddress().toLowerCase().contains(address.toLowerCase())) &&
                (!ContactUtils.isNotEmpty(birthday) || c.getBirthday().toLowerCase().contains(birthday.toLowerCase())) &&
                (!ContactUtils.isNotEmpty(company)  || c.getCompany().toLowerCase().contains(company.toLowerCase()))) {
                results.add(c);
            }
        }
        return results;
    }
} 
