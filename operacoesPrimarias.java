public class operacoesPrimarias {
    
    //função que soma todos os numeros que vem no vetor
    public static String[] somar(double[] numerosParaSomar) {
        String[] retorno = new String[2];

        //inicio de construção da árvore e atributos
        String arvore = "+(";
        String numeroReferencia;
        double soma = 0;

        //loop de soma e formação da árvore
        for (int i = 0; i < numerosParaSomar.length; i++) {
            soma += numerosParaSomar[i];
            numeroReferencia = String.valueOf(numerosParaSomar[i]);
            arvore = arvore + " " + numeroReferencia + " ";
        }

        //fechamento da árvore
        arvore += ") ";
        
        //confecção da árvore
        retorno[0] = String.valueOf(soma);
        retorno[1] = arvore;

        return retorno;

    }

    //função que subtrai dois numeros enviados no vetor, sendo o primeiro menos o segundo
    public static String[] subtrair(double[] numerosParaSubtrair) {
        String[] retorno = new String[2];
        String numeroReferencia;
        String arvore = "-(";

        //subtração iniciando
        double subtracao = 0;

        for (int i = 0; i < numerosParaSubtrair.length; i++) {
            if (i != 0) {
                subtracao -= numerosParaSubtrair[i];
            } else {
                subtracao += numerosParaSubtrair[i];
            }
            numeroReferencia = String.valueOf(numerosParaSubtrair[i]);
            arvore = arvore + " " + numeroReferencia + " ";
        }

        arvore += ") ";

        //criação do vetor e retorno
        retorno[0] = String.valueOf(subtracao);
        retorno[1] = arvore;

        return retorno;

    }

    //função que multiplica todos os números do vetor 
    public static String[] multiplicar(double[] numerosParaMultiplicar) {
        String[] retorno = new String[2];

        //inicio de criação da árvore e atributos
        String arvore = "*(";
        String numeroReferencia;
        double multiplicar = 1;

        //loop que multiplica os números e cria a árvore
        for (int i = 0; i < numerosParaMultiplicar.length; i++) {
            multiplicar *= numerosParaMultiplicar[i];
            numeroReferencia = String.valueOf(numerosParaMultiplicar[i]);
            arvore = arvore + " " + numeroReferencia + " ";
        }

        //fechamento da árvore
        arvore += ") ";

        //criação do retorno
        retorno[0] = String.valueOf(multiplicar);
        retorno[1] = arvore;

        return retorno;

    }

    //função que divide dois numeros sendo o primeiro pelo segundo
    public static String[] dividir(double[] numerosParaDividir) {
        String[] retorno = new String[2];

        //atribuição dos numeros
        double primeiroNumero = numerosParaDividir[0];
        double segundoNumero = numerosParaDividir[1];

        //divisao
        double divisao = primeiroNumero / segundoNumero;

        //montagem da árvore
        String arvore = "/(" + String.valueOf(primeiroNumero) + " " + String.valueOf(segundoNumero) + ") ";

        //montagem do retorno
        retorno[0] = String.valueOf(divisao);
        retorno[1] = arvore;

        return retorno;

    }

}
