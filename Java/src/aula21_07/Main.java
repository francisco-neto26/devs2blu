package aula21_07;
import aula21_07.Exemplo01.Consulta;
import aula21_07.Exemplo01.Medico;
import aula21_07.Exemplo01.Paciente;
import aula21_07.exercicios.exec01.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Paciente p = new Paciente("Jocemar", "1998-02-21");

        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Jocemar2", "1998-02-21"));
        pacientes.add(new Paciente("Jocemar3", "1998-02-21"));
        pacientes.add(new Paciente("Jocemar4", "1998-02-21"));

        Medico m = new Medico("Heinz xucrute", "187", "Cirurgião");
        Consulta c = new Consulta("25-07-2025", "Dores", p, m);

        c.getMedico().getNome();
        c.getPaciente().getNome();*/
        Scanner scan = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.print("Informe o programa que deseja executar:\n");
            System.out.println(programa.programa());
            int resposta = Integer.parseInt(scan.nextLine());
            switch (resposta){
                case 1:
                    Pessoa pessoa = new Pessoa();
                    pessoa.menu(scan);
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