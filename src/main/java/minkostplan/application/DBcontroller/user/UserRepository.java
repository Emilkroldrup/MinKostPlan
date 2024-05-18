package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.SimpleDataAccess;
import org.springframework.stereotype.Component;


public interface UserRepository extends SimpleDataAccess<Users> {
    Users findByUsername(String username);
    Users findByEmail(String email);
    void editUserDetails(Users users);
}
