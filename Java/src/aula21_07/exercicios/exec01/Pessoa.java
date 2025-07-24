package aula21_07.exercicios.exec01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private double altura;
    private Endereco endereco;
    private ArrayList<Trabalho> trabalho = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, double altura, Endereco endereco) {
        this.id = new Random().nextInt(1000);
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.endereco = endereco;
        this.trabalho = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Trabalho> getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(ArrayList<Trabalho> trabalho) {
        this.trabalho = trabalho;
    }

    public void cadastrar(Scanner scan) {
        System.out.print("Digite o nome da pessoa: ");
        this.nome = scan.nextLine();

        System.out.print("Digite a idade: ");
        this.idade = Integer.parseInt(scan.nextLine());

        System.out.print("Digite a altura (em metros, ex: 1.75): ");
        this.altura = Double.parseDouble(scan.nextLine());

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

        // Criando e atribuindo o endereço
        this.endereco = new Endereco(logradouro, numero, bairro, cep, cidade, estado, pais);
        String resposta = String.valueOf('s');
        while (resposta.equalsIgnoreCase("s")) {
            System.out.print("\nDeseja cadastrar trabalhos para essa pessoa? (s/n): ");
            resposta = String.valueOf(scan.nextLine());
            if(resposta.equalsIgnoreCase("s")){
                cadastrarTrabalhos(scan);
            }
        }

        System.out.println("\nCadastro realizado com sucesso!");
    }

    public void cadastrarTrabalhos(Scanner scan) {

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

        this.trabalho.add(t);
    }

    public void mostrar() {
        System.out.println("\n--- Dados da Pessoa ---");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Altura: " + this.altura + " m");

        if (this.endereco != null) {
            System.out.println("\n--- Endereço ---");
            System.out.println("Logradouro: " + endereco.getLogradouro());
            System.out.println("Número: " + endereco.getNumero());
            System.out.println("Bairro: " + endereco.getBairro());
            System.out.println("CEP: " + endereco.getCep());
            System.out.println("Cidade: " + endereco.getCidade());
            System.out.println("Estado: " + endereco.getEstado());
            System.out.println("País: " + endereco.getPais());
        } else {
            System.out.println("\nEndereço não informado.");
        }

        if (trabalho != null && !trabalho.isEmpty()) {
            System.out.println("\n--- Trabalhos ---");
            for (Trabalho t : trabalho) {
                System.out.println("- " + t.toString());
            }
        } else {
            System.out.println("\nNenhum trabalho cadastrado.");
        }
    }

    public void menu(Scanner scan) {
        Pessoa pessoa = null;
        boolean sair = false;
        while (!sair) {
            System.out.print("Deseja 1 - Cadastrar Pessoa; " +
                    "2 - Cadastrar novo trabalho para pessoa; " +
                    "3 - Mostrar dados;" +
                    "0 - Sair\n");
            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta) {
                case 1:
                    pessoa = new Pessoa();
                    pessoa.cadastrar(scan);
                    break;
                case 2:
                    String resposta2 = String.valueOf('s');
                    while (resposta2.equalsIgnoreCase("s")) {
                        System.out.print("\nDeseja cadastrar trabalhos para essa pessoa? (s/n): ");
                        resposta2 = String.valueOf(scan.nextLine());
                        if(resposta2.equalsIgnoreCase("s")){
                            pessoa.cadastrarTrabalhos(scan);
                        }
                    }
                    break;
                case 3:
                    pessoa.mostrar();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}

