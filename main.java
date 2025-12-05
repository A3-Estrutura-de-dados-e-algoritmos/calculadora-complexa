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
                System.out.println("[1] - Calcular expressão LISP");
                System.out.println("[2] - calculadora inteligente");
                System.out.println("[3] - Verificar igualdade");
                escolha = Integer.parseInt(lerNum.nextLine());

                if (escolha == 1) {
                    System.out.println("Digite a expressão:");
                    System.out.println("Para representar o número complexo utilize (complex x y)");
                    String expr = lerNum.nextLine();

                    List<String> tokens = expressaoLisp.tokenize(expr);
                    NoLisp raiz = (NoLisp) expressaoLisp.parseTokens(tokens);

                    System.out.println("Árvore sintática:");
                    expressaoLisp.imprimeArvore(raiz);

                    Object resultado = expressaoLisp.eval(raiz);

                    System.out.println("Resultado:");
                    System.out.println(resultado.toString());
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
                } else if (escolha == 3) {
                    System.out.println("Digite a primeira expressão:");
                    String expr1 = lerNum.nextLine();

                    System.out.println("Digite a segunda expressão:");
                    String expr2 = lerNum.nextLine();

                    var arv1 = expressaoLisp.parseTokens(expressaoLisp.tokenize(expr1));
                    var arv2 = expressaoLisp.parseTokens(expressaoLisp.tokenize(expr2));

                    if (expressaoLisp.iguais((NoLisp) arv1, (NoLisp) arv2)) {
                        System.out.println("As expressões são estruturalmente iguais!");
                    } else {
                        System.out.println("As expressões são diferentes.");
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