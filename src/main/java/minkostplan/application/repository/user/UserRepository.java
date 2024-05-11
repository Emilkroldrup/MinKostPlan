package minkostplan.application.repository.user;

import minkostplan.application.entity.Users;
import minkostplan.application.repository.SimpleDataAccess;

public interface UserRepository extends SimpleDataAccess<Users> {
    Users findByUsername(String username);
}
