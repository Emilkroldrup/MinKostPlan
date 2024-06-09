package minkostplan.application.usecase.CustomExceptions;

public class UnexpectedDataErrorExpception extends RuntimeException {

    public UnexpectedDataErrorExpception(String message) {
        super(message);
    }

    public UnexpectedDataErrorExpception(String message, Throwable cause) {
        super(message, cause);
    }
}
