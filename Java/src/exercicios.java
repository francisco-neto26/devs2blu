import java.util.ArrayList;
import java.util.Scanner;

public class exercicios {

    public static void ex01(Scanner scan){

        while(true){
            System.out.println("Informe um numero entre 0 e 10.\n");
            int numeroInformado = scan.nextInt();
            if(numeroInformado > 0 && numeroInformado < 10) {
                break;
            }else{
                System.out.println("Número informado esta fora do intervalo de 0 a 10");
            }
        }
    }

    public static void ex02(Scanner scan){

        while(true){
            System.out.println("Informe seu nome.");
            String nome = scan.next();
            System.out.println("Informe sua senha.");
            String senha = scan.next();
            if(nome.equalsIgnoreCase(senha)) {
                System.out.println("\nA senha não pode ser igual ao nome informado");
            }else{
                System.out.println("\nSenha validada com sucesso");
                break;
            }
        }
    }

    public static void ex03(Scanner scan){
        System.out.println("Informe o nome, deve possuir ao menos 3 caracteres");
        String nome = scan.next();
        System.out.println("Informe a idade, valor de 0 a 150:");
        int idade = scan.nextInt();
        System.out.println("Informe o salário, deve ser maior que zero:");
        double salario = scan.nextDouble();
        System.out.println("Informe o sexo, F ou M:");
        String sexo = scan.next();
        System.out.println("Informe o estado civil, S, C, V ou D:");
        String estadoCivil = scan.next();

        String validacao = "";

        if (nome.length() < 3){
            validacao = "Nome possui menos de 3 caracteres.\n";
        }

        if (idade < 0 || idade > 150){
            validacao = validacao + "Idade fora do intervalo de 0 a 150\n";
        }

        if (salario < 0){
            validacao = validacao + "Salario informado menor que 0\n";
        }

        if (!sexo.equalsIgnoreCase("F") && !sexo.equalsIgnoreCase("M")){
            validacao = validacao + "Não é um sexo valido\n";
        }

        if (!estadoCivil.equalsIgnoreCase("S")
                && !estadoCivil.equalsIgnoreCase("C")
                && !estadoCivil.equalsIgnoreCase("V")
                && !estadoCivil.equalsIgnoreCase("D")){
            validacao = validacao + "Não é um estado civil valido\n";
        }

        if(validacao.isEmpty()){
            System.out.println("Dados validados!");
        }else {
            System.out.println(validacao);
        }
    }

    public static void ex04(Scanner scan){
        int popA = 80000;
        int popB = 200000;
        int anos = 0;
        while (true){
            popA = popA + (int) (popA * (3.0 / 100));
            popB = popB + (int) (popB * (1.5 / 100));
            anos++;
            if(popA >= popB){
                System.out.println("Foram necessarios " + anos + " para que a populção de A se iguala-se a B");
                break;
            }
        }
    }

    public static void ex05(Scanner scan){
        System.out.println("Informe a população do pais A");
        int popA = scan.nextInt();
        System.out.println("Informe a taxa de crescimento do pais A");
        double taxA = scan.nextInt();
        System.out.println("Informe a população do pais B");
        int popB = scan.nextInt();
        System.out.println("Informe a taxa de crescimento do pais B");
        double taxbB = scan.nextInt();
        int anos = 0;
        if (popA > popB && taxA < taxbB || popA < popB && taxA > taxbB) {
            while (true) {
                popA = popA + (int) (popA * (taxA / 100));
                popB = popB + (int) (popB * (taxbB / 100));
                anos++;
                System.out.println("A " + popA + " B " + popB + " ano " + anos);
                if (popA >= popB) {
                    System.out.println("Foram necessarios " + anos + " para que a populção de A se iguala-se a B");
                    break;
                }
            }
        }else{
            System.out.println("Conforme estes dados o crescimento do pais com menor população nunca ira passar o de maior população");
        }
    }

