package com.example.little_luna.repositories;

import com.example.little_luna.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    public Product findByName(String name);
    public double findByPrice(double price);
    public int findByQuant(int quant);
}