package Perfumes;


import Perfumes.controllers.FormulaControle;
import Perfumes.controllers.PerfumeControle;
import Perfumes.models.Formula;
import Perfumes.models.Perfume;
import exemplo01.Controllers.CategoriaController;
import exemplo01.Controllers.ProdutoController;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Perfume> perfume = new ArrayList<>();
    static ArrayList<Formula> formula = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        menu(scan);

    }

    public static void menu(Scanner scan) {
        while (true) {
            System.out.println("(1) - Cadastro de Perfume");
            System.out.println("(2) - Cadastro de Formula");
            System.out.println("(0) - Sair");
            int op = scan.nextInt();
            if (op == 0) break;

            switch (op) {
                case 1:
                    menuPerfume(scan);
                    break;
                case 2:
                    menuFormula(scan);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Entrada inválida");
            }
        }
    }

    public static void menuPerfume(Scanner scan) {

        PerfumeControle perfumeControle = new PerfumeControle();

        while (true) {
            System.out.println("**** Perfume ****\n");
            System.out.println("(1) - Novo Perfume");
            System.out.println("(2) - Ver Perfumes");
            System.out.println("(3) - Ver Remover");
            System.out.println("(4) - Buscar Perfume pelo id");
            System.out.println("(5) - Buscar Perfume pelo nome da formula");
            System.out.println("(0) - Sair");
            int op = scan.nextInt();
            if (op == 0) break;

            switch (op) {
                case 1:
                    if (formula.isEmpty()) {
                        System.out.println("Cadastre uma Formula antes");
                    } else {
                        System.out.println("**** NOVO PRODUTO ****\n");
                        perfumeControle.cadastrarPerfume(perfume, formula);
                    }
                    break;
                case 2:
                    System.out.println("**** PRODUTOS ****\n");
                    perfumeControle.mostrarPerfumes(perfume);
                    break;
                case 3:
                    perfumeControle.removerPerfume(perfume);
                    break;
                case 4:
                    perfumeControle.mostrarPerfumes(perfumeControle.escolherPerfumePorFormula(perfume, formula));
                    break;
                case 5:
                    perfumeControle.mostrarPerfumes(perfumeControle.buscarPerfumesPorNomeDaFormula(perfume));
                    break;
                default:
                    System.out.println("Entrada inválida");
            }
        }
        scan.next();
    }

    public static void menuFormula(Scanner scan) {

        FormulaControle FormulaControle = new FormulaControle();

        while (true) {
            System.out.println("**** Formula ****\n");
            System.out.println("(1) - Nova Formula");
            System.out.println("(2) - Ver Formulas");
            System.out.println("(3) - Ver Remover");
            System.out.println("(0) - Sair");
            int op = scan.nextInt();
            if (op == 0) break;

            switch (op) {
                case 1:
                    FormulaControle.cadastrarFormula(formula);
                    break;
                case 2:
                    System.out.println("**** Formula ****\n");
                    FormulaControle.mostrarFormula(formula);
                    break;
                case 3:
                    FormulaControle.removerFormula(formula);
                    break;
                default:
                    System.out.println("Entrada inválida");
            }
        }
        scan.next();
    }

}