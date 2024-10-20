package lk.ijse.phase02.phase2myposbackend.util;
import java.util.regex.Pattern;

public class RegexProcess {

    public static boolean userEmailMatcher(String email) {
        String regexForUserEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern regexPattern = Pattern.compile(regexForUserEmail);
        return regexPattern.matcher(email).matches();
    }

    public static boolean customerIdMatcher(String id) {
        String regexForCustomerId = "^cust-\\d{4}$";
        Pattern regexPattern = Pattern.compile(regexForCustomerId);
        return regexPattern.matcher(id).matches();
    }

    public static boolean ItemIdMatcher(String id) {
        String regexForItemId = "^item-\\d{4}$";
        Pattern regexPattern = Pattern.compile(regexForItemId);
        return regexPattern.matcher(id).matches();
    }

}
