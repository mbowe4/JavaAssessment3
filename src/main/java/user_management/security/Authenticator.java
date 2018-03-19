package user_management.security;

import user_management.User;

public class Authenticator {
    public static boolean authenticate(User user, String passwordToCheck) {

        //return BCrypt.checkpw(String.valueOf(user.getPassword()), passwordToCheck);

        return user.getPassword().matches(passwordToCheck);
    }
}

