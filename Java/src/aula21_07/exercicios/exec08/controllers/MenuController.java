// aula21_07.exercicios.exec08.controllers.MenuController
package aula21_07.exercicios.exec08.controllers;

import aula21_07.exercicios.exec08.models.*;
import java.util.Scanner;

public class MenuController {
    private ContaController contaController;
    private CartaoController cartaoController;

    public MenuController() {
        this.contaController = new ContaController();
        this.cartaoController = new CartaoController();
    }

    public void menu(Scanner scan) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== SISTEMA BANCÁRIO ===");
            System.out.println("1 - Menu Contas");
            System.out.println("2 - Menu Cartões");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta) {
                case 1:
                    menuContas(scan);
                    break;
                case 2:
                    menuCartoes(scan);
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private void menuContas(Scanner scan) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n=== MENU CONTAS ===");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Alterar Conta");
            System.out.println("3 - Excluir Conta");
            System.out.println("4 - Mostrar Contas");
            System.out.println("5 - Depositar");
            System.out.println("6 - Sacar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta) {
                case 1:
                    cadastrarConta(scan);
                    break;
                case 2:
                    alterarConta(scan);
                    break;
                case 3:
                    excluirConta(scan);
                    break;
                case 4:
                    contaController.exibirDados();
                    break;
                case 5:
                    depositar(scan);
                    break;
                case 6:
                    sacar(scan);
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private void menuCartoes(Scanner scan) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n=== MENU CARTÕES ===");
            System.out.println("1 - Cadastrar Cartão");
            System.out.println("2 - Alterar Cartão");
            System.out.println("3 - Excluir Cartão");
            System.out.println("4 - Mostrar Cartões");
            System.out.println("5 - Usar Cartão");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta) {
                case 1:
                    cadastrarCartao(scan);
                    break;
                case 2:
                    alterarCartao(scan);
                    break;
                case 3:
                    excluirCartao(scan);
                    break;
                case 4:
                    cartaoController.exibirDados();
                    break;
                case 5:
                    usarCartao(scan);
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private void cadastrarConta(Scanner scan) {
        System.out.print("Número da conta: ");
        int numero = Integer.parseInt(scan.nextLine());

        System.out.print("Limite da conta: ");
        double limite = Double.parseDouble(scan.nextLine());

        System.out.print("ID do cliente: ");
        int idCliente = Integer.parseInt(scan.nextLine());

        System.out.print("Nome do cliente: ");
        String nomeCliente = scan.nextLine();

        System.out.print("CPF do cliente: ");
        String cpfCliente = scan.nextLine();

        System.out.print("Código do banco: ");
        int codigoBanco = Integer.parseInt(scan.nextLine());

        System.out.print("Nome do banco: ");
        String nomeBanco = scan.nextLine();

        Cliente cliente = new Cliente(idCliente, nomeCliente, cpfCliente);
        Banco banco = new Banco(codigoBanco, nomeBanco);
        ContaBancaria conta = new ContaBancaria(numero, limite, cliente, banco);

        contaController.cadastrar(conta);
    }

    private void alterarConta(Scanner scan) {
        System.out.print("Número da conta a alterar: ");
        int numero = Integer.parseInt(scan.nextLine());

        System.out.print("Novo limite da conta: ");
        double limite = Double.parseDouble(scan.nextLine());

        System.out.print("Novo ID do cliente: ");
        int idCliente = Integer.parseInt(scan.nextLine());

        System.out.print("Novo nome do cliente: ");
        String nomeCliente = scan.nextLine();

        System.out.print("Novo CPF do cliente: ");
        String cpfCliente = scan.nextLine();

        System.out.print("Novo código do banco: ");
        int codigoBanco = Integer.parseInt(scan.nextLine());

        System.out.print("Novo nome do banco: ");
        String nomeBanco = scan.nextLine();

        Cliente cliente = new Cliente(idCliente, nomeCliente, cpfCliente);
        Banco banco = new Banco(codigoBanco, nomeBanco);
        ContaBancaria novaConta = new ContaBancaria(numero, limite, cliente, banco);

        contaController.alterar(numero, novaConta);
    }

    private void excluirConta(Scanner scan) {
        System.out.print("Número da conta a excluir: ");
        int numero = Integer.parseInt(scan.nextLine());
        contaController.excluir(numero);
    }

    private void depositar(Scanner scan) {
        System.out.print("Número da conta: ");
        int numero = Integer.parseInt(scan.nextLine());

        System.out.print("Valor do depósito: ");
        double valor = Double.parseDouble(scan.nextLine());

        contaController.depositar(numero, valor);
    }

    private void sacar(Scanner scan) {
        System.out.print("Número da conta: ");
        int numero = Integer.parseInt(scan.nextLine());

        System.out.print("Valor do saque: ");
        double valor = Double.parseDouble(scan.nextLine());

        contaController.sacar(numero, valor);
    }

    private void cadastrarCartao(Scanner scan) {
        System.out.print("Número do cartão: ");
        String numeroCartao = scan.nextLine();

        System.out.print("Tipo (DEBITO/CREDITO): ");
        String tipo = scan.nextLine().toUpperCase();

        double limite = 0;
        if (tipo.equals("CREDITO")) {
            System.out.print("Limite do cartão: ");
            limite = Double.parseDouble(scan.nextLine());
        }

        System.out.print("Número da conta vinculada: ");
        int numeroConta = Integer.parseInt(scan.nextLine());

        ContaBancaria conta = contaController.buscar(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada");
            return;
        }

        System.out.print("Código do banco: ");
        int codigoBanco = Integer.parseInt(scan.nextLine());

        System.out.print("Nome do banco: ");
        String nomeBanco = scan.nextLine();

        Banco banco = new Banco(codigoBanco, nomeBanco);
        Cartao cartao = new Cartao(numeroCartao, tipo, limite, conta, banco);

        cartaoController.cadastrar(cartao);
    }

    private void alterarCartao(Scanner scan) {
        System.out.print("Número do cartão a alterar: ");
        String numeroCartao = scan.nextLine();

        System.out.print("Novo tipo (DEBITO/CREDITO): ");
        String tipo = scan.nextLine().toUpperCase();

        double limite = 0;
        if (tipo.equals("CREDITO")) {
            System.out.print("Novo limite do cartão: ");
            limite = Double.parseDouble(scan.nextLine());
        }

        System.out.print("Número da nova conta vinculada: ");
        int numeroConta = Integer.parseInt(scan.nextLine());

        ContaBancaria conta = contaController.buscar(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada");
            return;
        }

        System.out.print("Novo código do banco: ");
        int codigoBanco = Integer.parseInt(scan.nextLine());

        System.out.print("Novo nome do banco: ");
        String nomeBanco = scan.nextLine();

        Banco banco = new Banco(codigoBanco, nomeBanco);
        Cartao novoCartao = new Cartao(numeroCartao, tipo, limite, conta, banco);

        cartaoController.alterar(numeroCartao, novoCartao);
    }

    private void excluirCartao(Scanner scan) {
        System.out.print("Número do cartão a excluir: ");
        String numeroCartao = scan.nextLine();
        cartaoController.excluir(numeroCartao);
    }

    private void usarCartao(Scanner scan) {
        System.out.print("Número do cartão: ");
        String numeroCartao = scan.nextLine();

        System.out.print("Valor da transação: ");
        double valor = Double.parseDouble(scan.nextLine());

        cartaoController.usarCartao(numeroCartao, valor);
    }
}