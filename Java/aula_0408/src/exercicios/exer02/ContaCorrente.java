package exercicios.exer02;

import java.util.Scanner;

public class ContaCorrente extends ContaBancaria{
    private double chequeEspecial;
    private double chequeEspecialUsado;
    Scanner scan = new Scanner(System.in);
    public ContaCorrente(String titular, double chequeEspecial) {
        super(titular);
        this.chequeEspecial = chequeEspecial;
        this.chequeEspecialUsado = 0.0;
    }
    @Override
    public void sacar(double valor) {
        double saldo = getSaldo();
        if((saldo == 0 || saldo < valor) && valor <= (saldo + this.chequeEspecial)){
            System.out.println("Sem saldo deseja usar o limite? 1 - Sim 2 - Não");
            if (scan.nextInt() == 1){
                valor = valor - saldo;
                super.sacar(saldo);
                this.chequeEspecialUsado = chequeEspecialUsado + valor;
            }
        }else if (valor <= saldo){
            super.sacar(valor);
        }else{
            System.out.println("Sem disponibilidade para saque");
        }
    }
    @Override
    public void depositar(double valor) {
        if(this.chequeEspecialUsado <= this.chequeEspecial){
            valor = valor - this.chequeEspecialUsado;
            this.chequeEspecialUsado = 0.0;
            super.depositar(valor);
        }else{
            super.depositar(valor);
        }
    }

    @Override
    public String toString() {
        String txt = super.toString();
        return txt + " limite de chequeEspecial = " + this.chequeEspecial + " disponivel cheque especial = " + (this.chequeEspecial - this.chequeEspecialUsado);
    }
}
