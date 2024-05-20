package minkostplan.application.usecase;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.user.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return User.withUsername(user.getEmail())

                .password(user.getPasswordHash())
                .build();
    }
}
