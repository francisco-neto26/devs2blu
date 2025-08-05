package exercicios.exer04;

public class Funcionario {
    private String nome;
    private double salarioHora;
    private double cargaHoraria;

    public Funcionario(String nome, double salarioHora, double cargaHoraria) {
        this.nome = nome;
        this.salarioHora = salarioHora;
        this.cargaHoraria = cargaHoraria;
    }

    public double calculaSalarioMensal() {
        return salarioHora * cargaHoraria;
    }
}
