package aula21_07.exercicios.exec04.models;

import java.util.Random;

public class Computador {
    private int id;
    private String nome;
    private String marca;
    private Processador processador;
    private PlacaMae placaMae;
    private PlacaVideo placaVideo;
    private String gabinete;
    private int memoriaRAM;

    // Construtor vazio
    public Computador() {
    }

    public Computador(String nome, String marca, String gabinete, int memoriaRAM) {
        this.id = new Random().nextInt(1000);
        this.nome = nome;
        this.marca = marca;
        this.gabinete = gabinete;
        this.memoriaRAM = memoriaRAM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Processador getProcessador() {
        return processador;
    }

    public void setProcessador(Processador processador) {
        this.processador = processador;
    }

    public PlacaMae getPlacaMae() {
        return placaMae;
    }

    public void setPlacaMae(PlacaMae placaMae) {
        this.placaMae = placaMae;
    }

    public PlacaVideo getPlacaVideo() {
        return placaVideo;
    }

    public void setPlacaVideo(PlacaVideo placaVideo) {
        this.placaVideo = placaVideo;
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }
}