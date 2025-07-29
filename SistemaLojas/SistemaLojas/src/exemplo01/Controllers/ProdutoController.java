package exemplo01.Controllers;

import exemplo01.Models.Categoria;
import exemplo01.Models.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoController {
    Scanner scan = new Scanner(System.in);
    CategoriaController categoriaController = new CategoriaController();
    public void cadastrarProduto(ArrayList<Produto> produtos, ArrayList<Categoria> categorias) {

        System.out.println("Nome: ");
        String nome = scan.next();

        System.out.println("Preço: ");
        double preco = scan.nextDouble();

        Categoria categoriaEscolhida = categoriaController.escolherCategoriaPorId(categorias);
        if(categoriaEscolhida == null){
            System.out.println("Categoria invalida, cadastre novamente");
        }else{
            produtos.add(new Produto(nome, preco, categoriaEscolhida));
            System.out.println("Produto Cadastrado com sucesso");
        }
    }

    public void mostrarProdutos(ArrayList<Produto> produtos) {
        for (var produto : produtos) {
            System.out.println(produto.getId() + " - " + produto.getNome() + " R$" + produto.getPreco());
        }
    }

    public void removarProduto(ArrayList<Produto> produtos) {
        System.out.println("*** REMOVER ***");
        mostrarProdutos(produtos);
        System.out.print("Id: ");
        int id = scan.nextInt();

        if (produtos.removeIf(produto -> produto.getId() == id)) {
            System.out.println("Produto excluido com sucesso");
        } else {
            System.out.println("Produto nao encontrado");
        }
    }
}

