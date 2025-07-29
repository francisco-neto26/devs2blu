package exemplo01.Controllers;

import exemplo01.Models.Categoria;
import exemplo01.Models.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoriaController {
    Scanner scan = new Scanner(System.in);

    public void cadastrarCategoria(ArrayList<Categoria> categoria) {

        System.out.println("Nome: ");
        String nome = scan.next();
        categoria.add(new Categoria(nome));
    }

    public void mostrarCategoria(ArrayList<Categoria> categoria) {
        for (var categorias : categoria) {
            System.out.println(categorias.getId() + " - " + categorias.getNome());
        }
    }

    public void removarCategoria(ArrayList<Categoria> categoria) {
        System.out.println("*** REMOVER ***");
        mostrarCategoria(categoria);
        System.out.print("Id: ");
        int id = scan.nextInt();

        if (categoria.removeIf(categorias -> categorias.getId() == id)) {
            System.out.println("Categoria excluida com sucesso");
        } else {
            System.out.println("Categoria nao encontrada");
        }
    }

    public Categoria escolherCategoriaPorId(ArrayList<Categoria> categoria) {
        System.out.println("Escolha a Categoria");
        mostrarCategoria(categoria);

        System.out.println("Id: ");
        int idCategoria = scan.nextInt();

        for (var categoriass : categoria) {
            if (categoriass.getId() == idCategoria) {
                return categoriass;
            }
        }
        return null;
    }
}
