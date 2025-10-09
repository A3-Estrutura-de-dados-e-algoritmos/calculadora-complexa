import java.util.Scanner;

public class operacoesCalculadora{

    public static void adicaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        prompt.imprimir();

        int quantidadeComplexosSoma, index;

        System.out.println("Quantos Zs você quer somar? ");
        quantidadeComplexosSoma = sc.nextInt();

        int[] indexSoma = new int[quantidadeComplexosSoma];

        System.out.println("Quais Zs você quer somar? ");
        for (int i = 0; i < quantidadeComplexosSoma; i++) {
            index = sc.nextInt();
            indexSoma[i] = index - 1;
        }

        double[] coeficientesReais = prompt.GetCoeficientesReais(indexSoma);
        double[] coeficientesImaginarios = prompt.GetCoeficientesImaginarios(indexSoma);

        String[] retornoReais = operacoesPrimarias.somar(coeficientesReais);
        String[] retornoImaginarios = operacoesPrimarias.somar(coeficientesImaginarios);

        double[] novoNumero = new double[2];
        String arvore = "";
        novoNumero[0] = Double.parseDouble(retornoReais[0]);
        arvore += retornoReais[1];          
        novoNumero[1] = Double.parseDouble(retornoImaginarios[0]);
        arvore += retornoImaginarios[1];

        prompt.adicionarNovoNumero(novoNumero);
        System.out.println(arvore);
        
        
        sc.close();
    }

    public static String subtracaoComplexa(double vR1, double vI1, double vR2, double vI2) {
        double subReal = (vR1 - vR2);
        double subImagi = (vI1 - vI2);
        String resultSub = subReal + " + " + subImagi + "i";
        System.out.println("A soma de " + vR1 + " + " + vI1 + "i " + "com " + vR2 + " + " + vI2 + "i " + "é igual a " + resultSub);
        return resultSub;
    }

    /* public static String multiComplexa(double vR1, double vI1, double vR2, double vI2) {
        double multiReal = (vR1 * vR2) + (vR1 * vI2) + (vI1 * vR2) + (vI1 * vI2);
        double multiImagi = 

        return resultMulti;
    } */
}