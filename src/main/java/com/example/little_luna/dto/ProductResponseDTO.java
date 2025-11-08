package com.example.little_luna.dto;

import com.example.little_luna.entity.Product;

public class ProductResponseDTO {
    private String nome;
    private double preco;
    private int quantidade;
    private double subValor;

    public ProductResponseDTO(Product product) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.subValor = preco * quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubValor() {
        return subValor;
    }

    @Override
    public String toString() {
        return "ProductResponseDTO{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", subValor=" + subValor +
                '}';
    }
}
