package aula21_07.exercicios.exec02.controllers;

import aula21_07.exercicios.exec02.models.Carro;
import aula21_07.exercicios.exec02.models.Motor;
import aula21_07.exercicios.exec02.models.Pneus;

import java.util.ArrayList;
import java.util.Scanner;

public class CarroController {

    public void cadastrar(Scanner scan, ArrayList<Carro> carros) {
        Carro novoCarro = new Carro();

        System.out.print("Digite o modelo do carro: ");
        novoCarro.setModelo(scan.nextLine());

        System.out.print("Digite a marca do carro: ");
        novoCarro.setMarca(scan.nextLine());

        System.out.print("Digite a cor do carro: ");
        novoCarro.setCor(scan.nextLine());

        // Cadastrar Motor
        System.out.println("\n----- Cadastro de Motor -----");
        System.out.print("Potência do motor (CV): ");
        int potencia = Integer.parseInt(scan.nextLine());

        System.out.print("Tipo de combustível (ex: Gasolina, Etanol, Flex): ");
        String tipoCombustivel = scan.nextLine();

        Motor motor = new Motor(potencia, tipoCombustivel);
        novoCarro.setMotor(motor);

        // Cadastrar Pneus
        String resposta = "s";
        while (resposta.equalsIgnoreCase("s")) {
            System.out.print("\nDeseja cadastrar pneus para este carro? (s/n): ");
            resposta = scan.nextLine();
            if(resposta.equalsIgnoreCase("s")){
                cadastrarPneus(scan, novoCarro);
            }
        }

        carros.add(novoCarro);
        System.out.println("\nCarro cadastrado com sucesso!");
    }

    public void cadastrarPneus(Scanner scan, Carro carro) {
        System.out.println("\n--- Cadastro de Pneus ---");

        System.out.print("Marca do pneu: ");
        String marca = scan.nextLine();

        System.out.print("Aro do pneu (ex: 15, 16, 17): ");
        int aro = Integer.parseInt(scan.nextLine());

        Pneus pneu = new Pneus(marca, aro);

        if (carro.getPneus() == null) {
            carro.setPneus(new ArrayList<>());
        }
        carro.getPneus().add(pneu);
    }

    public void mostrar(ArrayList<Carro> carros) {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
            return;
        }

