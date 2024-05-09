package minkostplan.application.repository.user;

import java.util.List;

import minkostplan.application.entity.user;

public interface UserRepository {

    user findByUsername(String username);

    List<user> getAllUsers();
    
}