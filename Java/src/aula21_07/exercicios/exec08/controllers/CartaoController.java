package aula21_07.exercicios.exec08.controllers;

import aula21_07.exercicios.exec08.models.*;
import java.util.ArrayList;
import java.util.List;

public class CartaoController {
    private List<Cartao> cartoes;

    public CartaoController() {
        this.cartoes = new ArrayList<>();
    }

    public boolean cadastrar(Cartao cartao) {
        if (!cartao.getTipo().equals("DEBITO") && !cartao.getTipo().equals("CREDITO")) {
            System.out.println("Tipo deve ser DEBITO ou CREDITO");
            return false;
        }

        if (cartao.getTipo().equals("CREDITO") && cartao.getLimite() <= 0) {
            System.out.println("Cartão de crédito deve ter limite positivo");
            return false;
        }

        if (cartao.getTipo().equals("DEBITO")) {
            cartao.setLimite(0);
        }

        cartoes.add(cartao);
        System.out.println("Cartão cadastrado com sucesso");
        return true;
    }

    public boolean alterar(String numero, Cartao novoCartao) {
        for (int i = 0; i < cartoes.size(); i++) {
            if (cartoes.get(i).getNumero().equals(numero)) {
                if (!novoCartao.getTipo().equals("DEBITO") && !novoCartao.getTipo().equals("CREDITO")) {
                    System.out.println("Tipo deve ser DEBITO ou CREDITO");
                    return false;
                }

                if (novoCartao.getTipo().equals("CREDITO") && novoCartao.getLimite() <= 0) {
                    System.out.println("Cartão de crédito deve ter limite positivo");
                    return false;
                }

                if (novoCartao.getTipo().equals("DEBITO")) {
                    novoCartao.setLimite(0);
                }

                cartoes.set(i, novoCartao);
                System.out.println("Cartão alterado com sucesso");
                return true;
            }
        }
        System.out.println("Cartão não encontrado");
        return false;
    }

    public boolean excluir(String numero) {
        for (int i = 0; i < cartoes.size(); i++) {
            if (cartoes.get(i).getNumero().equals(numero)) {
                cartoes.remove(i);
                System.out.println("Cartão excluído com sucesso");
                return true;
            }
        }
        System.out.println("Cartão não encontrado");
        return false;
    }

    public void exibirDados() {
        if (cartoes.isEmpty()) {
            System.out.println("Nenhum cartão cadastrado");
            return;
        }

        System.out.println("=== CARTÕES CADASTRADOS ===");
        for (Cartao cartao : cartoes) {
            System.out.println("Número: " + cartao.getNumero());
            System.out.println("Tipo: " + cartao.getTipo());

            if (cartao.getTipo().equals("CREDITO")) {
                System.out.println("Limite: R$ " + cartao.getLimite());
            } else {
                System.out.println("Saldo Disponível: R$ " + cartao.getSaldoDisponivel());
            }

            System.out.println("Conta: " + cartao.getConta().getNumero());
            System.out.println("Banco: " + cartao.getBanco().getNome());
            System.out.println("---");
        }
    }

    public Cartao buscar(String numero) {
        for (Cartao cartao : cartoes) {
            if (cartao.getNumero().equals(numero)) {
                return cartao;
            }
        }
        return null;
    }

    public boolean usarCartao(String numero, double valor) {
        Cartao cartao = buscar(numero);
        if (cartao == null) {
            System.out.println("Cartão não encontrado");
            return false;
        }

        if (valor <= 0) {
            System.out.println("Valor deve ser positivo");
            return false;
        }

        if (cartao.getTipo().equals("DEBITO")) {
            if (valor > cartao.getConta().getSaldoDisponivel()) {
                System.out.println("Saldo insuficiente na conta");
                return false;
            }
            cartao.getConta().setSaldo(cartao.getConta().getSaldo() - valor);
        } else {
            if (valor > cartao.getLimite()) {
                System.out.println("Limite do cartão insuficiente");
                return false;
            }
            cartao.setLimite(cartao.getLimite() - valor);
        }

        System.out.println("Transação realizada com sucesso");
        return true;
    }
}
