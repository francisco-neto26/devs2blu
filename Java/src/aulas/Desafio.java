package aulas;

import java.util.ArrayList;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            System.out.println("Escreva um nome");
            nomes.add(scan.next());
        }

        System.out.println("Qual nome você deseja encontrar? ");
        String nome = scan.next();

        for (String s : nomes) {
            if (s.equals(nome)) {
                int nomeVezes = 0;
                for (String string : nomes) {
                    if (string.equals(nome)){
                        nomeVezes++;
                    }
                }
                System.out.println("ACHEI");
                System.out.println("O nome apareceu "+nomeVezes+" vezes");
                System.exit(0);
            }
        }
        System.out.println("NÃO ACHEI");
    }
}
