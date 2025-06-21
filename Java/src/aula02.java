import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class aula02 {
    static ArrayList<Double> precos = new ArrayList<>();
    public static void precos(Scanner scan){
        while (true){
            System.out.println("N-novo preço\nV-ver preços\nR-remover\nU-Atualizar\n0-Sair\nOpção: ");
            String menu = scan.next().toLowerCase();
            if(menu.equals("0")){
                break;
            }
            switch (menu){
                case "n": cadastrarPreco(scan);
                    break;
                case "v": mostrarPreco();
                    break;
                case "r": removerPreco(scan);
                    break;
                case "u": alterarPreco(scan);
                    break;
                default:
                    System.out.println("Entrada inválida");
                    break;
            }
            System.out.println();
        }
    }
    public static void cadastrarPreco(Scanner scan){
        try {
            System.out.println("Novo preço: R$");
            double preco = scan.nextDouble();
            if(preco < 0){
                System.out.println("Preço não pode ser menor que zero");
            }else{
                precos.add(preco);
            }
        } catch (Exception e) {
            System.out.println("Entrada Invalida");
        }
    }

    public static void mostrarPreco(){
        System.out.println("\n*******Preços*******\n");
        for (Double preco : precos) {
            System.out.println(precos.indexOf(preco) + " - R$ " + preco);
        }
    }
    public static void removerPreco(Scanner scan){
        try {
            mostrarPreco();
            System.out.println("Digite o indice do preço");
            int i = scan.nextInt();

            System.out.println("Deseja remover o preço R$ " + precos.get(i)+ " ?");
            System.out.println("1-Sim 2-Não");
            int menu = scan.nextInt();
            if (menu == 1){
                System.out.println("Removido!");
                precos.remove(i);
            }else if(menu == 2){
                System.out.println("Voltando para o menu");
            }else {
                throw new InputMismatchException();
            }

        } catch (InputMismatchException e) {
            System.out.println("Valor invalido");
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Indice incorreto");
        }
    }

    public static void alterarPreco(Scanner scan){
        try {
            mostrarPreco();
            System.out.println("Digite o indice do preço para alterar");
            int i = scan.nextInt();

            System.out.println("Deseja alterar o preço R$ " + precos.get(i)+ " ?");
            System.out.println("1-Sim 2-Não");
            int menu = scan.nextInt();
            if (menu == 1){
                System.out.println("Digite o novo preço");
                precos.set(i, scan.nextDouble());
                System.out.println("Alterado!");
            }else if(menu == 2){
                System.out.println("Voltando para o menu");
            }else {
                throw new InputMismatchException();
            }

        } catch (InputMismatchException e) {
            System.out.println("Valor invalido");
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Indice incorreto");
        }
    }


}