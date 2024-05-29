package minkostplan.application;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    private CustomUserDetailsService customUserDetailsService;

    @BeforeEach
    public void setUp() throws Exception {
        try (AutoCloseable closeable = MockitoAnnotations.openMocks(this)) {
            customUserDetailsService = new CustomUserDetailsService(userRepository);
        }
    }

    @Test
    public void loadUserByUsername_CorrectPassword_ReturnsUserDetails() {
        Users user = new Users();
        user.setEmail("test@example.com");
        user.setPasswordHash("correctPassword");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());

        assertEquals(user.getEmail(), userDetails.getUsername());
        assertEquals(user.getPasswordHash(), userDetails.getPassword());
    }

    @Test
    public void loadUserByUsername_WrongPassword_ThrowsUsernameNotFoundException() {
        Users user = new Users();
        user.setEmail("test@example.com");
        user.setPasswordHash("correctPassword");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        assertThrows(UsernameNotFoundException.class, () -> {
            customUserDetailsService.loadUserByUsername("wrongPassword");
        });
    }
}
