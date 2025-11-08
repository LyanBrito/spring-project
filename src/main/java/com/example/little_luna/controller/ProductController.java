package com.example.little_luna.controller;

import com.example.little_luna.dto.ProductRequestDTO;
import com.example.little_luna.dto.ProductResponseDTO;
import com.example.little_luna.entity.Product;
import com.example.little_luna.repositories.ProductRepo;
import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class ProductController {
    ProductRepo productRepo;

    @GetMapping(value = "product")
    public List<ProductResponseDTO> getProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductResponseDTO> produtosResponseDTO = new ArrayList<>();
        for (Product product : products) {
            produtosResponseDTO.add(new ProductResponseDTO(product));
        }
        return produtosResponseDTO;
    }

    @PostMapping(value = "product/addNew")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductRequestDTO produto) {
        Product prod = new Product(produto.getNome(), produto.getPrice(), produto.getQuant());
        productRepo.save(prod);
        return ResponseEntity.ok("Produto adicionado com sucesso");
    }
    // Criar depois: GetById, Delete & Put methods
}
