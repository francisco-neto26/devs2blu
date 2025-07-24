package aula21_07.Exemplo01;

import java.util.Random;

public class Medico {
    private int id;
    private String nome;
    private String crm;
    private String especialidade;

    public Medico() {
    }

    public Medico(String nome, String crm, String especialidade) {
        this.id = new Random().nextInt(1000);
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
