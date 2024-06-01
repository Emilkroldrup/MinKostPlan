package minkostplan.application.usecase;


import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean editUserDetails(Users user) {
        try {
            if (!user.getFirstName().isEmpty() && !user.getLastName().isEmpty() && !user.getEmail().isEmpty() && user.getAge() >= 0 && user.getHeight() >= 0 && user.getWeight() >= 0 && !user.getGender().isEmpty() && !user.getGoal().isEmpty() && !user.getActivityLevel().isEmpty()) {
                userRepository.editUserDetails(user);
                return true;
            }
        } catch (DuplicateKeyException duplicateKeyException) {
            System.out.println(" User with same details already exists" + duplicateKeyException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return false;
    }

}
