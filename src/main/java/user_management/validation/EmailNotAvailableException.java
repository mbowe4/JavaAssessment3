package user_management.validation;

public class EmailNotAvailableException extends Exception{

    public EmailNotAvailableException() {}

    EmailNotAvailableException(String errorMessage) {
        super(errorMessage);
    }
}
