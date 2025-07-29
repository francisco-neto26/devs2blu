package Perfumes.models;

public class Perfume {
    private int id;
    private String nome;
    private double preco;
    private String marca;
    private double volume;
    private Formula formula;
    private static int contadorId;

    public Perfume(String nome, double preco, String marca, double volume, Formula formula) {
        contadorId++;
        this.id = contadorId;
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.volume = volume;
        this.formula = formula;
    }

    public int getId() {
        return id;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }
}
