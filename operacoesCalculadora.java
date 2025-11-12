import java.util.ArrayList;
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
            indexSub[i] = index;
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

    public static void elevar(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);
        prompt.imprimir();

        System.out.println("Qual Z você quer elevar?");
        int escolha = sc.nextInt();

        double coeficienteReal = prompt.getCoeficienteReal(escolha);
        double coeficienteImaginario = prompt.getCoeficienteImaginario(escolha);

        System.out.println("Você quer eleva ele a quanto?");
        int eleva = sc.nextInt();
        int numerador = 1, denominador = 1, kFatorado = 1;
        int k = 0, verificacao = 0, contagemVerdadeiros = 0, contagemFalsos = 0;

        double[] numerosParaMultiplicar = new double[4];
        boolean[] verificaNumeroImaginario = new boolean[eleva + 1];
        double[] expressaoExtendida = new double[eleva + 1];

        ArrayList<Integer> indexSomaImaginarios = new ArrayList<Integer>();
        ArrayList<Integer> indexSomaReais = new ArrayList<Integer>();

        for (int i = 0; i <= eleva; i++) {
            k = i;

            for (int j = 1; j <= eleva; j++) {
                numerador = numerador * j;

                if (j <= k) {
                    kFatorado = kFatorado * j;
                }

                if (eleva - k >= j) {
                    denominador = denominador * j;
                }
            }

            double nEscolheK = numerador / (kFatorado * denominador);
            numerosParaMultiplicar[0] = nEscolheK;

            numerador = 1;
            denominador = 1;
            kFatorado = 1;

            double a = Math.pow(coeficienteReal, eleva - k);
            numerosParaMultiplicar[1] = a;


            double b = Math.pow(coeficienteImaginario, k);
            numerosParaMultiplicar[2] = b;

            if (k == 0) {
                numerosParaMultiplicar[3] = 1;
            }else if (k == 1) {
                verificacao = 1;
            } else if (k == 2) {
                numerosParaMultiplicar[3] = -1;
            } else if (k == 3) {
                verificacao = 1;
                numerosParaMultiplicar[3] = -1;
            }

            if (k % 4 == 0) {
                numerosParaMultiplicar[3] = 1;
            } else if (k % 4 == 1) {
                verificacao = 1;
            } else if (k % 4 == 2) {
                numerosParaMultiplicar[3] = -1;
            } else if (k % 4 == 3) {
                verificacao = 1;
                numerosParaMultiplicar[3] = -1;
            }

            String[] resultado = operacoesPrimarias.multiplicar(numerosParaMultiplicar);

            if (verificacao == 1) {
                verificaNumeroImaginario[i] = true;
            } else {
                verificaNumeroImaginario[i] = false;
            }

            verificacao = 0;

            expressaoExtendida[i] = Double.parseDouble(resultado[0]);
            
            System.out.println(resultado[1]);

        }

        for (int i = 0; i < expressaoExtendida.length; i++) {
            if (verificaNumeroImaginario[i]) {
                indexSomaImaginarios.add(i);
                contagemVerdadeiros ++;
            } else {
                indexSomaReais.add(i);
                contagemFalsos++;
            }
        }

        double[] numerosParaSomarReais = new double[contagemFalsos];
        double[] numerosParaSomarImaginarios = new double[contagemVerdadeiros];
        double[] novoNumeroComplexo = new double[2];

        if (contagemVerdadeiros >= 2) {
            for (int i = 0; i < contagemVerdadeiros; i ++) {
                numerosParaSomarImaginarios[i] = expressaoExtendida[indexSomaImaginarios.get(i)];
            }

            String[] resultado = operacoesPrimarias.somar(numerosParaSomarImaginarios);
            System.out.println(resultado[1]);
            novoNumeroComplexo[1] = Double.parseDouble(resultado[0]);
        }

        if (contagemFalsos >= 2) {
            for (int i = 0; i < contagemFalsos; i++) {
                numerosParaSomarReais[i] = expressaoExtendida[indexSomaReais.get(i)];
            }

            String[] resultado = operacoesPrimarias.somar(numerosParaSomarReais);
            System.out.println(resultado[1]);
            novoNumeroComplexo[0] = Double.parseDouble(resultado[0]);
        }

        if (contagemFalsos == 1) {
            novoNumeroComplexo[0] = expressaoExtendida[indexSomaReais.get(0)];
        }
        if (contagemVerdadeiros == 1) {
            novoNumeroComplexo[1] = expressaoExtendida[indexSomaImaginarios.get(0)];
        }

        prompt.adicionarNovoNumero(novoNumeroComplexo);

    }
} 
