package Interface;

import java.util.Scanner;

public class LojaView {
    private Scanner scanner;

    public LojaView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("\n===== MENU ESTRANHO =====");
        System.out.println("1 - Comprar Super Mario");
        System.out.println("2 - Comprar Zelda");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirSucesso(String jogo, String cliente) {
        System.out.println(jogo + " vendido para " + cliente + " com sucesso!");
    }

    public void exibirErro(String erro) {
        System.out.println("Erro: " + erro);
    }

    public void exibirJogoEsgotado(String nomeJogo) {
        System.out.println("Jogo " + nomeJogo + " esgotado!");
    }

    public void exibirSaida() {
        System.out.println("Saindo do sistema...");
    }

    public void exibirOpcaoInvalida() {
        System.out.println("Opção inválida, tente novamente!");
    }

    public int obterOpcaoUsuario() {
        return scanner.nextInt();
    }

    public void fechar() {
        scanner.close();
    }
}

