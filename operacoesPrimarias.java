public class operacoesPrimarias {
    
    public static String[] somar(double[] numerosParaSomar) {
        String[] retorno = new String[2];

        String arvore = "+(";
        String numeroReferencia;
        double soma = 0;

        for (int i = 0; i < numerosParaSomar.length; i++) {
            soma += numerosParaSomar[i];
            numeroReferencia = String.valueOf(numerosParaSomar[i]);
            arvore = arvore + " " + numeroReferencia + " ";
        }

        arvore += ") ";

        retorno[0] = String.valueOf(soma);
        retorno[1] = arvore;

        return retorno;

    }

}
