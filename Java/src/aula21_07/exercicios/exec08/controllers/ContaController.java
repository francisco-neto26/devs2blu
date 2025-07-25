package aula21_07.exercicios.exec08.controllers;

import aula21_07.exercicios.exec08.models.*;
import java.util.ArrayList;
import java.util.List;

public class ContaController {
    private List<ContaBancaria> contas;

    public ContaController() {
        this.contas = new ArrayList<>();
    }

    public boolean cadastrar(ContaBancaria conta) {
        if (conta.getLimite() < 0) {
            System.out.println("Limite não pode ser negativo");
            return false;
        }
        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso");
        return true;
    }

    public boolean alterar(int numero, ContaBancaria novaContaa) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero() == numero) {
                if (novaContaa.getLimite() < 0) {
                    System.out.println("Limite não pode ser negativo");
                    return false;
                }
                contas.set(i, novaContaa);
                System.out.println("Conta alterada com sucesso");
                return true;
            }
        }
        System.out.println("Conta não encontrada");
        return false;
    }

    public boolean excluir(int numero) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero() == numero) {
                contas.remove(i);
                System.out.println("Conta excluída com sucesso");
                return true;
            }
        }
        System.out.println("Conta não encontrada");
        return false;
    }

    public void exibirDados() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada");
            return;
        }

        System.out.println("=== CONTAS CADASTRADAS ===");
        for (ContaBancaria conta : contas) {
            System.out.println("Número: " + conta.getNumero());
            System.out.println("Saldo: R$ " + conta.getSaldo());
            System.out.println("Limite: R$ " + conta.getLimite());
            System.out.println("Saldo Disponível: R$ " + conta.getSaldoDisponivel());
            System.out.println("Cliente: " + conta.getCliente().getNome());
            System.out.println("Banco: " + conta.getBanco().getNome());
            System.out.println("---");
        }
    }

    public ContaBancaria buscar(int numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public boolean depositar(int numero, double valor) {
        ContaBancaria conta = buscar(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada");
            return false;
        }

        if (valor <= 0) {
            System.out.println("Valor deve ser positivo");
            return false;
        }

        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Depósito realizado com sucesso");
        return true;
    }

    public boolean sacar(int numero, double valor) {
        ContaBancaria conta = buscar(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada");
            return false;
        }

        if (valor <= 0) {
            System.out.println("Valor deve ser positivo");
            return false;
        }

        if (valor > conta.getSaldoDisponivel()) {
            System.out.println("Saldo insuficiente");
            return false;
        }

        conta.setSaldo(conta.getSaldo() - valor);
        System.out.println("Saque realizado com sucesso");
        return true;
    }
}