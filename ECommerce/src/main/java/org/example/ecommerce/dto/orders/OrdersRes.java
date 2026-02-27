package org.example.ecommerce.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommerce.entitys.Payment;
import org.example.ecommerce.entitys.Users;
import org.example.ecommerce.entitys.enums.OrderStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersRes {
    private UUID id;
    private LocalDate moment;
    private OrderStatus order_status;
    private Users client;
    private Payment payment;

    public OrdersRes(Users user) {
    }
}
