package minkostplan.application.DBcontroller.user;
import minkostplan.application.entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    private Users existingUser;
    private Users existingUser2;


    /**
     * Sets up the test environment before each test method is executed.
     * Makes values reset between each test
     */
    @BeforeEach
    void setUp() {
        existingUser = new Users("Madsen","Bjerring", 21,190,80,"Male","Gain weight","test@gmail.com","testword", LocalDateTime.now(), "1-2 times a week");
        existingUser2= new Users("egon","Bjerring", 23,190,80,"Female","Gain weight","test2@gmail.com","testword", LocalDateTime.now(), "3-5 times a week");
    }
    

    /**
     * test finding correct email by findEmail function
     */
    @Test
    void findByEmail(){
        when(userRepository.findByEmail(eq(existingUser.getEmail()))).thenReturn(existingUser);
        Users result = userRepository.findByEmail("test@gmail.com");


        assertEquals(existingUser,result);
        System.out.println("Has to equal: " + existingUser);
        System.out.println("\nResult: " + result);
    }

    /**
     *  test non-existing email error by findEmail function
     */
    @Test
    void findByEmail_NonExistingEmail(){
        when(userRepository.findByEmail(eq(existingUser.getEmail()))).thenReturn(existingUser);
        Users result = userRepository.findByEmail("nonexistingemail");

        assertNotEquals(existingUser,result);
        System.out.println("Has to equal: " + existingUser);
        System.out.println("\nResult: " + result);
    }

    /**
     * test if the findAll method actually returns the correct users
     */
    @Test
    void findAllUsers(){
        List<Users> expectedUsers = new ArrayList<>();
        expectedUsers.add(existingUser);
        expectedUsers.add(existingUser2);

        when(userRepository.findAll()).thenReturn(expectedUsers);


        List<Users> actualUsers = userRepository.findAll();


        for (int i = 0; i < expectedUsers.size(); i++) {
            assertEquals(expectedUsers.get(i), actualUsers.get(i));
        }

        System.out.println("Expected users " + expectedUsers);
        System.out.println("\nResult " + actualUsers);
    }

}
