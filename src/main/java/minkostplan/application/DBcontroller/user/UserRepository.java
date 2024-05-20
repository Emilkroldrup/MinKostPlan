package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.SimpleDataAccess;


public interface UserRepository extends SimpleDataAccess<Users> {
    Users findByName(String firstName, String lastName);
    Users findByEmail(String email);
    void save(Users user);
    void editUserDetails(Users users);
}