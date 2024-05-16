package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.SimpleDataAccess;

public interface UserRepository extends SimpleDataAccess<Users> {
    Users findByName(String firstName, String lastName);
    Users getUserByEmail(String email);
    void save(Users user);
}
