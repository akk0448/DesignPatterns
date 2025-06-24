package sdv.auth;

import sdv.model.User;

public class AccessManager {

    public static boolean hasAccess(User user) {
        return "ADMIN".equalsIgnoreCase(user.getRole());
    }
}