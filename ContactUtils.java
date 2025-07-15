public class ContactUtils {
    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\+994 \\d{2} \\d{3} \\d{2} \\d{2}");
    }

    public static String formatPhone(String phone) {
        String digits = phone.replaceAll("\\D", "");
        if (digits.startsWith("994")) digits = digits.substring(3);
        if (digits.startsWith("0")) digits = digits.substring(1);
        while (digits.length() < 9) digits = "0" + digits;
        if (digits.length() != 9) return phone; 
        return String.format("+994 %s %s %s %s",
            digits.substring(0,2), digits.substring(2,5), digits.substring(5,7), digits.substring(7,9));
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@gmail\\.com$");
    }

    public static String formatEmail(String email) {
        String[] parts = email.split("@");
        if (parts.length > 0) return parts[0] + "@gmail.com";
        return email;
    }

    public static boolean isValidName(String name) {
        return name.matches("^[A-Za-zƏəÖöÜüĞğÇçŞşıI_]+$" );
    }

    public static boolean isValidEmailNoDigits(String email) {
        return email.matches("^[A-Za-z._-]+@gmail\\.com$");
    }

    public static boolean isValidBirthday(String birthday) {
        return birthday.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
    }

    public static boolean isValidCompanyName(String name) {
        return name.matches("^[A-Za-zƏəÖöÜüĞğÇçŞşıI ]+$");
    }

    public static boolean isValidCity(String city) {
        return city.matches("^[A-Za-zƏəÖöÜüĞğÇçŞşıI ]+$");
    }

    public static boolean isValidPhoneInput(String phone) {
        return phone.matches("^[+0-9 ]+$");
    }
}
