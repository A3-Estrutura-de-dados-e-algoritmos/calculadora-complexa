import java.util.Scanner;

public class operacoesCalculadora{

    public static void adicaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        prompt.imprimir();

        //quantidade de numeros complexos que irá somar
        int quantidadeComplexosSoma, index;

        //pergunta de quantos Zs serão somados
        System.out.println("Quantos Zs você quer somar? ");
        quantidadeComplexosSoma = sc.nextInt();

        //pega a quantidade de index que irão ser somados
        int[] indexSoma = new int[quantidadeComplexosSoma];

        //pega os index dos numeros que serão somados
        System.out.println("Quais Zs você quer somar? ");
        for (int i = 0; i < quantidadeComplexosSoma; i++) {
            index = sc.nextInt();
            indexSoma[i] = index - 1;
        }

        //pega os coeficientes reais dos numeros selecionados
        double[] coeficientesReais = prompt.GetCoeficientesReais(indexSoma);
        //pega os coeficientes imaginários dos coeficientes a serem somados
        double[] coeficientesImaginarios = prompt.GetCoeficientesImaginarios(indexSoma);

        //pega o retorno das operações com soma
        String[] retornoReais = operacoesPrimarias.multiplicar(coeficientesReais);
        String[] retornoImaginarios = operacoesPrimarias.multiplicar(coeficientesImaginarios);

        //atribui o novo número e retorna a nova árvore
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