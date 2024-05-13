package minkostplan.application.DBcontroller.user;

import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.SimpleDataAccess;

public interface UserRepository extends SimpleDataAccess<Users> {
    Users findByUsername(String username);
    Users getUserByEmail(String email);
}
