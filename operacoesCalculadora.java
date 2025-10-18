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
        String[] retornoReais = operacoesPrimarias.somar(coeficientesReais);
        String[] retornoImaginarios = operacoesPrimarias.somar(coeficientesImaginarios);

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

    public static void subtracaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        prompt.imprimir();

        //quantidade de numeros complexos que irá subtrair
        int quantidadeComplexosSub, index;

        //pergunta de quantos Zs serão subtraídos
        System.out.println("Quantos Zs você quer subtrair? ");
        quantidadeComplexosSub = sc.nextInt();

        //pega a quantidade de index que irão ser subtraídos
        int[] indexSub = new int[quantidadeComplexosSub];

        //pega os index dos numeros que serão subtraídos
        System.out.println("Quais Zs você quer subtrair? ");
        for (int i = 0; i < quantidadeComplexosSub; i++) {
            index = sc.nextInt();
            indexSub[i] = index - 1;
        }

        //pega os coeficientes reais dos numeros selecionados
        double[] coeficientesReais = prompt.GetCoeficientesReais(indexSub);
        //pega os coeficientes imaginários dos coeficientes a serem somados
        double[] coeficientesImaginarios = prompt.GetCoeficientesImaginarios(indexSub);

        //pega o retorno das operações subtraidas
        String[] retornoReais = operacoesPrimarias.subtrair(coeficientesReais);
        String[] retornoImaginarios = operacoesPrimarias.subtrair(coeficientesImaginarios);

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

    public static void multiComplexa(pegarNumeros prompt) {
        
    }
}