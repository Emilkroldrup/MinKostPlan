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
     * @param firstName 
     * @return the found user
     */
    Users findByName(String firstName, String lastName);

    /**
     * Finds a user by their email.
     *
     * @param email the email
     * @return the found user
     */
    Users findByEmail(String email);
    void editUserDetails(Users users);
}