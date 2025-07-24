package aula21_07.exemplo02;

import java.util.Random;

public class detento {
    private int id;
    private String nome;
    private String dataEntrada;
    private int tempoPermanencia;
    private cela cela;

    public detento() {
        this.id = new Random().nextInt(1000);
    }

    public detento(String nome, String dataEntrada, int tempoPermanencia, cela cela) {
        this.id = new Random().nextInt(1000);
        this.nome = nome;
        this.dataEntrada = dataEntrada;
        this.tempoPermanencia = tempoPermanencia;
        this.cela = cela;
    }

    public cela getCela() {
        return cela;
    }

    public void setCela(cela cela) {
        this.cela = cela;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getTempoPermanencia() {
        return tempoPermanencia;
    }

    public void setTempoPermanencia(int tempoPermanencia) {
        this.tempoPermanencia = tempoPermanencia;
    }
}
