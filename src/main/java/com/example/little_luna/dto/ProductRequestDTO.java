package com.example.little_luna.dto;
import com.example.little_luna.entity.Product;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public class ProductRequestDTO {
    @NotBlank(message = "Coloca o nome fiote")
    private String nome;
    @DecimalMin(value = "0.01", inclusive = true)
    private double price = 0;
    private int quant = 0;

    public ProductRequestDTO(Product produto) {
        this.nome = produto.getName();
        this.price = produto.getPrice();
        this.quant = produto.getQuant();
    }
    public ProductRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuantidade(int quant) {
        this.quant = this.quant;
    }
}
