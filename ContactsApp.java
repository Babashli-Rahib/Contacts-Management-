import java.util.*;
import java.io.*;
import java.io.Serializable;

class Contact {
    private String name; 
    private String phoneNumber;
    private String email;
    private String address; 
    private String birthday;
    private String company;

    public Contact(String name, String phoneNumber, String email, String address, String birthday, String company) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.company = company;
    }

    public String getName() { 
        return name; 
        }
    public String getPhoneNumber() {
         return phoneNumber; 
         }
    public String getEmail() { 
        return email; 
        }
    public String getAddress() {
         return address; 
         }
    public String getBirthday() { 
        return birthday; 
        }
    public String getCompany() {
         return company; 
         }

    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
        }
    public void setEmail(String email) { 
        this.email = email; 
        }
    public void setAddress(String address) { 
        this.address = address;
         }
    public void setBirthday(String birthday) { 
        this.birthday = birthday;
         }
    public void setCompany(String company) { 
        this.company = company;
         }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email + ", Address: " + address + ", Birthday: " + birthday + ", Company: " + company;
    }
}

public class ContactsApp {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        ContactsMenu menu = new ContactsMenu(manager);
        menu.start();
    }
}
