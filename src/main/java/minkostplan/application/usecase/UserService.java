package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {


    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users findByName(String firstName, String lastName) {
        return userRepository.findByName(firstName, lastName);
    }
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public void saveUser(Users user) {
        userRepository.saveUser(user);
    }
    public boolean editUserDetails(Users user) {
        if (!user.getFirstName().isEmpty() && !user.getLastName().isEmpty() && !user.getEmail().isEmpty() && user.getAge() >= 0 && user.getHeight() >= 0 && user.getWeight() >= 0 && !user.getGender().isEmpty() && !user.getGoal().isEmpty() && !user.getActivityLevel().isEmpty()) {
            userRepository.editUserDetails(user);
            return true;
        }
        return false;
    }
    public Users findByProperty(String property, Object value) {
        return userRepository.findByProperty(property, value);
    }

    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

}
