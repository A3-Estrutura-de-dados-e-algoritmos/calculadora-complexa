import java.util.Scanner;

public class pegarNumeros {

    public int quantidadeNumerosComplexos;
    public double[] numerosComplexos;
    Scanner sc = new Scanner(System.in);

    public pegarNumeros(int quantidadeNumerosComplexos) {
        this.quantidadeNumerosComplexos = quantidadeNumerosComplexos;
        this.numerosComplexos = new double[quantidadeNumerosComplexos * 2];
    }

    public double[] getTodosCoeficientesReais() {
        double[] coeficientes = new double[numerosComplexos.length / 2];
        for (int i = 0; i < numerosComplexos.length / 2; i++) {
            int referencia = i * 2;
            coeficientes[i] = numerosComplexos[referencia];
        }

        return coeficientes;
    }

    public double[] getTodosCoeficientesImaginarios() {
        double[] coeficientes = new double[numerosComplexos.length / 2];
        for (int i = 0; i < numerosComplexos.length / 2; i++) {
            int referencia = i + (i + 1);
            coeficientes[i] = numerosComplexos[referencia];
        }

        return coeficientes;
    }

    public double[] GetCoeficientesReais(int[] numerosZReferente) {
        double[] coeficientes = new double[numerosZReferente.length];
        for (int i = 0; i < numerosZReferente.length; i++) {
            int referencia = numerosZReferente[i] * 2;
            coeficientes[i] = this.numerosComplexos[referencia];
        }

        return coeficientes;
    }

    public double[] GetCoeficientesImaginarios(int[] numerosZReferente) {
        double[] coeficientes = new double[numerosZReferente.length];
        for (int i = 0; i < numerosZReferente.length; i++) {
            int referencia = numerosZReferente[i] + (numerosZReferente[i] + 1);
            coeficientes[i] = this.numerosComplexos[referencia];
        }

        return coeficientes;
    }

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

    public void imprimir() {
        for (int i = 0; i < numerosComplexos.length; i++) {
            System.out.println(numerosComplexos[i]);
        }
    }
}
