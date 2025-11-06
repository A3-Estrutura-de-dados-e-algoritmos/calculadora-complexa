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
            indexSoma[i] = index;
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
        
    }


    public static void multiplicacaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        prompt.imprimir();

        final int quantidadeComplexosMulti = 2; 
        int index;

        System.out.println("A multiplicação é binária (Z1 * Z2).");
        System.out.println("Quais Zs (Z1 e Z2) você quer multiplicar? ");

        int[] indexMulti = new int[quantidadeComplexosMulti];
        for (int i = 0; i < quantidadeComplexosMulti; i++) {
        index = sc.nextInt();
        indexMulti[i] = index;
        }

        double[] coeficientesReais = prompt.GetCoeficientesReais(indexMulti);
        double[] coeficientesImaginarios = prompt.GetCoeficientesImaginarios(indexMulti);

        double[] numerosParaMultiplicar = {
        coeficientesReais[0], coeficientesReais[1],
        coeficientesImaginarios[0], coeficientesImaginarios[1]
        };

        String[] resultadoMultiplicacao = operacoesPrimarias.multiplicar(numerosParaMultiplicar);

        double[] novoNumero = new double[2];
        novoNumero[0] = Double.parseDouble(resultadoMultiplicacao[0]); 
        novoNumero[1] = Double.parseDouble(resultadoMultiplicacao[1]);
        String arvore = resultadoMultiplicacao[2]; 

        prompt.adicionarNovoNumero(novoNumero);
        System.out.println("arvore: " + arvore);
    }


    public static void divisaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);
        prompt.imprimir();

        final int quantidadeComplexosDiv = 2; 
        int index;

        System.out.println("A divisão é binária (Z1 / Z2).");
        System.out.println("Quais Zs (Z1 e Z2) você quer dividir? ");

        int[] indexDiv = new int[quantidadeComplexosDiv];
        for (int i = 0; i < quantidadeComplexosDiv; i++) {
            index = sc.nextInt();
            indexDiv[i] = index;
        }

        double[] coeficientesReais = prompt.GetCoeficientesReais(indexDiv);
        double[] coeficientesImaginarios = prompt.GetCoeficientesImaginarios(indexDiv);


        double[] numerosParaDividir = {
            coeficientesReais[0], coeficientesReais[1],
            coeficientesImaginarios[0], coeficientesImaginarios[1]
        };

        String [] resultadoDivisao = operacoesPrimarias.dividir(numerosParaDividir);

        if (resultadoDivisao == null) {
            System.out.println("Erro: divisão por zero!");
            return;
        }

        double[] novoNumero = new double[2];
        novoNumero[0] = Double.parseDouble(resultadoDivisao[0]); 
        novoNumero[1] = Double.parseDouble(resultadoDivisao[1]); 
        String arvore = resultadoDivisao[2]; 

        prompt.adicionarNovoNumero(novoNumero);
        System.out.println("arvore: " + arvore); 

    }
    
    public static void conjulgar(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual Z você quer conjulgar?");
        prompt.imprimir();

        int escolha = sc.nextInt();

        if (escolha > prompt.quantidadeNumerosComplexos) {
            System.out.println("Valor inválido");
        } else {
            double coeficienteReal = prompt.getCoeficienteReal(escolha);
            double coeficienteImaginario = prompt.getCoeficienteImaginario(escolha);

            double[] novoNumero = new double[2];
            novoNumero[0] = coeficienteReal;
            novoNumero[1] = coeficienteImaginario * -1;

            prompt.adicionarNovoNumero(novoNumero);
            System.out.println("Numero complexo conjugado adicionado!");
        }


    }
} 
