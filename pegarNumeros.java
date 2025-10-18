import java.util.ArrayList;
import java.util.Scanner;

public class pegarNumeros {

    //atributos
    public int quantidadeNumerosComplexos; //pega a quantidade de números complexos
    ArrayList<Double> numerosComplexos = new ArrayList<Double>(); //vetor de números complexos
    Scanner sc = new Scanner(System.in);

    //construtor
    public pegarNumeros(int quantidadeNumerosComplexos) {
        this.quantidadeNumerosComplexos = quantidadeNumerosComplexos;
    }

    //função que retorna todos os coeficientes reais dos numeros complexos
    public double[] getTodosCoeficientesReais() {
        double[] coeficientes = new double[numerosComplexos.size() / 2];
        for (int i = 0; i < numerosComplexos.size() / 2; i++) {
            int referencia = i * 2;
            coeficientes[i] = numerosComplexos.get(referencia);
        }

        return coeficientes;
    }

    //função que retorna todos os coeficientes imaginários
    public double[] getTodosCoeficientesImaginarios() {
        double[] coeficientes = new double[numerosComplexos.size() / 2];
        for (int i = 0; i < numerosComplexos.size() / 2; i++) {
            int referencia = i + (i + 1);
            coeficientes[i] = numerosComplexos.get(referencia);
        }

        return coeficientes;
    }

    //função que pegar uma quantidade específica de coeficientes reais baseados no Z (ex: 0 pega o coeficiente real do primeiro número)
    public double[] GetCoeficientesReais(int[] numerosZReferente) {
        double[] coeficientes = new double[numerosZReferente.length];
        for (int i = 0; i < numerosZReferente.length; i++) {
            int referencia = numerosZReferente[i] * 2;
            coeficientes[i] = numerosComplexos.get(referencia);
        }

        return coeficientes;
    }

    //função que pega o coeficiente imaginário baseado no Z, onde o primeiro número imaginário o index é 0
    public double[] GetCoeficientesImaginarios(int[] numerosZReferente) {
        double[] coeficientes = new double[numerosZReferente.length];
        for (int i = 0; i < numerosZReferente.length; i++) {
            int referencia = numerosZReferente[i] + (numerosZReferente[i] + 1);
            coeficientes[i] = numerosComplexos.get(referencia);
        }

        return coeficientes;
    }

    //loop que pega os numeros imaginários
    public void loopNumeros() {
        double valor;
        for (int i = 0; i < quantidadeNumerosComplexos; i++) {
            System.out.printf("Digite o número real do %dº complexo: ", i + 1);
            valor = sc.nextDouble();
            numerosComplexos.add(valor);
            System.out.printf("Digite o número imaginário %dº número complexo: ", i + 1);
            valor = sc.nextDouble();
            numerosComplexos.add(valor);
        }
    }

    //função que adiciona um novo número a lista
    public void adicionarNovoNumero(double[] novoNumeroComplexo) {
        for (int i = 0; i < novoNumeroComplexo.length; i++) {
            System.out.println(novoNumeroComplexo[i]);
            numerosComplexos.add(novoNumeroComplexo[i]);
        }
    }

    //mostra os números complexos
    public void imprimir() {
        int cont = 1;
        String construtorString;
        String coeficienteReal;
        String coeficienteImaginario;
        for (int i = 1; i < numerosComplexos.size(); i++) {
            i --;
            coeficienteReal = String.valueOf(numerosComplexos.get(i));
            i ++;
            coeficienteImaginario = String.valueOf(numerosComplexos.get(i));
            i ++;
            if (!coeficienteImaginario.contains("-")) {
                construtorString = coeficienteReal + " + " + coeficienteImaginario + "i"; 
            } else {
                construtorString = coeficienteReal + " " + coeficienteImaginario + "i"; 
            }
            System.out.printf("Z%d: " + construtorString + "\n", cont);
            cont ++;
        }
    }
}
