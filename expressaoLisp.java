import java.util.*;

public class expressaoLisp {

    public static List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<String>();
        StringBuilder atual = new StringBuilder(); 

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isWhitespace(c)) {
                if (atual.length() > 0) {
                    tokens.add(atual.toString());
                    atual.setLength(0);
                }
            } else {
                if (c == '('|| c == ')') {
                    if (atual.length() > 0) {
                        tokens.add(atual.toString());
                        atual.setLength(0);
                    } 
                    tokens.add(String.valueOf(c));
                } else {
                    atual.append(c);
                }
            }

        }
        if (atual.length() > 0) {
            tokens.add(atual.toString());
        }

        return tokens;

    }

    public static Object parseTokens(List<String> tokens) {
        Stack<NoLisp> pilha = new Stack<>();

        Object raiz = null;

        for (String token : tokens) {
            if (token.equals("(")) {
                NoLisp novoNo = new NoLisp(null);
                if (!pilha.empty()) {
                    pilha.peek().filhos.add(novoNo);
                }
                pilha.push(novoNo);
                if (raiz == null) {
                    raiz = novoNo;
                }
            } else if (token.equals(")")) {
                pilha.pop();
            } else {
                NoLisp noAtomico = new NoLisp(token);
                pilha.peek().filhos.add(noAtomico);
            }
        }

        return raiz;
    }

    public static Object eval(NoLisp raiz) {
        if (raiz.filhos.isEmpty()) {
            String token = raiz.valor;

            try {
                double real = Double.parseDouble(token);
                return new Complexo(real, 0.0);
            } catch (NumberFormatException ex) {
                return token;
            }
        }

        NoLisp operadorNode = raiz.filhos.get(0);
        if (operadorNode.filhos.isEmpty() == false) {
            throw new RuntimeException("Operador inválido");
        }

        String operador = operadorNode.valor;

        if (operador.equalsIgnoreCase("complex")) {
            if (raiz.filhos.size() != 3) {
                throw new RuntimeException("Complex requer 2 argumentos");
            }

            Object obj1 = eval(raiz.filhos.get(1));
            Object obj2 = eval(raiz.filhos.get(2));

            double real, realImg;

            if (obj1 instanceof Complexo) real = ((Complexo)obj1).real;
            else if (obj1 instanceof String) throw new RuntimeException("Argumento não definido: " + obj1);
            else real = ((Double)obj1).doubleValue();
            
            if (obj2 instanceof Complexo) realImg = ((Complexo)obj2).real;
            else if (obj2 instanceof String) throw new RuntimeException("Argumento não definido: " + obj2);
            else realImg = ((Double)obj2).doubleValue();

            return new Complexo(real, realImg);
        }

        List<Complexo> args = new ArrayList<>();
        for (int i = 1; i < raiz.filhos.size(); i++) {
            Object variavel = eval(raiz.filhos.get(i));

            if (variavel instanceof Complexo) {
                args.add((Complexo)variavel);

            } else if (variavel instanceof String) {
                String nomeVariavel = (String)variavel;
                System.out.println("Digite o valor real de " + nomeVariavel + ": ");
                double variavelReal = new Scanner(System.in).nextDouble();
                System.out.println("Digite o valor imaginário de " + nomeVariavel + ": ");
                double variavelImaginaria = new Scanner(System.in).nextDouble();
                Complexo numeroComplexo = new Complexo(variavelReal, variavelImaginaria);
                args.add(numeroComplexo);
            } else {
                throw new RuntimeException("Argumento inesperado: " + variavel);
            }
        }

        if (operador.equals("+")) {
            Complexo resultado = new Complexo(0, 0);
            for (Complexo c : args) resultado = resultado.soma(c);
            return resultado;
        } else if (operador.equals("-")) {
            int contador = 0; 
            Complexo resultado = new Complexo(contador, contador);
            for (Complexo c : args) {
                if (contador == 0) {
                    resultado.real = c.real;
                    resultado.imaginario = c.imaginario;
                } else {
                    resultado = resultado.subtracao(c);   
                }
                contador ++;
            } 
            return resultado;
        } else if (operador.equals("*")) {
            int contador = 0;
            Complexo resultado = new Complexo(contador, contador);
            for (Complexo c : args) {
                if (contador == 0) {
                    resultado.real = c.real;
                    resultado.imaginario = c.imaginario;
                } else {
                    resultado = resultado.multiplicacao(c);   
                }
                contador ++;                
            }
            return resultado;
        } else if (operador.equals("/")) {
            int contador = 0;
            Complexo resultado = new Complexo(contador, contador);
            for (Complexo c : args) {
                if (contador == 0) {
                    resultado.real = c.real;
                    resultado.imaginario = c.imaginario;
                } else {
                    resultado = resultado.divisao(c);   
                }
                contador ++;                
            }
            return resultado;            
        } else if (operador.equals("conj") || operador.equals("conjulgado") || operador.equals("conjul")) {
            Complexo resultado = new Complexo(0, 0);
            for (Complexo c : args) {
                resultado = new Complexo(c.real, c.imaginario);
                resultado = resultado.conjulgado();             
            }
            return resultado;             
        } else if (operador.equals("^")) {
            //
        } else if (operador.equals("sqrt")) {
            Complexo resultado = new Complexo(0, 0);
            for (Complexo c : args) {
                resultado = new Complexo(c.real, c.imaginario);
                resultado = resultado.sqrt();             
            }
            return resultado;             
        }
        throw new RuntimeException("Operador não suportado: " + operador);
        
    }

    public static void imprimir(NoLisp no) {
        if (no == null) return;

        // Átomos (nós com valor)
        if (no.valor != null) {
            System.out.print(no.valor + " ");
            return;
        }

        // Listas
        System.out.print("(");
        for (NoLisp filho : no.filhos) {
            imprimir(filho);
        }
        System.out.print(")");
    }

}