package exercicio.controllers;

import exemplo01.Models.Produto;
import exercicio.models.Castelo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class casteloController {

    public void cadastrarCastelo(ArrayList<Castelo> castelos){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scan.next();

        System.out.println("Localização: ");
        String localizacao = scan.next();
        System.out.println("Numero de torres: ");
        int numeroTorres = scan.nextInt();
        System.out.println("Tem fosso? (true/false): ");
        boolean temFosso = scan.nextBoolean();
        System.out.println("Numero de soldados: ");
        int capacidadeSoldados = scan.nextInt();

        castelos.add(new Castelo(nome, localizacao, numeroTorres, temFosso, capacidadeSoldados));

    }
    public void mostrarCastelos(ArrayList<Castelo> castelos) {
        for (var castelo : castelos) {
            System.out.println("ID: " + castelo.getId() +
                                " Nome: " + castelo.getNome() +
                                " Localização: " + castelo.getLocalizacao() +
                                " Número de Torres: " + castelo.getNumeroTorres() +
                                " Tem Fosso: " + (castelo.getTemFosso() ? "Sim " : "Não ") +
                                " Capacidade de Soldados: " + castelo.getCapacidadeSoldados());
        }
    }
    public void removerCastelos(ArrayList<Castelo> castelos, int id) {
        castelos.removeIf(castelo -> castelo.getId() == id);
    }
}
