package aula21_07.exercicios.exec01.models;

import java.util.Random;

public class Trabalho {
    private int id;
    private String nomeEmpresa;
    private String turno;
    private String dataInicio;
    private double salario;

    public Trabalho(String nomeEmpresa, String turno, String dataInicio, double salario) {
        this.id = new Random().nextInt(1000);
        this.nomeEmpresa = nomeEmpresa;
        this.turno = turno;
        this.dataInicio = dataInicio;
        this.salario = salario;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empresa: " + nomeEmpresa +
                ", Turno: " + turno +
                ", Início: " + dataInicio +
                ", Salário: R$ " + salario;
    }

}

