package com.example.little_luna.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50, nullable = false)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private double price;
    @Column(length = 50, nullable = false)
    private int quant;

    public Product() {

    }
    public Product(int id, String nome, double price, int quant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quant = quant;
    }

    public Product(String name, double price, int quant) {
        this.name = name;
        this.price = price;
        this.quant = quant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {}

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {}
}


