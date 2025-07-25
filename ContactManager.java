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
                    Company company = new Company(parts[5], "");
                    contacts.add(new Contact(parts[0], parts[1], parts[2], parts[3], parts[4], company));
                } else if (parts.length == 7) {
                    Company company = new Company(parts[5], parts[6]);
                    contacts.add(new Contact(parts[0], parts[1], parts[2], parts[3], parts[4], company));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing contacts file found.");
        }
    }
 public void saveContacts(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename, false))) {
            for (Contact c : contacts) {
                writer.println(c.getName() + "," + c.getPhoneNumber() + "," + c.getEmail() + "," + c.getAddress() + "," + c.getBirthday() + "," + c.getCompany().getName() + "," + c.getCompany().getCity());
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
    
   public List<Contact> searchContacts(String query) {
        String q = query.toLowerCase();
        List<Contact> results = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(q) ||
                c.getPhoneNumber().toLowerCase().contains(q) ||
                c.getEmail().toLowerCase().contains(q) ||
                c.getAddress().toLowerCase().contains(q) ||
                c.getBirthday().toLowerCase().contains(q) ||
                c.getCompany().getName().toLowerCase().contains(q)) {
                results.add(c);
            }
        }
        return results;
    }

    public boolean deleteContact(Contact c) {
        return contacts.remove(c);
    }

    public void sortContacts(int attribute, boolean ascending) {
        Comparator<Contact> comparator;
        switch (attribute) {
            case 1: comparator = Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER); break;
            case 2: comparator = Comparator.comparing(Contact::getPhoneNumber); break;
            case 3: comparator = Comparator.comparing(Contact::getEmail, String.CASE_INSENSITIVE_ORDER); break;
            case 4: comparator = Comparator.comparing(Contact::getAddress, String.CASE_INSENSITIVE_ORDER); break;
            case 5: comparator = Comparator.comparing(Contact::getBirthday); break;
            case 6: comparator = Comparator.comparing(c -> c.getCompany().getName(), String.CASE_INSENSITIVE_ORDER); break;
            default: return;
        }
        if (!ascending) comparator = comparator.reversed();
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
                (!ContactUtils.isNotEmpty(company)  || c.getCompany().getName().toLowerCase().contains(company.toLowerCase()))) {
                results.add(c);
            }
        }
        return results;
    }
} 
