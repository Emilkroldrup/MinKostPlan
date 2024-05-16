package minkostplan.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;

public class UserUtil {

    private static UserRepository userRepository;

    @Autowired
    public UserUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                String Email = ((UserDetails) principal).getUsername();
                return userRepository.getUserByEmail(Email);
            }
        }
        return null;
    }
    
}
