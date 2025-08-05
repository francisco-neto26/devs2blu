package exercicios.exer04;

public class Gerente extends Funcionario{
    private double bonus;

    public Gerente(String nome, double salarioHora, double cargaHoraria, double bonus) {
        super(nome, salarioHora, cargaHoraria);
        this.bonus = bonus;
    }

    @Override
    public double calculaSalarioMensal() {
        double salario = super.calculaSalarioMensal();
        return salario + this.bonus;
    }
}
