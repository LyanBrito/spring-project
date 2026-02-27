package org.example.ecommerce.repositories;

import org.example.ecommerce.entitys.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersRepo extends JpaRepository<Orders, UUID> {
}
