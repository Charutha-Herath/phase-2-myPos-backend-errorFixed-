package lk.ijse.phase02.phase2myposbackend.util;
import java.util.regex.Pattern;

public class RegexProcess {

    public static boolean userEmailMatcher(String email) {
        String regexForUserEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern regexPattern = Pattern.compile(regexForUserEmail);
        return regexPattern.matcher(email).matches();
    }

}
