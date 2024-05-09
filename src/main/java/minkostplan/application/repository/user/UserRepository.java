package minkostplan.application.repository.user;

import minkostplan.application.entity.User;

public interface UserRepository {

    User findByUsername(String username);
    
}