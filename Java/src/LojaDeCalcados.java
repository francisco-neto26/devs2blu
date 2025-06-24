import java.util.ArrayList;
import java.util.Scanner;

public class LojaDeCalcados {
    public static ArrayList<String> calcado = new ArrayList<>();
    public static ArrayList<Double> preco = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        calcado.add("Tenis");
        preco.add(25.50);
        calcado.add("Sapato");
        preco.add(35.50);

        while(true) {
            System.out.println("\n1-Cadastrar calçados e preços" +
                    "\n2-Listar calçados cadastrados" +
                    "\n3-Listar calçado mais caro" +
                    "\n4-Calcular Preço medio dos calçados" +
                    "\n5-Listar produtos acima da media" +
                    "\n6-Valor total de todos os produtos" +
                    "\n7-Atualizar/Remover produtos" +
                    "\n0-Sair\nOpção:");
            String menu = scan.next();
            if (menu.equals("0")) {
                break;
            }
            switch (menu) {
                case "1":
                    cadastrarProduto(scan);
                    break;
                case "2":
                    listarProduto("", 2);
                    break;
                case "3":
                    listarProduto("", 3);
                    break;
                case "4":
                    listarProduto(", para calcular o preço medio", 4);
                    break;
                case "5":
                    listarProduto(", para calcular produtos com preço acima da media", 5);
                    break;
                case "6":
                    listarProduto(", para calcular preço total dos produtos", 6);
                    break;
                case "7":
                    atualizarRemoverProduto(scan);
                    break;
                default:
                    System.out.println("Entrada inválida");
                    break;

            }
        }
    }

    public static void cadastrarProduto(Scanner scan) {
        while (true) {
            System.out.println("Digite o calçado para cadastrar");
            String prodAdicionar = scan.next();
            if (!calcado.contains(prodAdicionar)) {
                calcado.add(prodAdicionar);
                System.out.println("Digite o Preço para o produto");
                preco.add(scan.nextDouble());
                System.out.println("Produto cadastrado com sucesso, deseja cadastrar outro produto?" +
                        "\n1-Sim 2-Não");
                if (scan.nextInt() == 2) {
                    break;
                }
            } else {
                System.out.println("Produto já existente deseja cadastrar outro calçado?" +
                        "\n1-Sim 2-Não");
                if (scan.nextInt() == 2) {
                    break;
                }
            }
        }
    }

    public static void listarProduto(String mensagem, int tipo) {

        if (tipo == 2) {
            System.out.println("Lista de calçados e preço" + mensagem);
            for (int i = 0; i < calcado.size(); i++) {
                System.out.println("Item: " + i + " " + calcado.get(i) + " valor: R$ " + preco.get(i));
            }

        } else if (tipo == 3) {
            double maiorPreco = 0;
            int indice = 0;
            for (int i = 0; i < preco.size(); i++) {
                if (maiorPreco < preco.get(i)) {
                    maiorPreco = preco.get(i);
                    indice = i;
                }
            }
            System.out.println("O calçados de maior valor é:\nItem: " + indice + " - " + calcado.get(indice) + " com valor de R$ " + preco.get(indice));

        } else if (tipo == 4) {
            listarProduto(mensagem, 2);
            double media = 0;
            for (Double v : preco) {
                media = media + v;
            }
            media = media / preco.size();
            System.out.println("O valor do preço medio dos produtos é: R$ " + media);
        } else if (tipo == 5) {
            listarProduto(mensagem, 2);
            double media = 0;
            for (Double v : preco) {
                media = media + v;
            }
            media = media / preco.size();
            System.out.println("O valor do preço medio dos produtos é: R$ " + media);
            for (int i = 0; i < preco.size(); i++) {
                if (preco.get(i) > media) {
                    System.out.println("O calçados com valor acima do valor medio:\nItem: " + i + " - " + calcado.get(i) + " com valor de R$ " + preco.get(i));
                }
            }

        } else if (tipo == 6) {
            listarProduto(mensagem, 2);
            double soma = 0;
            for (Double v : preco) {
                soma = soma + v;
            }
            System.out.println("O valor total dos produtos é: R$ " + soma);
        }
    }

    public static void atualizarRemoverProduto(Scanner scan) {
        System.out.println("Selecione o opção deseja: 1-Atualizar produto 2-Remover produtos\n");
        int opcao = scan.nextInt();
        if (opcao == 1) {
            System.out.println("Deseja atualizar? 1-Atualizar nome de produto 2-Atualizar preço de produto\n");
            int opcao2 = scan.nextInt();
            listarProduto(", para alteração", 2);
            if (opcao2 == 1) {
                System.out.println("Informe o codigo do produto que deseja alterar o nome:");
                int prodAlterar = scan.nextInt();
                System.out.println("Deseja alterar o nome do produto " + calcado.get(prodAlterar) + " com preço R$ " + preco.get(prodAlterar) + " ?");
                System.out.println("1-Sim 2-Não");
                int opcao3 = scan.nextInt();
                if (opcao3 == 1) {
                    System.out.println("Digite o novo nome do produto");
                    calcado.set(prodAlterar, scan.next());
                    System.out.println("Alterado com sucesso!");
                } else if (opcao3 == 2) {
                    System.out.println("Voltando para o menu");
                }
            } else {
                System.out.println("Informe o codigo do produto que deseja alterar o preço:");
                int prodAlterar = scan.nextInt();
                System.out.println("Deseja alterar o preço do produto " + calcado.get(prodAlterar) + " com preço R$ " + preco.get(prodAlterar) + " ?");
                System.out.println("1-Sim 2-Não");
                int opcao3 = scan.nextInt();
                if (opcao3 == 1) {
                    System.out.println("Digite o novo preço do produto");
                    preco.set(prodAlterar, scan.nextDouble());
                    System.out.println("Alterado com sucesso!");
                } else if (opcao3 == 2) {
                    System.out.println("Voltando para o menu");
                }
            }
        } else {
            listarProduto(", para remover", 2);
            System.out.println("Deseja Remover por? 1-Nome de produto 2-Codigo de produto\n");
            int opcao2 = scan.nextInt();
            if (opcao2 == 1) {
                System.out.println("Informe o nome do produto que deseja remover:");
                String prodRemover = scan.next();
                System.out.println("Deseja remover o produto: " + calcado.get(calcado.indexOf(prodRemover)) + " com preço R$ " + preco.get(calcado.indexOf(prodRemover)) + " ?");
                System.out.println("1-Sim 2-Não");
                if (scan.nextInt() == 1) {
                    preco.remove(calcado.indexOf(prodRemover));
                    calcado.removeIf(produto -> produto.equals(prodRemover));
                    System.out.println("Removido com sucesso!");
                } else {
                    System.out.println("Voltando para o menu");
                }
            } else {
                System.out.println("Informe o codigo do produto que deseja remover:");
                int prodRemover = scan.nextInt();
                System.out.println("Deseja remover o produto: " + calcado.get(prodRemover) + " com preço R$ " + preco.get(prodRemover) + " ?");
                System.out.println("1-Sim 2-Não");
                if (scan.nextInt() == 1) {
                    calcado.remove(prodRemover);
                    preco.remove(prodRemover);
                    System.out.println("Removido com sucesso!");
                } else {
                    System.out.println("Voltando para o menu");
                }
            }
        }
    }
}
