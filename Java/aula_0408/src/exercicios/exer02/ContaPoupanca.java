package exercicios.exer02;

public class ContaPoupanca extends ContaBancaria{
    private double taxaJuros;

    public ContaPoupanca(String titular) {
        super(titular);
        this.taxaJuros = 5.0;
    }
    public double aplicarJuros(){
        double saldo = getSaldo();
        double valorJuros = saldo * (taxaJuros / 100);
        return  valorJuros;
    }

    @Override
    public String toString() {
        String txt = super.toString();
        return txt + " com valor de juros " + aplicarJuros() + " saldo total + " + (getSaldo() + aplicarJuros());
    }
}
