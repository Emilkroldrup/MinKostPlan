package minkostplan.application.usecase.CustomExceptions;

import org.springframework.dao.DuplicateKeyException;

public class UserEmailAlreadyExistsException extends DuplicateKeyException {

    public UserEmailAlreadyExistsException(String message) {
        super(message);
    }

    public UserEmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