    public static void ex06(Scanner scan){
        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
        }
        for (int i = 1; i <= 20; i++) {
            System.out.print(i + " ");
        }
    }

    public static void ex07_8_9(Scanner scan){
        System.out.println("Informe 5 numeros");
        int[] numeros = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o " + (i + 1) + "° número: ");
            numeros[i] = scan.nextInt();
        }
        int numMaior = 0;
        int numSoma = 0;
        for (int numero : numeros) {
            if (numero > numMaior){
                numMaior = numero;
            }
            numSoma = numSoma + numero;
        }
        System.out.println("O maior numero informado é " + numMaior);
        System.out.println("A soma dos numeros é " + numSoma);
        System.out.println("A media dos numeros é " + numSoma / numeros.length);
    }

    public static void ex10_11(Scanner scan){
        System.out.println("Informe 2 numeros para que seja gerado os numeros entre eles");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int soma = num1;
        if (num2 < num1){
            num1 = num2;
            num2 = soma;
        }
        System.out.println("Inciando contagem em " + num1);
        soma = soma + num2;
        num1 = num1 + 1;
        for (int i = num1; i < num2; i++) {
            System.out.println(i);
            soma = soma + i;
        }
        System.out.println("Terminando a contagem em " + num2);
        System.out.println("A soma dos numeros é " + soma);
    }

    public static void ex12(Scanner scan){
        System.out.println("Informe um numero de 1 a 10 para gerar a tabuada");
        int num = scan.nextInt();
        System.out.println("Tabuada de " + num);
        for (int i = 0; i <= 10; i++) {
            System.out.println(num + " X " + i + " = " + num * i);
        }
    }
    public static void ex13(Scanner scan){
        System.out.println("Informe um numero base");
        int base = scan.nextInt();
        System.out.println("Informe um numero do expoente");
        int expoente = scan.nextInt();
        System.out.println("Calculo pelo POW " + Math.pow(base, expoente));
        for (int i = 1; i < expoente; i++) {
            base = base * base;
        }
        System.out.println("Numero calculado: " + base);

    }
    public static void ex14(Scanner scan){
        System.out.println("Informe 10 numeros inteiros");
        int par = 0;
        int impar = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o " + (i + 1) + "° número: ");
            if (scan.nextInt() % 2 == 0){
                par++;
            }else{
                impar++;
            }
        }
        System.out.println("Total de numeros pares " + par + "\nTotal de numeros impares " + impar);
    }

    public static void ex15(Scanner scan){
        System.out.println("Informe o termo que deseja visualziar da sequencia fibonacci");
        int termo = scan.nextInt();
        int fibAnterior = 0;
        int fibAtual = 1;
        for (int i = 0; i < termo; i++) {

            fibAtual = fibAtual + fibAnterior;
            if (i == 1){
                fibAnterior = 1;
            } else if (i > 2) {
                fibAnterior = fibAtual - fibAnterior;
            }
            System.out.print(fibAtual + ", ");
        }
    }

    public static void fibonacci(Scanner scan){
        System.out.print("Digite quantos termos da série de Fibonacci você deseja ver: ");
        int n = scan.nextInt();

        int primeiro = 1, segundo = 1;

        System.out.print("Série de Fibonacci com " + n + " termos: ");

        for (int i = 1; i <= n; i++) {

            if (i == 1){
                System.out.print(primeiro);
            }else {
                System.out.print(", " + primeiro);
            }
            int proximo = primeiro + segundo;
            primeiro = segundo;
            segundo = proximo;
        }
    }

    public static void ex16(Scanner scan){
        int fibAnterior = 1, fibAtual = 1, contador = 1;

        while (true){
            if (contador == 1){
                System.out.print(fibAtual);
            }else {
                System.out.print(", " + fibAtual);
            }

            if (fibAtual > 500){
                break;
            }

            int proximo = fibAtual + fibAnterior;
            fibAtual = fibAnterior;
            fibAnterior = proximo;

            contador++;

        }

    }

    public static void ex17(Scanner scan){
        System.out.println("Informe o numero para calcular o fatorial");
        long fatorial = scan.nextLong();

        if(fatorial > 0){
            String messagem = fatorial + "!=" + fatorial;
            for (long i = (fatorial - 1); i >= 1; i--) {
                fatorial = fatorial * i;
                System.out.println("273 " + fatorial);
                messagem = messagem + "." + i ;
            }
            System.out.println(messagem + "=" + fatorial);
        } else if (fatorial == 0) {
            System.out.println(fatorial + "!=" + 1);
        } else{
            System.out.println("Numero menor que zero não é possivel calcular o fatorial");
        }
    }

    public static void ex18(Scanner scan){
        ArrayList<Integer> numeros = new ArrayList<>();
        System.out.println("Digite os números (pressione qualquer letra para encerrar):");
        long maior = 0, menor = 0, soma = 0;
        while (scan.hasNextInt()) {
            int numero = scan.nextInt();
            numeros.add(numero);
        }
        for (Integer numero : numeros) {
            if(maior < numero){
                maior = numero;
            }
        }
        menor = maior;
        for (Integer numero : numeros) {
            if (menor > numero){
                menor = numero;
            }
            soma = numero + soma;
        }

        System.out.println("O maior numero informado é " + maior);
        System.out.println("O menor numero informado é " + menor);
        System.out.println("A soma dos numeros é " + soma);
    }
    public static void ex19(Scanner scan){
        ArrayList<Integer> numeros = new ArrayList<>();
        System.out.println("Digite os números entre 0 e 1000 (pressione qualquer letra para encerrar):");
        long maior = 0, menor = 0, soma = 0;

        while (scan.hasNextInt()) {
            int numero = scan.nextInt();
            if (numero >= 0 && numero <= 1000) {
                numeros.add(numero);
            }else {
                System.out.println("Número fora do intervalo de 0 a 1000");
            }
        }
        for (Integer numero : numeros) {
            if(maior < numero){
                maior = numero;
            }
        }
        menor = maior;
        for (Integer numero : numeros) {
            if (menor > numero){
                menor = numero;
            }
            soma = numero + soma;
        }

        System.out.println("O maior numero informado é " + maior);
        System.out.println("O menor numero informado é " + menor);
        System.out.println("A soma dos numeros é " + soma);
    }

    public static void ex20(Scanner scan){

        while (true) {
            System.out.println("Informe o numero para calcular o fatorial (maior que 0 menor que 16)");
            long fatorial = scan.nextLong();
            if (fatorial > 0 && fatorial < 17) {
                String messagem = fatorial + "!=" + fatorial;
                for (long i = (fatorial - 1); i >= 1; i--) {
                    fatorial = fatorial * i;
                    System.out.println("273 " + fatorial);
                    messagem = messagem + "." + i;
                }
                System.out.println(messagem + "=" + fatorial);
            } else if (fatorial == 0 || fatorial > 16) {
                System.out.println("Numero informado é zero ou maior que 16, esta fora das regras definidas");
            } else {
                System.out.println("Numero menor que zero não é possivel calcular o fatorial");
            }
            System.out.println("Deseja calcular um novo fatorial? 1-Sim 2-Não");
            if(scan.nextInt() != 1){
                break;
            }
        }
    }

    public static void ex21(Scanner scan){
        System.out.println("Informe o numero para validar se é primo");
        long primo = scan.nextLong();


    }


}
