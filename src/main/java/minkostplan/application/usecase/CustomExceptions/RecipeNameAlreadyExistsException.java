package minkostplan.application.usecase.CustomExceptions;

import org.springframework.dao.DuplicateKeyException;

public class RecipeNameAlreadyExistsException extends DuplicateKeyException {
    public RecipeNameAlreadyExistsException(String message) {
        super(message);
    }

    public RecipeNameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
