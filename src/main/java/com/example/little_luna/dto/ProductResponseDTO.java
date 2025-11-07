package com.example.little_luna.dto;

public class ProductResponseDTO {
    private String nome;
    private double preco;
    private int quantidade;
    private double subValor;

    public ProdutoResponseDTO(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
        this.subValor = preco * quantidade;
    }

}
