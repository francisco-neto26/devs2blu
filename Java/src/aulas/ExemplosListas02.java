package aulas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemplosListas02 {
    public static ArrayList<Double> precos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("-------------------------------------------------------------\n1-Novo preço\n2-Ver preços\n3-Remover Preco\n4-Atualizar Preço\n0-Sair\nOpção: \n-------------------------------------------------------------");
            String menu = scan.next();
            if (menu.equals("0")) break;

            switch(menu) {
                case "1": cadastrarPreco(scan);
                break;
                case "2": mostrarPrecos();
                break;
                case "3": removerPreco(scan);
                break;
                case "4": atualizarPreco(scan);
                break;
                default:
                    System.out.println("Entrada inválida");
                    break;

            }
        }
    }

    public static void cadastrarPreco(Scanner scan){

        try {

            System.out.print("Digite novo preço: R$");
            double preco = scan.nextDouble();

            if (preco < 0) System.out.println("O preço não pode ser negativo");
            else precos.add(preco);

        } catch (Exception e) {
            System.out.println("Deu BO");
        }
    }

    public static void mostrarPrecos(){
        System.out.println("PREÇOS:");
        for (Double preco : precos) {
            System.out.println(precos.indexOf(preco)+" - R$"+preco);
        }
    }

    public static void removerPreco(Scanner scan){
        try {

            mostrarPrecos();
            System.out.println("Digite o indice");
            int i = scan.nextInt();

            System.out.println("Certeza que gostaria de remover: "+precos.get(i)+"\n1-Sim\n2-Não");
            if (scan.nextInt() == 1) {
                System.out.println("Removido com sucesso");
                precos.remove(i);
            } else {
                System.out.println("Voltando para o menu");
                throw new InputMismatchException();
            }


            System.out.println("Removido com sucesso");

        } catch (InputMismatchException e){

            System.out.println("Valor inválido");

        } catch (IndexOutOfBoundsException e){

            System.out.println("Indice inexistente");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void atualizarPreco(Scanner scan){
        try {

            mostrarPrecos();
            System.out.println("Digite o indice");
            int i = scan.nextInt();

            System.out.println("Certeza que gostaria de atualizar: "+precos.get(i)+"\n1-Sim\n2-Não");
            if (scan.nextInt() == 1) {
                System.out.println("Digite o valor do novo preço");
                System.out.println("R$: ");
                double preco = scan.nextInt();
                precos.set(i, preco);
                System.out.println("Atualizado com sucesso");
            } else {
                System.out.println("Voltando para o menu");
                throw new InputMismatchException();
            }


            System.out.println("Removido com sucesso");

        } catch (InputMismatchException e){

            System.out.println("Valor inválido");

        } catch (IndexOutOfBoundsException e){

            System.out.println("Indice inexistente");
        }
    }
}
