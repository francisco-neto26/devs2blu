package Perfumes.controllers;
import Perfumes.models.Formula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FormulaControle {

    Scanner scan = new Scanner(System.in);

    public void cadastrarFormula(ArrayList<Formula> Formula) {

        System.out.println("Nome da formula: ");
        String nomeFormula = scan.next();
        System.out.println("Composição Quimica: ");
        String composicaoQuimica = scan.next();
        Map<String, Double> componentes = new HashMap<>();

        System.out.println("Digite a quantidade de componentes da fórmula:");
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o nome do componente #" + (i + 1) + ":");
            String nomeComponente = scan.nextLine();
            System.out.println("Digite a porcentagem do componente (ex: 20.5):");
            String porcentagemStr = scan.nextLine();
            double porcentagem = Double.parseDouble(porcentagemStr.replace(',', '.'));

            componentes.put(nomeComponente, porcentagem);
        }
        System.out.println("Tipo de essencia: ");
        String tipoEssencia = scan.next();

        Formula.add(new Formula(nomeFormula, composicaoQuimica, componentes, tipoEssencia));
    }

    public void mostrarFormula(ArrayList<Formula> Formula) {
        for (var Formulas : Formula) {
            System.out.println(Formulas.getId() + " - " + Formulas.getNomeFormula() +
                    " Composição: " + Formulas.getComposicaoQuimica() +
                    " tipo de essencia: " + Formulas.getTipoEssencia());
            for (Map.Entry<String, Double> entry : Formulas.getComponentes().entrySet()) {
                System.out.printf("%s: %.2f%%\n", entry.getKey(), entry.getValue());
            }
        }
    }

    public void removerFormula(ArrayList<Formula> Formula) {
        System.out.println("*** REMOVER ***");
        mostrarFormula(Formula);
        System.out.print("Id: ");
        int id = scan.nextInt();

        if (Formula.removeIf(Formulas -> Formulas.getId() == id)) {
            System.out.println("Formula excluida com sucesso");
        } else {
            System.out.println("Formula nao encontrada");
        }
    }

    public Formula escolherFormulaPorId(ArrayList<Formula> Formula) {
        System.out.println("Escolha a Formula");
        mostrarFormula(Formula);

        System.out.println("Id: ");
        int idFormula = scan.nextInt();

        for (var Formulass : Formula) {
            if (Formulass.getId() == idFormula) {
                return Formulass;
            }
        }
        return null;
    }
    
}
