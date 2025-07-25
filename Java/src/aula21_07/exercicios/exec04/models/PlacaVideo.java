package aula21_07.exercicios.exec04.models;

import java.util.Random;

public class PlacaVideo {
    private int id;
    private String marca;
    private String modelo;
    private String gpu;
    private int memoriaVRAM;
    private String tipoMemoria;
    private int consumo;

    public PlacaVideo() {
    }

    public PlacaVideo(String marca, String modelo, String gpu, int memoriaVRAM, String tipoMemoria, int consumo) {
        this.id = new Random().nextInt(1000);
        this.marca = marca;
        this.modelo = modelo;
        this.gpu = gpu;
        this.memoriaVRAM = memoriaVRAM;
        this.tipoMemoria = tipoMemoria;
        this.consumo = consumo;
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

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getMemoriaVRAM() {
        return memoriaVRAM;
    }

    public void setMemoriaVRAM(int memoriaVRAM) {
        this.memoriaVRAM = memoriaVRAM;
    }

    public String getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(String tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + gpu + ") - " + memoriaVRAM + "GB " + tipoMemoria + " - " + consumo + "W";
    }
}
