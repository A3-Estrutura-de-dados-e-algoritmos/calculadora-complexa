import java.util.Scanner;

public class pegarNumeros {

    //atributos
    public int quantidadeNumerosComplexos; //pega a quantidade de números complexos
    public double[] numerosComplexos; //vetor de números complexos
    Scanner sc = new Scanner(System.in);

    //construtor
    public pegarNumeros(int quantidadeNumerosComplexos) {
        this.quantidadeNumerosComplexos = quantidadeNumerosComplexos;
        this.numerosComplexos = new double[quantidadeNumerosComplexos * 2];
    }

    //função que retorna todos os coeficientes reais dos numeros complexos
    public double[] getTodosCoeficientesReais() {
        double[] coeficientes = new double[numerosComplexos.length / 2];
        for (int i = 0; i < numerosComplexos.length / 2; i++) {
            int referencia = i * 2;
            coeficientes[i] = numerosComplexos[referencia];
        }

        return coeficientes;
    }

    //função que retorna todos os coeficientes imaginários
    public double[] getTodosCoeficientesImaginarios() {
        double[] coeficientes = new double[numerosComplexos.length / 2];
        for (int i = 0; i < numerosComplexos.length / 2; i++) {
            int referencia = i + (i + 1);
            coeficientes[i] = numerosComplexos[referencia];
        }

        return coeficientes;
    }

    //função que pegar uma quantidade específica de coeficientes reais baseados no Z (ex: 0 pega o coeficiente real do primeiro número)
    public double[] GetCoeficientesReais(int[] numerosZReferente) {
        double[] coeficientes = new double[numerosZReferente.length];
        for (int i = 0; i < numerosZReferente.length; i++) {
            int referencia = numerosZReferente[i] * 2;
            coeficientes[i] = this.numerosComplexos[referencia];
        }

        return coeficientes;
    }

    //função que pega o coeficiente imaginário baseado no Z, onde o primeiro número imaginário o index é 0
    public double[] GetCoeficientesImaginarios(int[] numerosZReferente) {
        double[] coeficientes = new double[numerosZReferente.length];
        for (int i = 0; i < numerosZReferente.length; i++) {
            int referencia = numerosZReferente[i] + (numerosZReferente[i] + 1);
            coeficientes[i] = this.numerosComplexos[referencia];
        }

        return coeficientes;
    }

    //loop que pega os numeros imaginários
    public void loopNumeros() {
        int cont = 0;
        double valor;
        for (int i = 0; i < quantidadeNumerosComplexos; i++) {
            System.out.printf("Digite o número real do %dº complexo: ", i + 1);
            valor = sc.nextDouble();
            numerosComplexos[cont] = valor;
            cont ++;
            System.out.printf("Digite o número imaginário %dº número complexo: ", i + 1);
            valor = sc.nextDouble();
            numerosComplexos[cont] = valor;
            cont++;
        }
    }

    //mostra os números complexos
    public void imprimir() {
        for (int i = 0; i < numerosComplexos.length; i++) {
            System.out.println(numerosComplexos[i]);
        }
    }
}
