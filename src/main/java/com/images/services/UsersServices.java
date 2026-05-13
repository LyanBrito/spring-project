package com.images.services;

import com.images.entities.User;
import com.images.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {
    public final UserRepo userRepo;

    public UsersServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(String name, String email, String path){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoto(path);

        return userRepo.save(user);
    }
}
