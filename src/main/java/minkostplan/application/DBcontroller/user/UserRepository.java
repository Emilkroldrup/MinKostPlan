package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.SimpleDataAccess;

/**
 * User repository interface for user-specific data access operations.
 */
public interface UserRepository extends SimpleDataAccess<Users> {

    /**
     * Finds a user by their username.
     *
     * @param username the username
     * @return the found user
     */
    Users findByUsername(String username);

    /**
     * Finds a user by their email.
     *
     * @param email the email
     * @return the found user
     */
    Users findByEmail(String email);

    /**
     * Edits the details of a user.
     *
     * @param users the user entity with updated details
     */
    void editUserDetails(Users users);
}
