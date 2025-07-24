package aula21_07.Exemplo01;

import java.util.Random;

public class Consulta {
    private int id;
    private String dataConsulta;
    private String observacoes;
    private Paciente Paciente;
    private Medico medico;

    public Consulta() {
        this.id = new Random().nextInt(1000);
    }

    public Consulta(String dataConsulta, String observacoes, Paciente paciente, Medico medico) {
        this.id = new Random().nextInt(1000);
        this.dataConsulta = dataConsulta;
        this.observacoes = observacoes;
        this.Paciente = paciente;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Paciente getPaciente() {
        return Paciente;
    }

    public void setPaciente(Paciente paciente) {
        Paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}

