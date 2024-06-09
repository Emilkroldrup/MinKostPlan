package minkostplan.application.usecase.CustomExceptions;

public class InvalidDetailsException extends  IllegalArgumentException {

    public InvalidDetailsException(String message) {
        super(message);
    }

    public InvalidDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}
