package org.example.ecommerce.dto.users;

import lombok.*;
import org.example.ecommerce.entitys.Orders;
import org.example.ecommerce.entitys.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersRes {
    private String name;
    private String email;
    private String tell;
    private List<Orders> orders = new ArrayList<>();

    public UsersRes(Users users) {
    }
}
