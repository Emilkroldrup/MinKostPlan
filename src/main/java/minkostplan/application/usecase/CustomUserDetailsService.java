package minkostplan.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import minkostplan.application.entity.user;
import minkostplan.application.repository.user.JdbcUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final JdbcUserRepository userRepository;
    
    

    @Autowired
    public CustomUserDetailsService(JdbcUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername " + username);
        user user = null;
        try {
            user = userRepository.findByUsername(username);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.withUsername(user.getEmail())
                .password(user.getPasswordHash())
                .build();
    }
}
