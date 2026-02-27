package org.example.helppet.dto;

import org.example.helppet.entity.Category;
import org.example.helppet.entity.Pet;

public class PetResDTO {
    private String name;
    private Category category;
    private String race;
    private int age;
    private boolean sex;

    public PetResDTO() {
    }
    public PetResDTO(Pet pet) {
        this.name = pet.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}

