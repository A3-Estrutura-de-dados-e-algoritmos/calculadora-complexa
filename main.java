import java.util.InputMismatchException;
import java.util.Scanner;

public class main{

    public static void main(String[] args) {

        try (Scanner lerNum = new Scanner(System.in)) {
            System.out.println("Quantidade de números complexos: ");
            int quantidadeNumerosComplexos = lerNum.nextInt();

            pegarNumeros prompt = new pegarNumeros(quantidadeNumerosComplexos);

            prompt.loopNumeros();

            operacoesCalculadora.subtracaoComplexa(prompt);

            prompt.imprimir();

            //Adição dos reais e imaginários separado para que o resultado possa ser formatado bem quando for printado, já que é a + bi
            //System.out.println(operacoesCalculadora.subtracaoComplexa(vR1, vI1, vR2, vI2));

        } catch(InputMismatchException e) {
            System.out.println("Valor inserido inválido, por favor tente novamente.");
        }
    }
}