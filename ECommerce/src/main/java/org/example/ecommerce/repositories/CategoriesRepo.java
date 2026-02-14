package org.example.ecommerce.repositories;

import org.example.ecommerce.entitys.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriesRepo extends JpaRepository<Categories, UUID> {
}
