package aula21_07.exercicios.exec08.models;

public class Cartao {
    private int id;
    private String numero;
    private String tipo;
    private double limite;
    private ContaBancaria conta;
    private Banco banco;
    private static int contadorId;

    public Cartao() {
    }

    public Cartao(String numero, String tipo, double limite, ContaBancaria conta, Banco banco) {
        contadorId++;
        this.id = contadorId;
        this.numero = numero;
        this.tipo = tipo;
        this.limite = limite;
        this.conta = conta;
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public double getSaldoDisponivel() {
        if (tipo.equals("DEBITO")) {
            return conta.getSaldoDisponivel();
        } else {
            return limite;
        }
    }
}