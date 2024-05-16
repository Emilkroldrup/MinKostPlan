package minkostplan.application.DBcontroller.user;
import minkostplan.application.entity.Users;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
@SpringBootTest

class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void findbyUsername(){
      String username ="test";
      Users user = new Users("test","test@test.com","testword", LocalDateTime.now());
      when(userRepository.findByUsername(username)).thenReturn(user);

      Users result = userRepository.findByUsername(username);

      assertEquals(user,result);

      System.out.println("Has to equal: " + user);
      System.out.println();
      System.out.println("Result: " + result);
    }

    @Test
    void findbyEmail(){
        String email= "Test@gmail.com";
        Users user = new Users("test","test@test.com","testword", LocalDateTime.now());
        when(userRepository.findByEmail(email)).thenReturn(user);

        Users result = userRepository.findByEmail(email);

        assertEquals(user,result);

        System.out.println("Has to equal: " + user);
        System.out.println();
        System.out.println("Result: " + result);
    }

}