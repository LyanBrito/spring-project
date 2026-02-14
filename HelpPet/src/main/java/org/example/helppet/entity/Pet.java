package org.example.helppet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.helppet.dto.PetReqDTO;

@Entity
@Table(name= "pet_tb")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    private int id;
    private String name;
    private Category category;
    private String race;
    private int age;
    private boolean sex;

    public Pet(@Valid PetReqDTO req) {
        this.name = req.getName();
        this.category = req.getCategory();
        this.race = req.getRace();
        this.age = req.getAge();
        this.sex = req.isSex();
    }
}
