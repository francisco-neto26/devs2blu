package aula21_07.exercicios.exec08.models;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private static int contadorId;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf) {
        contadorId++;
        this.id = contadorId;
        this.nome = nome;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
