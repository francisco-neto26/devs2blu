package exercicios.exer02;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular) {
        this.saldo = 0.0;
        this.titular = titular;
    }

    public void depositar(double valor){
        this.saldo = this.saldo + valor;
    }
    public void sacar (double valor){
        this.saldo = this.saldo - valor;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta Bancaria do titular " + titular +
                " com saldo saldo=" + saldo;
    }
}
