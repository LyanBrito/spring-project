package com.example.little_luna.repositories;

import com.example.little_luna.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
