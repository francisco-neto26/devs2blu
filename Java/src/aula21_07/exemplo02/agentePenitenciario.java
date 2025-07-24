package aula21_07.exemplo02;

import java.util.Random;

public class agentePenitenciario {
    private int id;
    private String nome;
    private String turno;
    private pavilao pavilao;

    public agentePenitenciario() {
        this.id = new Random().nextInt(1000);
    }

    public agentePenitenciario(String nome, String turno, pavilao pavilao) {
        this.id = new Random().nextInt(1000);
        this.nome = nome;
        this.turno = turno;
        this.pavilao = pavilao;
    }

    public pavilao getPavilao() {
        return pavilao;
    }

    public void setPavilao(pavilao pavilao) {
        this.pavilao = pavilao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
