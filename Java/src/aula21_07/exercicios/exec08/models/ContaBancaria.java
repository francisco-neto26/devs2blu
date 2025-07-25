package aula21_07.exercicios.exec08.models;

public class ContaBancaria {
    private int id;
    private int numero;
    private double saldo;
    private double limite;
    private Cliente cliente;
    private Banco banco;
    private static int contadorId;

    public ContaBancaria() {
    }

    public ContaBancaria(int numero, double limite, Cliente cliente, Banco banco) {
        contadorId++;
        this.id = contadorId;
        this.numero = numero;
        this.saldo = 0.0;
        this.limite = limite;
        this.cliente = cliente;
        this.banco = banco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public double getSaldoDisponivel() {
        return saldo + limite;
    }
}