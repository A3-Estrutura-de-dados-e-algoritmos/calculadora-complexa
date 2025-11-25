import java.util.ArrayList;
import java.util.Scanner;

public class operacoesCalculadora{

    //funcao que adiciona
    public static void adicaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        prompt.imprimir();

        //quantidade de numeros complexos que irá somar
        int index;

        //pega a quantidade de index que irão ser somados
        int[] indexSoma = new int[2];

        //pega os index dos numeros que serão somados
        System.out.println("Quais Zs você quer somar? ");
        for (int i = 0; i < 2; i++) {
            System.out.print(i + 1 + "º Z: ");
            index = sc.nextInt();
            if (index > prompt.quantidadeNumerosComplexos) {
                System.out.println("Esse Z não existe! coloque um valor válido!");
                i --;
            } else {
                indexSoma[i] = index;
            }
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
        novoNumero[0] = Double.parseDouble(retornoReais[0]);      
        novoNumero[1] = Double.parseDouble(retornoImaginarios[0]);
    
        prompt.quantidadeNumerosComplexos++;
        prompt.adicionarNovoNumero(novoNumero);
        System.out.println("arvore: ");
        System.out.println("(+");
        System.out.println("    (complex " + coeficientesReais[0] + " " + coeficientesImaginarios[0] +")");
        System.out.println("    (complex " + coeficientesReais[1] + " " + coeficientesImaginarios[1] +")");
        System.out.println(")");
        
        System.out.println("Resultado adicionado aos Zs!");
        
    }

    //funcao que subtrai
    public static void subtracaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        prompt.imprimir();

        //quantidade de numeros complexos que irá subtrair
        int index;

        //pega a quantidade de index que irão ser subtraídos
        int[] indexSub = new int[2];

        //pega os index dos numeros que serão subtraídos
        System.out.println("Quais Zs você quer subtrair? ");
        for (int i = 0; i < 2; i++) {
            System.out.print(i + 1 +"º Z: ");
            index = sc.nextInt();
            if (index > prompt.quantidadeNumerosComplexos) {
                System.out.println("Esse Z não existe! coloque um valor válido!");
                i --;
            } else {
                indexSub[i] = index;
            }
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
        novoNumero[0] = Double.parseDouble(retornoReais[0]);         
        novoNumero[1] = Double.parseDouble(retornoImaginarios[0]);

        //arvore lisp
        System.out.println("arvore: ");
        System.out.println("(-");
        System.out.println("    (complex " + coeficientesReais[0] + " " + coeficientesImaginarios[0] +")");
        System.out.println("    (complex " + coeficientesReais[1] + " " + coeficientesImaginarios[1] +")");
        System.out.println(")");
        System.out.println("Resultado adicionado aos Zs!");

        //adicionando a pool de numeros
        prompt.adicionarNovoNumero(novoNumero);
        prompt.quantidadeNumerosComplexos++;

    }

    //funcao que multiplica
    public static void multiplicacaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        prompt.imprimir();
 
        int index;

        int[] indexMulti = new int[2];
        for (int i = 0; i < 2; i++) {
            System.out.print(i + 1 + "º Z: ");
            index = sc.nextInt();
            if (index > prompt.quantidadeNumerosComplexos) {
                System.out.println("Esse Z não existe! coloque um valor válido!");
                i --;
            } else {
                indexMulti[i] = index;
            }
        }

        //pega os coeficientes
        double[] coeficientesReais = prompt.GetCoeficientesReais(indexMulti);
        double[] coeficientesImaginarios = prompt.GetCoeficientesImaginarios(indexMulti);

        //primeira multiplicacao
        String[] multiplicacaoReal = operacoesPrimarias.multiplicar(coeficientesReais);
        double coeficienteReal1 = Double.parseDouble(multiplicacaoReal[0]);

        double[] numerosParaMultiplicar = new double[2];
        double[] numerosParaSomar = new double[2];

