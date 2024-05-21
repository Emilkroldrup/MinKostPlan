package minkostplan.application.DBcontroller.user;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.UserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
@SpringBootTest

class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;
    

<<<<<<< Updated upstream
    @Test
    void findByEmail(){
      String email ="test@test.com";
      Users user = new Users("test","tester",30,180,90,"male","lose weight","test@test.com","testword", LocalDateTime.now());
      when(userRepository.findByEmail(email)).thenReturn(user);

      Users result = userRepository.findByEmail(email);

      assertEquals(user,result);

      System.out.println("Has to equal: " + user);
      System.out.println();
      System.out.println("Result: " + result);
    }

    void findbyUsername(){
      String username ="test";
      Users user = new Users("test","test@test.com","testword", LocalDateTime.now());
      when(userRepository.findByUsername(username)).thenReturn(user);
=======
    private Users existingUser;
    private String username;
>>>>>>> Stashed changes

    private String email;

    @BeforeEach
    void setUp() {
        username = "test";
        email = "testemail@gmail.com";
        existingUser = new Users(username, email, "testword", LocalDateTime.now());
    }
<<<<<<< Updated upstream
}
=======



    @Test
    void findbyEmail(){

        when(userRepository.findByEmail(email)).thenReturn(existingUser);

        Users result = userRepository.findByEmail(email);

        assertEquals(existingUser,result);

        System.out.println(email);

        System.out.println("Has to equal: " + existingUser);
        System.out.println();
        System.out.println("Result: " + result);
    }


}
>>>>>>> Stashed changes
