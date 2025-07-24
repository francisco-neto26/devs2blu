package aula23_07.controllers;

import aula23_07.models.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoController {

    public void cadastrarProduto(ArrayList<Produto> produtos){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = scan.next();

        System.out.println("Preço: ");
        double preco = scan.nextDouble();

        produtos.add(new Produto(nome, preco));
    }

    public void mostrarProdutos(ArrayList<Produto> produtos){
        for (var produto : produtos){
            System.out.println(produto.getId()+" - "+produto.getNome()+" R$"+produto.getPreco());
        }
    }
}