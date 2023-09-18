package com.example.listacompras;

public class Compra {

    private String nome;
    private String marca;
    private String quantidade;

    public Compra() {
    }

    @Override
    public String toString() {
        return "Compra{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", quantidade='" + quantidade + '\'' +
                '}';
    }

    public Compra(String nome, String marca, String quantidade) {
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
