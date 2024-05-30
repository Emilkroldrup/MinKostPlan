package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.SimpleDataAccess;

/**
 * User repository interface for user-specific data access operations.
 */
public interface UserRepository extends SimpleDataAccess<Users> {

    /**
     * Finds a user by their full name.
     *
     * @param firstname their firstname
     * @param lastname their lastname
     * @return the found user
     */
    Users findByName(String firstname, String lastname);

    /**
     * Finds a user by their email.
     *
     * @param email the email
     * @return the found user
     */
    Users findByEmail(String email);

    /**
     * Saves a user to the database
     * 
     * @param user object of User class
     */
    void saveUser(Users user);

    /**
     * Edits the details of a user.
     *
     * @param user the user entity with updated details
     */
    void editUserDetails(Users user);
}
