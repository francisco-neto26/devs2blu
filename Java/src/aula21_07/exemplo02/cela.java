package aula21_07.exemplo02;

import java.util.Random;

public class cela {
    private int id;
    private int numeroCela;
    private int capacidadeDetetos;
    private String nivelSeguranca;
    private pavilao pavilao;

    public cela() {
        this.id = new Random().nextInt(1000);
    }

    public cela(int numeroCela, int capacidadeDetetos, String nivelSeguranca, pavilao pavilao) {
        this.id = new Random().nextInt(1000);
        this.numeroCela = numeroCela;
        this.capacidadeDetetos = capacidadeDetetos;
        this.nivelSeguranca = nivelSeguranca;
        this.pavilao = pavilao;
    }

    public pavilao getPavilao() {
        return pavilao;
    }

    public void setPavilao(pavilao pavilao) {
        this.pavilao = pavilao;
    }

    public int getNumeroCela() {
        return numeroCela;
    }

    public void setNumeroCela(int numeroCela) {
        this.numeroCela = numeroCela;
    }

    public int getCapacidadeDetetos() {
        return capacidadeDetetos;
    }

    public void setCapacidadeDetetos(int capacidadeDetetos) {
        this.capacidadeDetetos = capacidadeDetetos;
    }

    public String getNivelSeguranca() {
        return nivelSeguranca;
    }

    public void setNivelSeguranca(String nivelSegurança) {
        this.nivelSeguranca = nivelSegurança;
    }
}

