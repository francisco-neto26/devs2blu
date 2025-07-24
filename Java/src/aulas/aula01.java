package aulas;

import java.util.ArrayList;
import java.util.Scanner;

public class aula01 {

        public static void exemploLoop(Scanner scan){
            int contador = 0;
            while(true){
                System.out.println("oi");
                contador++;
                if(contador == 10){
                    break;
                }
            }
        }

        public static void exMedia(Scanner scan){

            double[] notas = new double[4];
            System.out.println("Digite as 4 notas: ");

            notas[0] = scan.nextDouble();
            notas[1] = scan.nextDouble();
            notas[2] = scan.nextDouble();
            notas[3] = scan.nextDouble();

            double media = (notas[0] + notas[1] + notas[2] +notas[3]) / 4 ;
            System.out.println("Media final: "+media);

            if(media == 10){
                System.out.println("Aluno passou de ano com êxito");
            }else if(media >=7){
                System.out.println("Aluno passou de ano");
            }else {
                System.out.println("Aluno reprovou");
            }

            System.out.println(media >= 7 ? "Aprovado" : "Reprovado");

        }

        public static void verificarIdade(Scanner scan){
            System.out.println("Digite sua idade: ");
            System.out.println(scan.nextInt() >= 18 ? "Pode" : "Nao pode");
        }


        public static void exemplos(Scanner scan){

            System.out.println("Qual seu nome?");
            String nome = scan.next();
            System.out.println("Bem vindo(a), " + nome);

            System.out.println("Qual sua idade?");
            int idade = scan.nextInt();
            System.out.println("Você têm " + idade+ " anos.");

            System.out.println("Digite um numero: ");
            double num1 = scan.nextDouble();

            System.out.println("Digite outro numero: ");
            double num2 = scan.nextDouble();

            double soma = num1 + num2;
            double sub = num1 - num2;
            double mult = num1 * num2;
            double div = num1 / num2;

            System.out.println("Resultado da soma: "+soma);
            System.out.println("Resultado da subtração: "+sub);
            System.out.println("Resultado da multiplicação: "+mult);
            System.out.println("Resultado da divisão: "+div);

            System.out.println("Qual o raio do circul? ");
            double raio = scan.nextDouble();

            double area = Math.PI * Math.pow(raio,2);

            System.out.println("Area: "+area+"m²");
        }

        public static void ex02(Scanner scan){
            ArrayList<String> nomes = new ArrayList<>();
            nomes.add("Ana");
            nomes.add("Bruno");
            nomes.add("Carla");
            nomes.add("Diego");
            nomes.add("Eduarda");
            nomes.add("Felipe");
            nomes.add("Gabriela");
            nomes.add("Henrique");
            nomes.add("Isabela");
            nomes.add("João");
            nomes.add("Ana");

            System.out.println("Digite o nome para buscar na lista de nomes:");
            String nomeBuscar = scan.next();
            int contador = 0;
            if(nomes.contains(nomeBuscar)){
                System.out.println("Achei");
                for (String nome : nomes) {
                    if(nome.equals(nomeBuscar)){
                        contador++;
                    }
                }
                System.out.println("O nome Existe " + nomeBuscar + " aparece "+ contador + " vezes na lista.");
            }else{
                System.out.println("Não achei");
            };

            contador = 0;
            for (String nome : nomes) {
                if(nome.equals(nomeBuscar)){
                    contador++;
                }
            }
            if (contador > 0){
                System.out.println("Achei");
                System.out.println("O nome Existe " + nomeBuscar + " aparece "+ contador + " vezes na lista.");
            }else{
                System.out.println("Não achei");
            }

        }

        public static void exemplo04(Scanner scan){
            ArrayList<String> nomes = new ArrayList<>();
            nomes.add("Pedro");
            nomes.add("Maria");
            nomes.add("Dolores");
            nomes.add("Julia");
            nomes.add(1,"neto");

            nomes.isEmpty();
            nomes.size();
            for (int i = 0; i < nomes.size(); i++) {
                System.out.println(nomes.get(i));
            }
            System.out.println("Novo ");
            for (String nome : nomes) {
                System.out.println(nomes.indexOf(nome) + " - " + nome);
            }
        }

        public static void exemplo01(Scanner scan){
            ArrayList<String> nomes = new ArrayList<>();
            nomes.add("Pedro");
            nomes.add("Maria");
            nomes.add("Dolores");
            nomes.add("Julia");
            nomes.add(1,"neto");

            nomes.isEmpty();
            nomes.size();
            for (int i = 0; i < nomes.size(); i++) {
                System.out.println(nomes.get(i));
            }
            System.out.println("Novo ");
            for (String nome : nomes) {
                System.out.println(nomes.indexOf(nome) + " - " + nome);
            }
        }
        public static void exemplo02(Scanner scan){
            ArrayList<String> frutas = new ArrayList<>();
            while(true){
                System.out.println("Digte o nome da fruta. 0-Sair");
                String fruta = scan.next();
                if(fruta.equals("0")) break;
                frutas.add(fruta);
            }
            System.out.println("\nFrutas\n");
            for (String fruta : frutas) {
                System.out.println(fruta);
            }
        }

        public static void exemplo03(Scanner scan){
            System.out.println("Digite: noite, dia, tarde");
            String palavra = scan.next();
            System.out.println(switch (palavra){
                case "dia" -> "bom dia";
                case "noite" -> "boa noite";
                case "tarde" -> "Boa tarde";
                default -> "";
            });

        }

        public static void ex01(Scanner scan){
            ArrayList<Double> notas = new ArrayList<>();
            while(true){
                System.out.println("Inserir uma nova nota? 1-Sim 2-Não");
                int novaNota = scan.nextInt();
                if(novaNota == 2){
                    break;
                }
                System.out.println("Digite a nota, entre 0 e 100");
                double nota = scan.nextDouble();
                if(nota >= 0 && nota <= 100){
                    notas.add(nota);
                }else{
                    System.out.println("Nota invalida!");
                }
            }
            double media = 0.0;
            System.out.println("\nLista de notas inseridas!\n");
            for (Double nota : notas) {
                media = media + nota;
                System.out.println( nota );
            }
            media = media / notas.toArray().length;
            System.out.println("Media calculada: " + media);
        }

}
