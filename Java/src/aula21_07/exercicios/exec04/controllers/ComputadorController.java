package aula21_07.exercicios.exec04.controllers;

import aula21_07.exercicios.exec04.models.Computador;
import aula21_07.exercicios.exec04.models.Processador;
import aula21_07.exercicios.exec04.models.PlacaMae;
import aula21_07.exercicios.exec04.models.PlacaVideo;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputadorController {

    public void cadastrar(Scanner scan, ArrayList<Computador> computadores) {
        Computador novoComputador = new Computador();

        System.out.print("Digite o nome do computador: ");
        novoComputador.setNome(scan.nextLine());

        System.out.print("Digite a marca do computador: ");
        novoComputador.setMarca(scan.nextLine());

        System.out.print("Digite o modelo do gabinete: ");
        novoComputador.setGabinete(scan.nextLine());

        System.out.print("Digite a quantidade de memória RAM (GB): ");
        novoComputador.setMemoriaRAM(Integer.parseInt(scan.nextLine()));

        // Cadastrar componentes opcionais
        String resposta = "s";

        System.out.print("\nDeseja cadastrar o processador? (s/n): ");
        resposta = scan.nextLine();
        if(resposta.equalsIgnoreCase("s")){
            cadastrarProcessador(scan, novoComputador);
        }

        System.out.print("\nDeseja cadastrar a placa mãe? (s/n): ");
        resposta = scan.nextLine();
        if(resposta.equalsIgnoreCase("s")){
            cadastrarPlacaMae(scan, novoComputador);
        }

        System.out.print("\nDeseja cadastrar a placa de vídeo? (s/n): ");
        resposta = scan.nextLine();
        if(resposta.equalsIgnoreCase("s")){
            cadastrarPlacaVideo(scan, novoComputador);
        }

        computadores.add(novoComputador);
        System.out.println("\nComputador cadastrado com sucesso!");
    }

    public void cadastrarProcessador(Scanner scan, Computador computador) {
        System.out.println("\n--- Cadastro de Processador ---");

        System.out.print("Marca do processador (ex: Intel, AMD): ");
        String marca = scan.nextLine();

        System.out.print("Modelo (ex: i7-13700K, Ryzen 7 7700X): ");
        String modelo = scan.nextLine();

        System.out.print("Frequência base (GHz): ");
        double frequencia = Double.parseDouble(scan.nextLine());

        System.out.print("Número de núcleos: ");
        int nucleos = Integer.parseInt(scan.nextLine());

        System.out.print("Arquitetura (ex: x86-64, ARM): ");
        String arquitetura = scan.nextLine();

        Processador processador = new Processador(marca, modelo, frequencia, nucleos, arquitetura);
        computador.setProcessador(processador);
    }

    public void cadastrarPlacaMae(Scanner scan, Computador computador) {
        System.out.println("\n--- Cadastro de Placa Mãe ---");

        System.out.print("Marca da placa mãe (ex: ASUS, MSI, Gigabyte): ");
        String marca = scan.nextLine();

        System.out.print("Modelo: ");
        String modelo = scan.nextLine();

        System.out.print("Socket (ex: LGA1700, AM5): ");
        String socket = scan.nextLine();

        System.out.print("Chipset (ex: Z790, B650): ");
        String chipset = scan.nextLine();

        System.out.print("Número de slots de RAM: ");
        int slotsRAM = Integer.parseInt(scan.nextLine());

        System.out.print("Tipo de RAM suportada (ex: DDR4, DDR5): ");
        String tipoRAM = scan.nextLine();

        PlacaMae placaMae = new PlacaMae(marca, modelo, socket, chipset, slotsRAM, tipoRAM);
        computador.setPlacaMae(placaMae);
    }

    public void cadastrarPlacaVideo(Scanner scan, Computador computador) {
        System.out.println("\n--- Cadastro de Placa de Vídeo ---");

        System.out.print("Marca da placa (ex: NVIDIA, AMD): ");
        String marca = scan.nextLine();

        System.out.print("Modelo (ex: GeForce RTX 4070, Radeon RX 7800 XT): ");
        String modelo = scan.nextLine();

        System.out.print("GPU (ex: RTX 4070, RX 7800 XT): ");
        String gpu = scan.nextLine();

        System.out.print("Memória VRAM (GB): ");
        int memoriaVRAM = Integer.parseInt(scan.nextLine());

        System.out.print("Tipo de memória (ex: GDDR6, GDDR6X): ");
        String tipoMemoria = scan.nextLine();

        System.out.print("Consumo de energia (Watts): ");
        int consumo = Integer.parseInt(scan.nextLine());

        PlacaVideo placaVideo = new PlacaVideo(marca, modelo, gpu, memoriaVRAM, tipoMemoria, consumo);
        computador.setPlacaVideo(placaVideo);
    }

    public void mostrar(ArrayList<Computador> computadores) {
        if (computadores.isEmpty()) {
            System.out.println("Nenhum computador cadastrado.");
            return;
        }

        for (int i = 0; i < computadores.size(); i++) {
            Computador computador = computadores.get(i);
            System.out.println("\n=== COMPUTADOR " + (i + 1) + " ===");
            mostrarComputador(computador);
        }
    }

    private void mostrarComputador(Computador computador) {
        System.out.println("Nome: " + computador.getNome());
        System.out.println("Marca: " + computador.getMarca());
        System.out.println("Gabinete: " + computador.getGabinete());
        System.out.println("Memória RAM: " + computador.getMemoriaRAM() + " GB");

        if (computador.getProcessador() != null) {
            System.out.println("\n--- Processador ---");
            System.out.println(computador.getProcessador().toString());
        } else {
            System.out.println("\nProcessador não cadastrado.");
        }

        if (computador.getPlacaMae() != null) {
            System.out.println("\n--- Placa Mãe ---");
            System.out.println(computador.getPlacaMae().toString());
        } else {
            System.out.println("\nPlaca mãe não cadastrada.");
        }

        if (computador.getPlacaVideo() != null) {
            System.out.println("\n--- Placa de Vídeo ---");
            System.out.println(computador.getPlacaVideo().toString());
        } else {
            System.out.println("\nPlaca de vídeo não cadastrada.");
        }
    }

    private Computador selecionarComputador(Scanner scan, ArrayList<Computador> computadores) {
        if (computadores.isEmpty()) {
            System.out.println("Nenhum computador cadastrado.");
            return null;
        }

        System.out.println("\n--- Selecione um computador ---");
        for (int i = 0; i < computadores.size(); i++) {
            System.out.println((i + 1) + " - " + computadores.get(i).getNome() + " (" + computadores.get(i).getMarca() + ")");
        }

        System.out.print("Digite o número do computador: ");
        int indice = Integer.parseInt(scan.nextLine()) - 1;

        if (indice >= 0 && indice < computadores.size()) {
            return computadores.get(indice);
        } else {
            System.out.println("Computador não encontrado.");
            return null;
        }
    }

    public void alterar(Scanner scan, ArrayList<Computador> computadores) {
        if (computadores.isEmpty()) {
            System.out.println("Nenhum computador cadastrado para alterar.");
            return;
        }

        System.out.println("\n=== ALTERAR ===");
        System.out.println("1 - Alterar dados básicos do computador");
        System.out.println("2 - Alterar/Adicionar processador");
        System.out.println("3 - Alterar/Adicionar placa mãe");
        System.out.println("4 - Alterar/Adicionar placa de vídeo");
        System.out.print("Escolha uma opção: ");

        int opcao = Integer.parseInt(scan.nextLine());

        switch (opcao) {
            case 1:
                alterarDadosBasicos(scan, computadores);
                break;
            case 2:
                alterarProcessador(scan, computadores);
                break;
            case 3:
                alterarPlacaMae(scan, computadores);
                break;
            case 4:
                alterarPlacaVideo(scan, computadores);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private void alterarDadosBasicos(Scanner scan, ArrayList<Computador> computadores) {
        System.out.println("\n--- Alterar Dados Básicos ---");
        Computador computadorEscolhido = selecionarComputador(scan, computadores);

        if (computadorEscolhido != null) {
            System.out.println("\nDados atuais:");
            System.out.println("Nome: " + computadorEscolhido.getNome());
            System.out.println("Marca: " + computadorEscolhido.getMarca());
            System.out.println("Gabinete: " + computadorEscolhido.getGabinete());
            System.out.println("RAM: " + computadorEscolhido.getMemoriaRAM() + " GB");

            System.out.print("\nNovo nome: ");
            computadorEscolhido.setNome(scan.nextLine());

            System.out.print("Nova marca: ");
            computadorEscolhido.setMarca(scan.nextLine());

            System.out.print("Novo gabinete: ");
            computadorEscolhido.setGabinete(scan.nextLine());

            System.out.print("Nova quantidade de RAM (GB): ");
            computadorEscolhido.setMemoriaRAM(Integer.parseInt(scan.nextLine()));

            System.out.println("Dados básicos alterados com sucesso!");
        }
    }

    private void alterarProcessador(Scanner scan, ArrayList<Computador> computadores) {
        System.out.println("\n--- Alterar Processador ---");
        Computador computadorEscolhido = selecionarComputador(scan, computadores);

        if (computadorEscolhido != null) {
            if (computadorEscolhido.getProcessador() != null) {
                System.out.println("\nProcessador atual: " + computadorEscolhido.getProcessador().toString());
            }

            cadastrarProcessador(scan, computadorEscolhido);
            System.out.println("Processador alterado com sucesso!");
        }
    }

    private void alterarPlacaMae(Scanner scan, ArrayList<Computador> computadores) {
        System.out.println("\n--- Alterar Placa Mãe ---");
        Computador computadorEscolhido = selecionarComputador(scan, computadores);

        if (computadorEscolhido != null) {
            if (computadorEscolhido.getPlacaMae() != null) {
                System.out.println("\nPlaca mãe atual: " + computadorEscolhido.getPlacaMae().toString());
            }

            cadastrarPlacaMae(scan, computadorEscolhido);
            System.out.println("Placa mãe alterada com sucesso!");
        }
    }

    private void alterarPlacaVideo(Scanner scan, ArrayList<Computador> computadores) {
        System.out.println("\n--- Alterar Placa de Vídeo ---");
        Computador computadorEscolhido = selecionarComputador(scan, computadores);

        if (computadorEscolhido != null) {
            if (computadorEscolhido.getPlacaVideo() != null) {
                System.out.println("\nPlaca de vídeo atual: " + computadorEscolhido.getPlacaVideo().toString());
            }

            cadastrarPlacaVideo(scan, computadorEscolhido);
            System.out.println("Placa de vídeo alterada com sucesso!");
        }
    }

    public void excluir(Scanner scan, ArrayList<Computador> computadores) {
        if (computadores.isEmpty()) {
            System.out.println("Nenhum computador cadastrado para excluir.");
            return;
        }

        System.out.println("\n=== EXCLUIR ===");
        System.out.println("1 - Excluir computador completo");
        System.out.println("2 - Remover processador");
        System.out.println("3 - Remover placa mãe");
        System.out.println("4 - Remover placa de vídeo");
        System.out.print("Escolha uma opção: ");

        int opcao = Integer.parseInt(scan.nextLine());

        switch (opcao) {
            case 1:
                excluirComputador(scan, computadores);
                break;
            case 2:
                removerProcessador(scan, computadores);
                break;
            case 3:
                removerPlacaMae(scan, computadores);
                break;
            case 4:
                removerPlacaVideo(scan, computadores);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private void excluirComputador(Scanner scan, ArrayList<Computador> computadores) {
        System.out.println("\n--- Excluir Computador ---");
        Computador computadorEscolhido = selecionarComputador(scan, computadores);

        if (computadorEscolhido != null) {
            System.out.println("\nDados do computador que será excluído:");
            mostrarComputador(computadorEscolhido);

            System.out.print("\nTem certeza que deseja excluir este computador? (s/n): ");
            String confirmacao = scan.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                computadores.remove(computadorEscolhido);
                System.out.println("Computador excluído com sucesso!");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        }
    }

    private void removerProcessador(Scanner scan, ArrayList<Computador> computadores) {
        System.out.println("\n--- Remover Processador ---");
        Computador computadorEscolhido = selecionarComputador(scan, computadores);

        if (computadorEscolhido != null) {
            if (computadorEscolhido.getProcessador() == null) {
                System.out.println("Este computador não possui processador cadastrado.");
                return;
            }

            System.out.println("\nProcessador que será removido: " + computadorEscolhido.getProcessador().toString());

            System.out.print("\nTem certeza que deseja remover este processador? (s/n): ");
            String confirmacao = scan.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                computadorEscolhido.setProcessador(null);
                System.out.println("Processador removido com sucesso!");
            } else {
                System.out.println("Remoção cancelada.");
            }
        }
    }

    private void removerPlacaMae(Scanner scan, ArrayList<Computador> computadores) {
        System.out.println("\n--- Remover Placa Mãe ---");
        Computador computadorEscolhido = selecionarComputador(scan, computadores);

        if (computadorEscolhido != null) {
            if (computadorEscolhido.getPlacaMae() == null) {
                System.out.println("Este computador não possui placa mãe cadastrada.");
                return;
            }

            System.out.println("\nPlaca mãe que será removida: " + computadorEscolhido.getPlacaMae().toString());

            System.out.print("\nTem certeza que deseja remover esta placa mãe? (s/n): ");
            String confirmacao = scan.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                computadorEscolhido.setPlacaMae(null);
                System.out.println("Placa mãe removida com sucesso!");
            } else {
                System.out.println("Remoção cancelada.");
            }
        }
    }

    private void removerPlacaVideo(Scanner scan, ArrayList<Computador> computadores) {
        System.out.println("\n--- Remover Placa de Vídeo ---");
        Computador computadorEscolhido = selecionarComputador(scan, computadores);

        if (computadorEscolhido != null) {
            if (computadorEscolhido.getPlacaVideo() == null) {
                System.out.println("Este computador não possui placa de vídeo cadastrada.");
                return;
            }

            System.out.println("\nPlaca de vídeo que será removida: " + computadorEscolhido.getPlacaVideo().toString());

            System.out.print("\nTem certeza que deseja remover esta placa de vídeo? (s/n): ");
            String confirmacao = scan.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                computadorEscolhido.setPlacaVideo(null);
                System.out.println("Placa de vídeo removida com sucesso!");
            } else {
                System.out.println("Remoção cancelada.");
            }
        }
    }

    public void menu(Scanner scan, ArrayList<Computador> computadores) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU COMPUTADORES ===");
            System.out.println("1 - Cadastrar Computador");
            System.out.println("2 - Alterar dados");
            System.out.println("3 - Mostrar dados");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta) {
                case 1:
                    cadastrar(scan, computadores);
                    break;
                case 2:
                    alterar(scan, computadores);
                    break;
                case 3:
                    mostrar(computadores);
                    break;
                case 4:
                    excluir(scan, computadores);
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