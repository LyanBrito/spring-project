package org.example.ecommerce.dto.users;

import lombok.*;
import org.example.ecommerce.entitys.Orders;
import org.example.ecommerce.entitys.enums.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersReq {
    private UUID id;
    private String name;
    private String email;
    private String tell;
    private String password;
    private Roles roles;
    private List<Orders> orders = new ArrayList<>();
}
