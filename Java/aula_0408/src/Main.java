import exercicios.exer02.ContaCorrente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    /*
        Aviao aviao = new Aviao(2025, "AirBus", "Latam");

        System.out.println(aviao.toString());*/
        ContaCorrente conta = new ContaCorrente("neto", 100.0);
        conta.depositar(100.0);
        conta.sacar(200.0);
        conta.depositar(300);
        System.out.println(conta.toString());

    }
}