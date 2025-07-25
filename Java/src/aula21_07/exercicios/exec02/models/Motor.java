package aula21_07.exercicios.exec02.models;

import java.util.Random;

public class Motor {
    private int id;
    private int potencia;
    private String tipoCombustivel;

    public Motor(int potencia, String tipoCombustivel) {
        this.id = new Random().nextInt(1000);
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
}
