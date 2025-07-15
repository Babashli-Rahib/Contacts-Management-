public class ContactsApp {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        ContactsMenu menu = new ContactsMenu(manager);
        menu.start();
    }
}
