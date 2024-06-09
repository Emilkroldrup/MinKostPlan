package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.CustomExceptions.UnexpectedErrorHappendExpception;
import minkostplan.application.usecase.CustomExceptions.UserEmailAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users findByName(String firstName, String lastName) throws DataAccessException {
        try {
            return userRepository.findByName(firstName, lastName);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }

    public Users findByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }

    public void saveUser(Users user) throws DataAccessException, UserEmailAlreadyExistsException {
        try {
            userRepository.saveUser(user);
        } catch (UserEmailAlreadyExistsException ee) {
            logger.error("Same user email exists exception occurred while editing user details: {}", ee.getMessage());
            throw ee;
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }

    public boolean editUserDetails(Users user){
        try {
            if (!user.getFirstName().isEmpty() && !user.getLastName().isEmpty() && !user.getEmail().isEmpty() && user.getAge() >= 0 && user.getHeight() >= 0 && user.getWeight() >= 0 && !user.getGender().isEmpty() && !user.getGoal().isEmpty() && !user.getActivityLevel().isEmpty()) {
                userRepository.editUserDetails(user);
                return true;
            }
            return false;
        } catch (DuplicateKeyException ee) {
            logger.error("Same user email exists exception occurred while editing user details: {}", ee.getMessage());
            throw new UserEmailAlreadyExistsException("Email already exists: " + user.getEmail(),ee);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
                throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }

    public Users findByProperty(String property, Object value) throws DataAccessException {
        try {
            return userRepository.findByProperty(property, value);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }

    public List<Users> findAllUsers() throws DataAccessException {
        try {
            return userRepository.findAll();
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }
}