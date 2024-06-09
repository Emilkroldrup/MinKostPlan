package minkostplan.application.usecase.CustomExceptions;

import org.springframework.dao.DataAccessException;

public class UnexpectedErrorHappendExpception extends RuntimeException {

    public UnexpectedErrorHappendExpception(String message) {
        super(message);
    }

    public UnexpectedErrorHappendExpception(String message, Throwable cause) {
        super(message, cause);
    }
}
