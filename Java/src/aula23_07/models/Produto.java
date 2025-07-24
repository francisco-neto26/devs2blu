package aula23_07.models;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private static int contadorId;

    public Produto(String nome, double preco) {
        contadorId++;
        this.id = contadorId;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }


}