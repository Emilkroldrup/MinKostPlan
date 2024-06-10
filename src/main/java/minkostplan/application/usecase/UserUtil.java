package minkostplan.application.usecase;

import minkostplan.application.usecase.CustomExceptions.UnexpectedDataErrorExpception;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Utility class for user-related operations.
 */
@Component
public class UserUtil {

    private static UserRepository userRepository;

    private UserUtil() {
    }

    /**
     * Sets the UserRepository instance.
     *
     * @param userRepository the UserRepository instance
     */
    public static void setUserRepository(UserRepository userRepository) {
        UserUtil.userRepository = userRepository;
    }


    private static final Logger logger = LoggerFactory.getLogger(UserUtil.class);
    /**
     * Retrieves the current authenticated user.
     *
     * @return the current user
     */
    public static Users getCurrentUser() {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                Object principal = authentication.getPrincipal();
                if (principal instanceof UserDetails) {
                    String Email = ((UserDetails) principal).getUsername();
                    return userRepository.findByEmail(Email);
                }
            }
            return null;
        }catch (DataAccessException e) {
            logger.error("DataAccessException occurred while trying to find all users: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while finding all users: " + e.getMessage(), e);
        }

    }

    public static String getCurrentUserEmail() {
        try{
            Users user = getCurrentUser();
            return (user != null) ? user.getEmail() : "";
        }catch (DataAccessException e) {
            logger.error("DataAccessException occurred while trying to find all users: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while finding all users: " + e.getMessage(), e);
        }

    }

    /**
     * Retrieves the first name of the current authenticated user.
     *
     * @return the current user's first name
     */
    public static String getCurrentUserFirstName() {
        try{
            Users user = getCurrentUser();
            return (user != null) ? user.getFirstName() : "";
        }catch (DataAccessException e) {
            logger.error("DataAccessException occurred while trying to find all users: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while finding all users: " + e.getMessage(), e);
        }

    }


}
