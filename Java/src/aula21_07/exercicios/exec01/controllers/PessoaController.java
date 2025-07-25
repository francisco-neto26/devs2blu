package aula21_07.exercicios.exec01.controllers;

import aula21_07.exercicios.exec01.models.Endereco;
import aula21_07.exercicios.exec01.models.Pessoa;
import aula21_07.exercicios.exec01.models.Trabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class PessoaController {

    public void cadastrar(Scanner scan, ArrayList<Pessoa> pessoas) {
        Pessoa novaPessoa = new Pessoa();

        System.out.print("Digite o nome da pessoa: ");
        novaPessoa.setNome(scan.nextLine());

        System.out.print("Digite a idade: ");
        novaPessoa.setIdade(Integer.parseInt(scan.nextLine()));

        System.out.print("Digite a altura (em metros, ex: 1.75): ");
        novaPessoa.setAltura(Double.parseDouble(scan.nextLine()));

        System.out.println("----- Cadastro de Endereço -----");
        System.out.print("Logradouro: ");
        String logradouro = scan.nextLine();

        System.out.print("Número: ");
        String numero = scan.nextLine();

        System.out.print("Bairro: ");
        String bairro = scan.nextLine();

        System.out.print("CEP: ");
        String cep = scan.nextLine();

        System.out.print("Cidade: ");
        String cidade = scan.nextLine();

        System.out.print("Estado: ");
        String estado = scan.nextLine();

        System.out.print("País: ");
        String pais = scan.nextLine();

        novaPessoa.setEndereco(new Endereco(logradouro, numero, bairro, cep, cidade, estado, pais));

        String resposta = "s";
        while (resposta.equalsIgnoreCase("s")) {
            System.out.print("\nDeseja cadastrar trabalhos para essa pessoa? (s/n): ");
            resposta = scan.nextLine();
            if(resposta.equalsIgnoreCase("s")){
                cadastrarTrabalhos(scan, novaPessoa);
            }
        }

        pessoas.add(novaPessoa);
        System.out.println("\nCadastro realizado com sucesso!");
    }

    public void cadastrarTrabalhos(Scanner scan, Pessoa pessoa) {
        System.out.println("\n--- Cadastro de Trabalho ---");

        System.out.print("Nome da Empresa: ");
        String nomeEmpresa = scan.nextLine();

        System.out.print("Turno (ex: manhã, tarde, noite): ");
        String turno = scan.nextLine();

        System.out.print("Data de Início (ex: 01/01/2020): ");
        String dataInicio = scan.nextLine();

        System.out.print("Salário: ");
        double salario = Double.parseDouble(scan.nextLine());

        Trabalho t = new Trabalho(nomeEmpresa, turno, dataInicio, salario);

        if (pessoa.getTrabalho() == null) {
            pessoa.setTrabalho(new ArrayList<>());
        }
        pessoa.getTrabalho().add(t);
    }

    public void mostrar(ArrayList<Pessoa> pessoas) {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            System.out.println("\n=== PESSOA " + (i + 1) + " ===");
            mostrarPessoa(pessoa);
        }
    }

    private void mostrarPessoa(Pessoa pessoa) {
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Altura: " + pessoa.getAltura() + " m");

        if (pessoa.getEndereco() != null) {
            System.out.println("\n--- Endereço ---");
            System.out.println("Logradouro: " + pessoa.getEndereco().getLogradouro());
            System.out.println("Número: " + pessoa.getEndereco().getNumero());
            System.out.println("Bairro: " + pessoa.getEndereco().getBairro());
            System.out.println("CEP: " + pessoa.getEndereco().getCep());
            System.out.println("Cidade: " + pessoa.getEndereco().getCidade());
            System.out.println("Estado: " + pessoa.getEndereco().getEstado());
            System.out.println("País: " + pessoa.getEndereco().getPais());
        } else {
            System.out.println("\nEndereço não informado.");
        }

        if (pessoa.getTrabalho() != null && !pessoa.getTrabalho().isEmpty()) {
            System.out.println("\n--- Trabalhos ---");
            for (Trabalho t : pessoa.getTrabalho()) {
                System.out.println("- " + t.toString());
            }
        } else {
            System.out.println("\nNenhum trabalho cadastrado.");
        }
    }

    private Pessoa selecionarPessoa(Scanner scan, ArrayList<Pessoa> pessoas) {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return null;
        }

        System.out.println("\n--- Selecione uma pessoa ---");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println((i + 1) + " - " + pessoas.get(i).getNome());
        }

        System.out.print("Digite o número da pessoa: ");
        int indice = Integer.parseInt(scan.nextLine()) - 1;

        if (indice >= 0 && indice < pessoas.size()) {
            return pessoas.get(indice);
        } else {
            System.out.println("Pessoa não encontrada.");
            return null;
        }
    }

    public void excluir(Scanner scan, ArrayList<Pessoa> pessoas) {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada para excluir.");
            return;
        }

        System.out.println("\n=== EXCLUIR ===");
        System.out.println("1 - Excluir pessoa completa");
        System.out.println("2 - Excluir trabalho de uma pessoa");
        System.out.print("Escolha uma opção: ");

        int opcao = Integer.parseInt(scan.nextLine());

        switch (opcao) {
            case 1:
                excluirPessoa(scan, pessoas);
                break;
            case 2:
                excluirTrabalho(scan, pessoas);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private void excluirPessoa(Scanner scan, ArrayList<Pessoa> pessoas) {
        System.out.println("\n--- Excluir Pessoa ---");
        Pessoa pessoaEscolhida = selecionarPessoa(scan, pessoas);

        if (pessoaEscolhida != null) {
            System.out.println("\nDados da pessoa que será excluída:");
            mostrarPessoa(pessoaEscolhida);

            System.out.print("\nTem certeza que deseja excluir esta pessoa? (s/n): ");
            String confirmacao = scan.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                pessoas.remove(pessoaEscolhida);
                System.out.println("Pessoa excluída com sucesso!");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        }
    }

    private void excluirTrabalho(Scanner scan, ArrayList<Pessoa> pessoas) {
        System.out.println("\n--- Excluir Trabalho ---");
        Pessoa pessoaEscolhida = selecionarPessoa(scan, pessoas);

        if (pessoaEscolhida != null) {
            if (pessoaEscolhida.getTrabalho() == null || pessoaEscolhida.getTrabalho().isEmpty()) {
                System.out.println("Esta pessoa não possui trabalhos cadastrados.");
                return;
            }

            System.out.println("\n--- Trabalhos de " + pessoaEscolhida.getNome() + " ---");
            ArrayList<Trabalho> trabalhos = pessoaEscolhida.getTrabalho();

            for (int i = 0; i < trabalhos.size(); i++) {
                System.out.println((i + 1) + " - " + trabalhos.get(i).toString());
            }

            System.out.print("Digite o número do trabalho a ser excluído: ");
            int indiceTrabalho = Integer.parseInt(scan.nextLine()) - 1;

            if (indiceTrabalho >= 0 && indiceTrabalho < trabalhos.size()) {
                Trabalho trabalhoExcluido = trabalhos.get(indiceTrabalho);
                System.out.println("\nTrabalho que será excluído: " + trabalhoExcluido.toString());

                System.out.print("Tem certeza que deseja excluir este trabalho? (s/n): ");
                String confirmacao = scan.nextLine();

                if (confirmacao.equalsIgnoreCase("s")) {
                    trabalhos.remove(indiceTrabalho);
                    System.out.println("Trabalho excluído com sucesso!");
                } else {
                    System.out.println("Exclusão cancelada.");
                }
            } else {
                System.out.println("Trabalho não encontrado.");
            }
        }
    }

    public void menu(Scanner scan, ArrayList<Pessoa> pessoas) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar Pessoa");
            System.out.println("2 - Cadastrar novo trabalho para pessoa");
            System.out.println("3 - Mostrar dados");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta) {
                case 1:
                    cadastrar(scan, pessoas);
                    break;
                case 2:
                    Pessoa pessoaEscolhida = selecionarPessoa(scan, pessoas);
                    if (pessoaEscolhida != null) {
                        String resposta2 = "s";
                        while (resposta2.equalsIgnoreCase("s")) {
                            cadastrarTrabalhos(scan, pessoaEscolhida);
                            System.out.print("\nDeseja cadastrar outro trabalho para esta pessoa? (s/n): ");
                            resposta2 = scan.nextLine();
                        }
                    }
                    break;
                case 3:
                    mostrar(pessoas);
                    break;
                case 4:
                    excluir(scan, pessoas);
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
}