package Perfumes.controllers;
import Perfumes.models.Formula;
import Perfumes.models.Perfume;
import exemplo01.Controllers.CategoriaController;
import exemplo01.Models.Categoria;


import java.util.ArrayList;
import java.util.Scanner;

public class PerfumeControle {
    Scanner scan = new Scanner(System.in);
    FormulaControle formulaControle = new FormulaControle();
    public void cadastrarPerfume(ArrayList<Perfume> Perfumes, ArrayList<Formula> formula) {

        System.out.println("Nome: ");
        String nome = scan.next();

        System.out.println("Preço: ");
        double preco = scan.nextDouble();

        System.out.println("Marca: ");
        String marca = scan.next();

        System.out.println("Volume: ");
        double volume = scan.nextDouble();

        Formula FormulaEscolhida = formulaControle.escolherFormulaPorId(formula);
        if(FormulaEscolhida == null){
            System.out.println("Formula invalida, cadastre novamente");
        }else{
            Perfumes.add(new Perfume(nome, preco,marca, volume, FormulaEscolhida));
            System.out.println("Perfume Cadastrado com sucesso");
        }
    }

    public void mostrarPerfumes(ArrayList<Perfume> Perfumes) {
        for (var Perfume : Perfumes) {
            System.out.println(Perfume.getId() +
                    " - " + Perfume.getNome() +
                    " R$" + Perfume.getPreco() +
                    " Marca: " + Perfume.getMarca() +
                    " Volume: " + Perfume.getVolume() +
                    " Formula: " + Perfume.getFormula());
        }
    }
    public void removerPerfume(ArrayList<Perfume> Perfumes) {
        System.out.println("*** REMOVER ***");
        mostrarPerfumes(Perfumes);
        System.out.print("Id: ");
        int id = scan.nextInt();

        if (Perfumes.removeIf(Perfume -> Perfume.getId() == id)) {
            System.out.println("Perfume excluido com sucesso");
        } else {
            System.out.println("Perfume nao encontrado");
        }
    }
    public ArrayList<Perfume> escolherPerfumePorFormula(ArrayList<Perfume> Perfumes, ArrayList<Formula> formula) {
        System.out.println("Escolha a Formula");
        formulaControle.mostrarFormula(formula);
        System.out.println("ID da Formula: ");
        int idFormula = scan.nextInt();
        for (var perfume : Perfumes) {
            if (perfume.getFormula().getId() == idFormula) {
                ArrayList<Perfume> perfumeRet = new ArrayList<>();
                perfumeRet.add(perfume);
                return perfumeRet;
            }
        }
        return null;
    }

    public ArrayList<Perfume> buscarPerfumesPorNomeDaFormula(ArrayList<Perfume> perfumes) {
        ArrayList<Perfume> encontrados = new ArrayList<>();
        System.out.println("Digite o nome da fórmula:");
        scan.nextLine();
        String nomeBuscado = scan.nextLine().trim();
        for (Perfume p : perfumes) {
            if (p.getFormula().getNomeFormula().equalsIgnoreCase(nomeBuscado)) {
                encontrados.add(p);
            }
        }
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum perfume encontrado com a fórmula: " + nomeBuscado);
        }
        return encontrados;
    }

}
