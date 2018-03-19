package user_management.validation;

public class InvalidEmailException extends Exception {

    public InvalidEmailException() {}

    public InvalidEmailException(String errorMessage) {
        super(errorMessage);
    }
}
