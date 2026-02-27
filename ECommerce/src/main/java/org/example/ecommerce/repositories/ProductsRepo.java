package org.example.ecommerce.repositories;

import org.example.ecommerce.entitys.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductsRepo extends JpaRepository<Products, UUID> {
}
