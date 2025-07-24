package aula23_07;

import aula23_07.controllers.ProdutoController;
import aula23_07.models.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Produto> produtos =  new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        menuProduto(scan);


    }
    public static void menuProduto(Scanner scan){

        ProdutoController produtoController = new ProdutoController();

        while(true){
            System.out.println("(1) - Novo Produto");
            System.out.println("(2) - Ver Produtos");
            System.out.println("(0) - Sair");
            int op =  scan.nextInt();
            if(op == 0)break;

            switch(op){
                case 1:
                    System.out.println("**** NOVO PRODUTO ****\n");
                    produtoController.cadastrarProduto(produtos);
                    break;
                case 2:
                    System.out.println("**** PRODUTOS ****\n");
                    produtoController.mostrarProdutos(produtos);
                    break;
                default:
                    System.out.println("Entrada inválida");
            }
            scan.next();
        }
    }
}