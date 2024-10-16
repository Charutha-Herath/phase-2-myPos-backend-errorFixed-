package lk.ijse.phase02.phase2myposbackend.util;

import java.util.UUID;

public class AppUtil {

    public static String generateUserId(){
        return "USER-"+ UUID.randomUUID();
    }

    public static String generateCustomerId(){
        return null;
    }
}
