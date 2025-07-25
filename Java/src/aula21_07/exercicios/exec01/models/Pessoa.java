package aula21_07.exercicios.exec01.models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private double altura;
    private Endereco endereco;
    private ArrayList<Trabalho> trabalho = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, double altura, Endereco endereco) {
        this.id = new Random().nextInt(1000);
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.endereco = endereco;
        this.trabalho = new ArrayList<>();
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Trabalho> getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(ArrayList<Trabalho> trabalho) {
        this.trabalho = trabalho;
    }

}

