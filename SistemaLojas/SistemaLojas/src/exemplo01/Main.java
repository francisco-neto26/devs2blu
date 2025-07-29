package exemplo01;

import exemplo01.Controllers.CategoriaController;
import exemplo01.Controllers.ProdutoController;
import exemplo01.Models.Categoria;
import exemplo01.Models.Produto;
import exercicio.controllers.casteloController;
import exercicio.models.Castelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Produto> produtos =  new ArrayList<>();
    static ArrayList<Categoria> categoria =  new ArrayList<>();
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        menu(scan);

    }
    public static void menu(Scanner scan){

        ProdutoController produtoController = new ProdutoController();
        CategoriaController categoriaController = new CategoriaController();

        while(true){
            System.out.println("(1) - Cadastro de Produto");
            System.out.println("(2) - Cadastro de Categoria");
            System.out.println("(0) - Sair");
            int op =  scan.nextInt();
            if(op == 0)break;

            switch(op){
                case 1:
                    while (true){
                        System.out.println("**** PRODUTOS ****\n");
                        System.out.println("(1) - Novo Produto");
                        System.out.println("(2) - Ver Produtos");
                        System.out.println("(3) - Ver Remover");
                        System.out.println("(0) - Sair");
                        op =  scan.nextInt();
                        if(op == 0)break;

                        switch (op){
                            case 1:
                                if(categoria.isEmpty()){
                                    System.out.println("Cadastre uma categoria antes");
                                }else{
                                    System.out.println("**** NOVO PRODUTO ****\n");
                                    produtoController.cadastrarProduto(produtos, categoria);
                                }
                                break;
                            case 2:
                                System.out.println("**** PRODUTOS ****\n");
                                produtoController.mostrarProdutos(produtos);
                                break;
                            case 3:
                                produtoController.removarProduto(produtos);
                            default:
                                System.out.println("Entrada inválida");
                        }
                    }
                    break;
                case 2:
                    while (true){
                        System.out.println("**** CATEGORIA ****\n");
                        System.out.println("(1) - Novo Categoria");
                        System.out.println("(2) - Ver Categoria");
                        System.out.println("(3) - Remover Cartegoria");
                        System.out.println("(0) - Sair");
                        op =  scan.nextInt();
                        if(op == 0)break;

                        switch (op){
                            case 1:
                                System.out.println("**** NOVA CATEGORIA ****\n");
                                categoriaController.cadastrarCategoria(categoria);
                                break;
                            case 2:
                                System.out.println("**** CATEGORIA ****\n");
                                categoriaController.mostrarCategoria(categoria);
                                break;
                            case 3:
                                categoriaController.removarCategoria(categoria);
                            default:
                                System.out.println("Entrada inválida");
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Entrada inválida");
            }
            scan.next();
        }
    }
}