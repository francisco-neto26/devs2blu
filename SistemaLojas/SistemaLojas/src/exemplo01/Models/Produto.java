package exemplo01.Models;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private static int contadorId;
    private Categoria categoria;

    public Produto(String nome, double preco, Categoria categoria) {
        contadorId++;
        this.id = contadorId;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
