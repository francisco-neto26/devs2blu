package aula21_07.exercicios.exec02.models;

import java.util.Random;

public class Pneus {
    private int id;
    private String marca;
    private int aro;

    public Pneus(String marca, int aro) {
        this.id = new Random().nextInt(1000);
        this.marca = marca;
        this.aro = aro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }
}