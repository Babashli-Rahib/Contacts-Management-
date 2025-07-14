public class Company {
    private String name;
    private String city; 

    public Company(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() { return name; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return name + " (" + city + ")";
    }
} 
