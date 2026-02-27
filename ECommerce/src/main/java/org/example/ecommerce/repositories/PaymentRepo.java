package org.example.ecommerce.repositories;

import org.example.ecommerce.entitys.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepo extends JpaRepository<Payment, UUID> {
}
