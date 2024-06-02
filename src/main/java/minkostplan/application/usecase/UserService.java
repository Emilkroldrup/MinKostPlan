package minkostplan.application.usecase;


import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public Users findByName(String firstName, String lastName){
        try {
            return  userRepository.findByName(firstName,lastName);
        }  catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            System.out.println("No names for a user like that exists" + emptyResultDataAccessException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

    public Users findByEmail(String email){
        try {
            return userRepository.findByEmail(email);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            System.out.println("No email such email is used for a user" + emptyResultDataAccessException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

    public void saveUser(Users user){
        try {
            userRepository.saveUser(user);
        } catch (DuplicateKeyException duplicateKeyException){
            System.out.println("Such user email already exists" + duplicateKeyException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }

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

    public Users findByProperty(String property, Object value){
        try {
            userRepository.findByProperty(property,value);
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

    public List<Users> findAllUsers(){
        try {
            userRepository.findAll();
        }  catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

}
