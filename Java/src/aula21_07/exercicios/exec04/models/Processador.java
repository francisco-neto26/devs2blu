package aula21_07.exercicios.exec04.models;

import java.util.Random;

public class Processador {
    private int id;
    private String marca;
    private String modelo;
    private double frequencia;
    private int nucleos;
    private String arquitetura;


    public Processador() {
    }


    public Processador(String marca, String modelo, double frequencia, int nucleos, String arquitetura) {
        this.id = new Random().nextInt(1000);
        this.marca = marca;
        this.modelo = modelo;
        this.frequencia = frequencia;
        this.nucleos = nucleos;
        this.arquitetura = arquitetura;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " - " + frequencia + "GHz - " + nucleos + " núcleos - " + arquitetura;
    }
}
