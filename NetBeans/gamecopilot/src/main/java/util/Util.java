package util;

import java.security.SecureRandom;
import model.User;

public class Util {
    
    public static User user;
    public static final String APP_TITLE = "Game-Copilot";
    
    
    public static String getTitle(String title) {
        if (Util.user == null) {
            return Util.APP_TITLE + title;
        }
        return Util.APP_TITLE + " " + title + " " + Util.user.getName() + " "
                + Util.user.getSurname() + " - " + Util.user.getRole();
    }
    
    public static String generateRandomPassword()
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < 10; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
    
}
