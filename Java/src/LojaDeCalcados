import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> calcado = new ArrayList<>();
    public static ArrayList<Double> preco = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n1-Cadastrar calçados e preços" +
                    "\n2-Listar calçados cadastrados" +
                    "\n3-Listar calçado mais caro" +
                    "\n4-Preço medio dos calçados"+
                    "\n5-Listar produtos acima da media"+
                    "\n0-Sair\nOpção: \n");
            String menu = scan.next();
            if (menu.equals("0")) {
                break;
            }
            switch (menu) {
                case "1": cadastrarProduto(scan);
                    break;
                case "2": listarProduto();
                    break;
                case "3": listarProdCaro();
                    break;
                case "4": listaNome.listaNomeMenu(scan, lista);
                    break;*/
                default:
                    System.out.println("Entrada inválida");
                    break;

            }
        }
    }

    public static void cadastrarProduto(Scanner scan){
        while (true){
            System.out.println("Digite o calçado para cadastrar");
            String prodAdicionar = scan.next();
            if (!calcado.contains(prodAdicionar)){
                calcado.add(prodAdicionar);
                System.out.println("Digite o Preço para o produto");
                preco.add(scan.nextDouble());
                System.out.println("Produto cadastrado com sucesso, deseja cadastrar outro produto?" +
                        "\n1-Sim 2-Não");
                if(scan.nextInt() == 2){
                    break;
                }
            }else {
                System.out.println("Produto já existente deseja cadastrar outro calçado?" +
                        "\n1-Sim 2-Não");
                if(scan.nextInt() == 2){
                    break;
                }
            }
        }
    }

    public static void listarProduto(){
        System.out.println("Lista de calçados com preço");
        for (int i = 0; i < calcado.size(); i++) {
            System.out.println("Item: " + i + " " + calcado.get(i) + " valor: " + preco.get(i));
        }
    }
    
    public static void listarProdCaro(){
        double maiorPreco = 0;
        int indice = 0;


        for (int i = 0; i < preco.size(); i++) {
            if(maiorPreco > preco.get(i)){
                maiorPreco = preco.get(i);
                indice = i;
            }
        }
        System.out.println("O calçados de maior valor é: " + indice + " - " + calcado.get(indice) + " com valor de " + preco.get(indice));
        
    }
    
}
