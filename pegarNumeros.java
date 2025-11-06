import java.util.ArrayList;
import java.util.Scanner;

public class pegarNumeros {

    //atributos
    public int quantidadeNumerosComplexos; //pega a quantidade de números complexos

    ArrayList<Double> coeficientesReais = new ArrayList<Double>();
    ArrayList<Double> coeficientesImaginarios = new ArrayList<Double>();
    Scanner sc = new Scanner(System.in);

    //construtor
    public pegarNumeros(int quantidadeNumerosComplexos) {
        this.quantidadeNumerosComplexos = quantidadeNumerosComplexos;
    }

    public double getCoeficienteReal(int numeroZReferente) {
        return coeficientesReais.get(numeroZReferente - 1);
    }

    public double getCoeficienteImaginario(int numeroZReferente) {
        return coeficientesImaginarios.get(numeroZReferente - 1);
    }

    //função que pegar uma quantidade específica de coeficientes reais baseados no Z (ex: 0 pega o coeficiente real do primeiro número)
    public double[] GetCoeficientesReais(int[] numerosZReferente) {
        double[] coeficientes = new double[numerosZReferente.length];
        for (int i = 0; i < numerosZReferente.length; i++) {
            coeficientes[i] = coeficientesReais.get(numerosZReferente[i] - 1);
        }

        return coeficientes;
    }

    //função que pega o coeficiente imaginário baseado no Z, onde o primeiro número imaginário o index é 0
    public double[] GetCoeficientesImaginarios(int[] numerosZReferente) {
        double[] coeficientes = new double[numerosZReferente.length];
        for (int i = 0; i < numerosZReferente.length; i++) {
            coeficientes[i] = coeficientesImaginarios.get(numerosZReferente[i] - 1);
        }

        return coeficientes;
    }

    //loop que pega os numeros imaginários
    public void loopNumeros() {
        double valor;
        for (int i = 0; i < quantidadeNumerosComplexos; i++) {
            System.out.printf("Digite o número real do %dº complexo: ", i + 1);
            valor = sc.nextDouble();
            coeficientesReais.add(valor);
            System.out.printf("Digite o número imaginário %dº número complexo: ", i + 1);
            valor = sc.nextDouble();
            coeficientesImaginarios.add(valor);
        }
    }

    //função que adiciona um novo número a lista
    public void adicionarNovoNumero(double[] novoNumeroComplexo) {
        coeficientesReais.add(novoNumeroComplexo[0]);
        coeficientesImaginarios.add(novoNumeroComplexo[1]);
    }

    //mostra os números complexos
    public void imprimir() {
        int cont = 1;
        String construtorString;
        String coeficienteReal;
        String coeficienteImaginario;
        for (int i = 0; i < coeficientesReais.size(); i++) {
            coeficienteReal = String.valueOf(coeficientesReais.get(i));
            coeficienteImaginario = String.valueOf(coeficientesImaginarios.get(i));
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
