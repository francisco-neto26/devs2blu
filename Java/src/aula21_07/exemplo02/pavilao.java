package aula21_07.exemplo02;

import java.util.Random;

public class pavilao {
    private int id;
    private int numeroPavilhao;
    private int numeroCelas;

    public pavilao() {
        this.id = new Random().nextInt(1000);
    }

    public pavilao(int numeroPavilhao, int numeroCelas) {
        this.id = new Random().nextInt(1000);
        this.numeroPavilhao = numeroPavilhao;
        this.numeroCelas = numeroCelas;
    }

    public int getNumeroPavilhao() {
        return numeroPavilhao;
    }

    public void setNumeroPavilhao(int numeroPavilhao) {
        this.numeroPavilhao = numeroPavilhao;
    }

    public int getNumeroCelas() {
        return numeroCelas;
    }

    public void setNumeroCelas(int numeroCelas) {
        this.numeroCelas = numeroCelas;
    }
}