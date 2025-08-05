package exercicios.exer04;

public class Vendedor extends Funcionario{
    private double vendas;
    private double percentualComissao;

    public Vendedor(String nome, double salarioHora, double cargaHoraria, double vendas, double percentualComissao) {
        super(nome, salarioHora, cargaHoraria);
        this.vendas = vendas;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calculaSalarioMensal() {
        double salario = super.calculaSalarioMensal();
        return ((vendas * percentualComissao) / 100) + salario;
    }
}
