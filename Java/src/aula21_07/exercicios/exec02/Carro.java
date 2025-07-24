package aula21_07.exercicios.exec02;

import java.util.ArrayList;

public class Carro {
    private int id;
    private Motor motor;
    private ArrayList<pneus> pneus;
    private String modelo;
    private String marca;
    private String cor;

    public Carro() {
    }

    public Carro(Motor motor, ArrayList<pneus> pneus, String modelo, String marca, String cor) {
        this.motor = motor;
        this.pneus = pneus;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public ArrayList<pneus> getPneus() {
        return pneus;
    }

    public void setPneus(ArrayList<pneus> pneus) {
        this.pneus = pneus;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}

