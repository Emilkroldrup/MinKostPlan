package minkostplan.application.repository.user;

import java.util.List;

import minkostplan.application.entity.Users;

public interface UserRepository {

    Users findByUsername(String username);

    List<Users> getAllUsers();
    
}