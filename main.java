import java.util.InputMismatchException;
import java.util.Scanner;

public class main{

    public static void main(String[] args) {
        // Variáveis vR = Valor real, vI = valor imaginário
        double vR1;
        double vI1;
        double vR2;
        double vI2;
        try (Scanner lerNum = new Scanner(System.in)) {
            System.out.println("Digite o número real do primeiro número complexo: ");
            vR1 = lerNum.nextDouble();
            System.out.println("Digite o número imaginário do primeiro número complexo: ");
            vI1 = lerNum.nextDouble();
            System.out.println("Digite o número real do segundo número complexo: ");
            vR2 = lerNum.nextDouble();
            System.out.println("Digite o número imaginário do segundo número complexo: ");
            vI2 = lerNum.nextDouble();

            //Adição dos reais e imaginários separado para que o resultado possa ser formatado bem quando for printado, já que é a + bi
            System.out.println(operacoesCalculadora.subtracaoComplexa(vR1, vI1, vR2, vI2));

        } catch(InputMismatchException e) {
            System.out.println("Valor inserido inválido, por favor tente novamente.");
        }
    }
}