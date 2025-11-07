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
    @Column(length = 50, nullable = false)
    private double subPrice;

    public Product() {
    }


    public Product(String name, double price, int quant, double subPrice) {
        this.name = name;
        this.price = price;
        this.quant = quant;
        this.subPrice = subPrice;
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

    public double getPrice() {
        return price;
    }

    public int getQuant() {
        return quant;
    }

    public double getSubPrice() {
        return subPrice;
    }
}