        //segunda multiplicacao
        numerosParaMultiplicar[0] = coeficientesReais[0];
        numerosParaMultiplicar[1] = coeficientesImaginarios[1];
        String[] multiplicacaoImaginaria = operacoesPrimarias.multiplicar(numerosParaMultiplicar);
        double numeroImaginario1 = Double.parseDouble(multiplicacaoImaginaria[0]);

        numerosParaMultiplicar[0] = coeficientesReais[1];
        numerosParaMultiplicar[1] = coeficientesImaginarios[0];
        String[] multiplicacaoImaginaria2 = operacoesPrimarias.multiplicar(numerosParaMultiplicar);
        double numeroImaginario2 = Double.parseDouble(multiplicacaoImaginaria2[0]);

        numerosParaSomar[0] = numeroImaginario1;
        numerosParaSomar[1] = numeroImaginario2;

        String[] somaImaginaria = operacoesPrimarias.somar(numerosParaSomar);

        double numeroImaginario = Double.parseDouble(somaImaginaria[0]);

        double[] numerosParaMultiplicar2 = new double[3];

        numerosParaMultiplicar2[0] = coeficientesImaginarios[0];
        numerosParaMultiplicar2[1] = coeficientesImaginarios[1];
        numerosParaMultiplicar2[2] = -1;

        String[] multiplicacaoImaginaria3 = operacoesPrimarias.multiplicar(numerosParaMultiplicar2);
        double coeficienteReal2 = Double.parseDouble(multiplicacaoImaginaria3[0]);

        numerosParaSomar[0] = coeficienteReal1;
        numerosParaSomar[1] = coeficienteReal2;
        String[] somaReal = operacoesPrimarias.somar(numerosParaSomar);
        double coeficienteReal = Double.parseDouble(somaReal[0]);



        double[] novoNumero = new double[2];
        novoNumero[0] = coeficienteReal; 
        novoNumero[1] = numeroImaginario;

        System.out.println("arvore: ");
        System.out.println("(*");
        System.out.println("    (complex " + coeficientesReais[0] + " " + coeficientesImaginarios[0] +")");
        System.out.println("    (complex " + coeficientesReais[1] + " " + coeficientesImaginarios[1] +")");
        System.out.println(")");