        for (int i = 0; i < carros.size(); i++) {
            Carro carro = carros.get(i);
            System.out.println("\n=== CARRO " + (i + 1) + " ===");
            mostrarCarro(carro);
        }
    }

    private void mostrarCarro(Carro carro) {
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Marca: " + carro.getMarca());
        System.out.println("Cor: " + carro.getCor());

        if (carro.getMotor() != null) {
            System.out.println("\n--- Motor ---");
            System.out.println("Potência: " + carro.getMotor().getPotencia() + " CV");
            System.out.println("Tipo de Combustível: " + carro.getMotor().getTipoCombustivel());
        } else {
            System.out.println("\nMotor não informado.");
        }

        if (carro.getPneus() != null && !carro.getPneus().isEmpty()) {
            System.out.println("\n--- Pneus ---");
            for (int i = 0; i < carro.getPneus().size(); i++) {
                Pneus p = carro.getPneus().get(i);
                System.out.println("Pneu " + (i + 1) + ": " + p.getMarca() + " - Aro " + p.getAro());
            }
        } else {
            System.out.println("\nNenhum pneu cadastrado.");
        }
    }

    private Carro selecionarCarro(Scanner scan, ArrayList<Carro> carros) {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
            return null;
        }

        System.out.println("\n--- Selecione um carro ---");
        for (int i = 0; i < carros.size(); i++) {
            System.out.println((i + 1) + " - " + carros.get(i).getMarca() + " " + carros.get(i).getModelo());
        }

        System.out.print("Digite o número do carro: ");
        int indice = Integer.parseInt(scan.nextLine()) - 1;

        if (indice >= 0 && indice < carros.size()) {
            return carros.get(indice);
        } else {
            System.out.println("Carro não encontrado.");
            return null;
        }
    }

    public void editarMotor(Scanner scan, ArrayList<Carro> carros) {
        System.out.println("\n--- Editar Motor ---");
        Carro carroEscolhido = selecionarCarro(scan, carros);

        if (carroEscolhido != null) {
            if (carroEscolhido.getMotor() != null) {
                System.out.println("\nMotor atual:");
                System.out.println("Potência: " + carroEscolhido.getMotor().getPotencia() + " CV");
                System.out.println("Combustível: " + carroEscolhido.getMotor().getTipoCombustivel());
            }

            System.out.println("\n--- Novo Motor ---");
            System.out.print("Nova potência do motor (CV): ");
            int novaPotencia = Integer.parseInt(scan.nextLine());

            System.out.print("Novo tipo de combustível: ");
            String novoCombustivel = scan.nextLine();

            Motor novoMotor = new Motor(novaPotencia, novoCombustivel);
            carroEscolhido.setMotor(novoMotor);

            System.out.println("Motor atualizado com sucesso!");
        }
    }

    public void excluir(Scanner scan, ArrayList<Carro> carros) {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado para excluir.");
            return;
        }

        System.out.println("\n=== EXCLUIR ===");
        System.out.println("1 - Excluir carro completo");
        System.out.println("2 - Excluir pneu de um carro");
        System.out.println("3 - Remover motor de um carro");
        System.out.print("Escolha uma opção: ");

        int opcao = Integer.parseInt(scan.nextLine());

        switch (opcao) {
            case 1:
                excluirCarro(scan, carros);
                break;
            case 2:
                excluirPneu(scan, carros);
                break;
            case 3:
                removerMotor(scan, carros);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private void removerMotor(Scanner scan, ArrayList<Carro> carros) {
        System.out.println("\n--- Remover Motor ---");
        Carro carroEscolhido = selecionarCarro(scan, carros);

        if (carroEscolhido != null) {
            if (carroEscolhido.getMotor() == null) {
                System.out.println("Este carro não possui motor cadastrado.");
                return;
            }

            System.out.println("\nMotor que será removido:");
            System.out.println("Potência: " + carroEscolhido.getMotor().getPotencia() + " CV");
            System.out.println("Combustível: " + carroEscolhido.getMotor().getTipoCombustivel());

            System.out.print("\nTem certeza que deseja remover este motor? (s/n): ");
            String confirmacao = scan.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                carroEscolhido.setMotor(null);
                System.out.println("Motor removido com sucesso!");
            } else {
                System.out.println("Remoção cancelada.");
            }
        }
    }

    private void excluirCarro(Scanner scan, ArrayList<Carro> carros) {
        System.out.println("\n--- Excluir Carro ---");
        Carro carroEscolhido = selecionarCarro(scan, carros);

        if (carroEscolhido != null) {
            System.out.println("\nDados do carro que será excluído:");
            mostrarCarro(carroEscolhido);

            System.out.print("\nTem certeza que deseja excluir este carro? (s/n): ");
            String confirmacao = scan.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                carros.remove(carroEscolhido);
                System.out.println("Carro excluído com sucesso!");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        }
    }

    private void excluirPneu(Scanner scan, ArrayList<Carro> carros) {
        System.out.println("\n--- Excluir Pneu ---");
        Carro carroEscolhido = selecionarCarro(scan, carros);

        if (carroEscolhido != null) {
            if (carroEscolhido.getPneus() == null || carroEscolhido.getPneus().isEmpty()) {
                System.out.println("Este carro não possui pneus cadastrados.");
                return;
            }

            System.out.println("\n--- Pneus do " + carroEscolhido.getMarca() + " " + carroEscolhido.getModelo() + " ---");
            ArrayList<Pneus> pneus = carroEscolhido.getPneus();

            for (int i = 0; i < pneus.size(); i++) {
                System.out.println((i + 1) + " - " + pneus.get(i).getMarca() + " - Aro " + pneus.get(i).getAro());
            }

            System.out.print("Digite o número do pneu a ser excluído: ");
            int indicePneu = Integer.parseInt(scan.nextLine()) - 1;

            if (indicePneu >= 0 && indicePneu < pneus.size()) {
                Pneus pneuExcluido = pneus.get(indicePneu);
                System.out.println("\nPneu que será excluído: " + pneuExcluido.getMarca() + " - Aro " + pneuExcluido.getAro());

                System.out.print("Tem certeza que deseja excluir este pneu? (s/n): ");
                String confirmacao = scan.nextLine();

                if (confirmacao.equalsIgnoreCase("s")) {
                    pneus.remove(indicePneu);
                    System.out.println("Pneu excluído com sucesso!");
                } else {
                    System.out.println("Exclusão cancelada.");
                }
            } else {
                System.out.println("Pneu não encontrado.");
            }
        }
    }

    public void menu(Scanner scan, ArrayList<Carro> carros) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU CARROS ===");
            System.out.println("1 - Cadastrar Carro");
            System.out.println("2 - Cadastrar novo pneu para carro");
            System.out.println("3 - Editar motor do carro");
            System.out.println("4 - Mostrar dados");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta) {
                case 1:
                    cadastrar(scan, carros);
                    break;
                case 2:
                    Carro carroEscolhido = selecionarCarro(scan, carros);
                    if (carroEscolhido != null) {
                        String resposta2 = "s";
                        while (resposta2.equalsIgnoreCase("s")) {
                            cadastrarPneus(scan, carroEscolhido);
                            System.out.print("\nDeseja cadastrar outro pneu para este carro? (s/n): ");
                            resposta2 = scan.nextLine();
                        }
                    }
                    break;
                case 3:
                    editarMotor(scan, carros);
                    break;
                case 4:
                    mostrar(carros);
                    break;
                case 5:
                    excluir(scan, carros);
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