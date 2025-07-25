package aula21_07.exercicios.exec08.models;

public class Banco {
    private int id;
    private int codigo;
    private String nome;
    private static int contadorId;

    public Banco() {
    }

    public Banco(int codigo, String nome) {
        contadorId++;
        this.id = contadorId;
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

