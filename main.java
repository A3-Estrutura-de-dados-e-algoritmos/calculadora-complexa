import java.util.InputMismatchException;
import java.util.Scanner;

public class main{

    public static void main(String[] args) {

        try (Scanner lerNum = new Scanner(System.in)) {
            System.out.println("Quantidade de números complexos: ");
            int quantidadeNumerosComplexos = lerNum.nextInt();

            pegarNumeros prompt = new pegarNumeros(quantidadeNumerosComplexos);

            prompt.loopNumeros();

            int escolha = -1;
            while (escolha != 0) {
                prompt.imprimir();
                System.out.println("Qual operação você quer fazer?");
                System.out.println("[1] - Soma");
                System.out.println("[2] - Subtração");
                System.out.println("[3] - Multiplicação");
                System.out.println("[4] - Divisão");
                System.out.println("[5] - conjulgar");

                escolha = lerNum.nextInt();

                switch (escolha) {
                    case 0:
                        break;
                    case 1:
                        operacoesCalculadora.adicaoComplexa(prompt);
                        break;
                    case 2:
                        operacoesCalculadora.subtracaoComplexa(prompt);
                        break;
                    case 3:
                        operacoesCalculadora.multiplicacaoComplexa(prompt);
                        break;
                    case 4:
                        operacoesCalculadora.divisaoComplexa(prompt);
                        break;
                    case 5:
                        operacoesCalculadora.conjulgar(prompt);
                        break;
                    default:
                        break;
                }
            }

            operacoesCalculadora.adicaoComplexa(prompt);

            prompt.imprimir();

            //Adição dos reais e imaginários separado para que o resultado possa ser formatado bem quando for printado, já que é a + bi
            //System.out.println(operacoesCalculadora.subtracaoComplexa(vR1, vI1, vR2, vI2));

        } catch(InputMismatchException e) {
            System.out.println("Valor inserido inválido, por favor tente novamente.");
        }
    }
}