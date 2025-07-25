package aula21_07.exercicios;

import aula21_07.exercicios.exec01.controllers.PessoaController;
import aula21_07.exercicios.exec01.models.Pessoa;
import aula21_07.exercicios.exec02.controllers.CarroController;
import aula21_07.exercicios.exec02.models.Carro;
import aula21_07.exercicios.exec04.controllers.ComputadorController;
import aula21_07.exercicios.exec04.models.Computador;
import aula21_07.exercicios.exec08.controllers.MenuController;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        PessoaController pessoaController = new PessoaController();

        ArrayList<Carro> carros = new ArrayList<>();
        CarroController carroController = new CarroController();

        ArrayList<Computador> computadores = new ArrayList<>();
        ComputadorController computadorController = new ComputadorController();

        MenuController menuController = new MenuController();

        Scanner scan = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.print("Informe o programa que deseja executar:\n");
            System.out.println(programa.programa());
            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta) {
                case 1:
                    pessoaController.menu(scan, pessoas);
                    break;
                case 2:
                    carroController.menu(scan, carros);
                    break;
                case 3:
                    computadorController.menu(scan, computadores);
                    break;
                case 4:
                    menuController.menu(scan);
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