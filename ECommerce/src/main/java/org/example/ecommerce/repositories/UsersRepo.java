package org.example.ecommerce.repositories;

import org.example.ecommerce.entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepo extends JpaRepository<Users, UUID> {
}
