import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main{

    public static void main(String[] args) {

        try (Scanner lerNum = new Scanner(System.in)) {

            pegarNumeros prompt = new pegarNumeros();
            
            int escolha = -1;

            while (escolha != 1 || escolha != 2) {

                System.out.println("Qual operação quer fazer?");
                System.out.println("[1] - expressão de entrada");
                System.out.println("[2] - calculadora inteligente");
                escolha = lerNum.nextInt();

                if (escolha == 1) {
                        List<String> toks = expressaoLisp.tokenize("(sqrt (complex 5 7))");
                        NoLisp root = (NoLisp) expressaoLisp.parseTokens(toks);
                        System.out.println(expressaoLisp.eval(root));
                    //validadorExpressao.handleExpressionInput(lerNum, prompt);
                } else if (escolha == 2) {
                    prompt.loopNumeros();
                    while (escolha != 0) {
                        prompt.imprimir();
                        System.out.println("Qual operação você quer fazer?");
                        System.out.println("[1] - Soma");
                        System.out.println("[2] - Subtração");
                        System.out.println("[3] - Multiplicação");
                        System.out.println("[4] - Divisão");
                        System.out.println("[5] - conjulgar");
                        System.out.println("[6] - elevar");
                        System.out.println("[7] - raiz");
                        System.out.println("[8] - Adicionar novo número");
                        System.out.println("Caso queira encerrar digite 0.");

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
                            case 6:
                                operacoesCalculadora.elevar(prompt);
                                break;
                            case 7:
                                operacoesCalculadora.raizComplexa(prompt);
                                break;
                            case 8:
                                prompt.loopNumeros();
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                    System.out.println("Faça uma escolha válida!");
                }
            }
            

        } catch(InputMismatchException e) {
            System.out.println("Valor inserido inválido, por favor tente novamente.");
        }
    }
}