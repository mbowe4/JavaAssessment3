package user_management.security;

public class UserAuthenticationFailedException extends Exception {

    public UserAuthenticationFailedException() {}

    public UserAuthenticationFailedException(String errorMessage) {
        super(errorMessage);
    }
}
