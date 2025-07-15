import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String email;
    private String address; 
    private String birthday;
    private Company company;

   public Contact(String name, String phoneNumber, String email, String address, String birthday, Company company) {
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
    public Company getCompany() {
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
   public void setCompany(Company company) { 
this.company = company;  
}

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email + ", Address: " + address + ", Birthday: " + birthday + ", Company: " + company;
    }
} 
