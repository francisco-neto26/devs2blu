package aula21_07.exercicios.exec04.models;

import java.util.Random;

public class PlacaMae {
    private int id;
    private String marca;
    private String modelo;
    private String socket;
    private String chipset;
    private int slotsRAM;
    private String tipoRAM;

    public PlacaMae() {
    }

    public PlacaMae(String marca, String modelo, String socket, String chipset, int slotsRAM, String tipoRAM) {
        this.id = new Random().nextInt(1000);
        this.marca = marca;
        this.modelo = modelo;
        this.socket = socket;
        this.chipset = chipset;
        this.slotsRAM = slotsRAM;
        this.tipoRAM = tipoRAM;
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public int getSlotsRAM() {
        return slotsRAM;
    }

    public void setSlotsRAM(int slotsRAM) {
        this.slotsRAM = slotsRAM;
    }

    public String getTipoRAM() {
        return tipoRAM;
    }

    public void setTipoRAM(String tipoRAM) {
        this.tipoRAM = tipoRAM;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " - Socket: " + socket + " - Chipset: " + chipset + " - " + slotsRAM + " slots " + tipoRAM;
    }
}