package minkostplan.application.usecase;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import org.springframework.stereotype.Component;


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

    /**
     * Retrieves the current authenticated user.
     *
     * @return the current user
     */
    public static Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                String Email = ((UserDetails) principal).getUsername();
                return userRepository.findByEmail(Email);
            }
        }
        return null;
    }
    
}
