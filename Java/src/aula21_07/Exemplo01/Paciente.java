package aula21_07.Exemplo01;

import java.util.Random;
import java.util.Scanner;

public class Paciente {
    private int id;
    private String nome;
    private String dataNascimento;

    public Paciente() {
    }

    public Paciente(String nome, String dataNascimento) {
        this.id = new Random().nextInt(1000);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void cadastrar(Scanner scan){
        System.out.println("Nome");
        setNome(scan.next());
        System.out.println("Data");
        setDataNascimento(scan.next());
    }

    public void mostrar(){
        System.out.println("Nome " + getNome());
        System.out.println("Data " + getDataNascimento());

    }

}