        prompt.adicionarNovoNumero(novoNumero);
        prompt.quantidadeNumerosComplexos++;
    }

    //funcao que divide
    public static void divisaoComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);
        prompt.imprimir();

        int index;

        int[] indexDiv = new int[2];
        for (int i = 0; i < 2; i++) {
            System.out.print(i + 1 + "º Z: ");
            index = sc.nextInt();
            if (index > prompt.quantidadeNumerosComplexos) {
                System.out.println("Esse Z não existe! coloque um valor válido!");
                i --;
            } else {
                indexDiv[i] = index;
            }
        }

        double a = prompt.getCoeficienteReal(indexDiv[0]);
        double b = prompt.getCoeficienteImaginario(indexDiv[0]);

        double c = prompt.getCoeficienteReal(indexDiv[1]);
        double d = prompt.getCoeficienteImaginario(indexDiv[1]);

        // arvore sintática
        System.out.println("arvore:");
        System.out.println("(/");
        System.out.println("    (complex " + a + " " + b + ")");
        System.out.println("    (complex " + c + " " + d + ")");
        System.out.println(")");

        double denom = c * c + d * d;

        if (denom == 0) {
            System.out.println("Erro: divisão por zero!");
            return;
        }

        double real = (a * c + b * d) / denom;
        double imag = (b * c - a * d) / denom;

        String realFmt = String.format("%.2f", real); // 2 casas
        String imagFmt = String.format("%.2f", imag);

        double[] novoNumero = new double[2];

        novoNumero[0] = Double.parseDouble(String.format("%.2f", real).replace(",", "."));
        novoNumero[1] = Double.parseDouble(String.format("%.2f", imag).replace(",", "."));

        prompt.adicionarNovoNumero(novoNumero);

        System.out.println("Resultado da divisão:");
        System.out.println(realFmt + " + " + imagFmt + "i");
    }

    //funcao que conjulga
    public static void conjulgar(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("Qual Z você quer conjulgar?");
            prompt.imprimir();

            System.out.print("nº Z:");
            escolha = sc.nextInt();
            if (escolha > prompt.quantidadeNumerosComplexos) {
                System.out.println("Valor inválido");
            } 
        } while (escolha > prompt.quantidadeNumerosComplexos);


        double coeficienteReal = prompt.getCoeficienteReal(escolha);
        double coeficienteImaginario = prompt.getCoeficienteImaginario(escolha);

        double[] novoNumero = new double[2];
        novoNumero[0] = coeficienteReal;
        novoNumero[1] = coeficienteImaginario * -1;

        prompt.quantidadeNumerosComplexos++;
        prompt.adicionarNovoNumero(novoNumero);
        System.out.println("arvore: ");
        System.out.println("(conj");
        System.out.println("    (complex " + coeficienteReal + " " + coeficienteImaginario +")");
        System.out.println(")");
        System.out.println("Numero complexo conjugado adicionado!");
        
    }

    //funcao que eleva
    public static void elevar(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);

        int escolha;
        do {
            System.out.println("Qual Z você quer elevar?");
            prompt.imprimir();
            
            System.out.print("nº Z:");
            escolha = sc.nextInt();
            if (escolha > prompt.quantidadeNumerosComplexos || escolha <= 0) {
                System.out.println("Valor inválido");
            } 
        } while (escolha > prompt.quantidadeNumerosComplexos || escolha <= 0);

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
            novoNumeroComplexo[1] = Double.parseDouble(resultado[0]);
        }

        if (contagemFalsos >= 2) {
            for (int i = 0; i < contagemFalsos; i++) {
                numerosParaSomarReais[i] = expressaoExtendida[indexSomaReais.get(i)];
            }

            String[] resultado = operacoesPrimarias.somar(numerosParaSomarReais);
            novoNumeroComplexo[0] = Double.parseDouble(resultado[0]);
        }

        if (contagemFalsos == 1) {
            novoNumeroComplexo[0] = expressaoExtendida[indexSomaReais.get(0)];
        }
        if (contagemVerdadeiros == 1) {
            novoNumeroComplexo[1] = expressaoExtendida[indexSomaImaginarios.get(0)];
        }

        System.out.println("arvore: ");
        System.out.println("(^");
        System.out.println("    (complex " + coeficienteReal + " " + coeficienteImaginario +")");
        System.out.println("    " + eleva);
        System.out.println(")");
        prompt.quantidadeNumerosComplexos++;
        prompt.adicionarNovoNumero(novoNumeroComplexo);

    } 

    //funcao que tira a raiz
    public static void raizComplexa(pegarNumeros prompt) {
        Scanner sc = new Scanner(System.in);
        prompt.imprimir();

        System.out.println("De qual Z você quer calcular a raiz? ");
        int index = sc.nextInt();

        double[] coefReais = prompt.GetCoeficientesReais(new int[]{index});
        double[] coefImaginarios = prompt.GetCoeficientesImaginarios(new int[]{index});

        double a = coefReais[0];
        double b = coefImaginarios[0];

        double r = Math.sqrt(a * a + b * b);
        double parteReal = Math.sqrt((r + a) / 2);
        double parteImaginaria = Math.signum(b) * Math.sqrt((r - a) / 2);

        double[] novoNumero = new double[2];
        novoNumero[0] = parteReal;
        novoNumero[1] = parteImaginaria;
        prompt.quantidadeNumerosComplexos++;
        prompt.adicionarNovoNumero(novoNumero);
    
        String resultado = "\nResultado da Raiz = (" + String.format("%.4f", parteReal)
            + (parteImaginaria >= 0 ? "+" : "") + String.format("%.4f", parteImaginaria) + "i)";

        System.out.println("arvore: ");
        System.out.println("(sqrt");
        System.out.println("    (complex " + a + " " + b +")");
        System.out.println(")");

        System.out.println(resultado);
    }
}

