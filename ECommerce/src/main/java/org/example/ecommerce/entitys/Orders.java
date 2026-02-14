package org.example.ecommerce.entitys;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.entitys.enums.OrderStatus;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate moment;
    private OrderStatus order_status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Users client;
}
