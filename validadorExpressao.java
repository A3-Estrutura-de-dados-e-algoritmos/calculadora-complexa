import java.util.*;
import java.util.regex.*;

public class validadorExpressao {

    public static class ComplexNum {
        public double re, im;
        public ComplexNum(double re, double im) { this.re = re; this.im = im; }
        public ComplexNum add(ComplexNum o) { return new ComplexNum(re + o.re, im + o.im); }
        public ComplexNum sub(ComplexNum o) { return new ComplexNum(re - o.re, im - o.im); }
        public ComplexNum mul(ComplexNum o) {
            return new ComplexNum(re*o.re - im*o.im, re*o.im + im*o.re);
        }
        public ComplexNum div(ComplexNum o) {
            double denom = o.re*o.re + o.im*o.im;
            if (denom == 0) throw new ArithmeticException("Divisão por zero (denominador 0+0i).");
            return new ComplexNum((re*o.re + im*o.im)/denom, (im*o.re - re*o.im)/denom);
        }
        public ComplexNum conj() { return new ComplexNum(re, -im); }
        public ComplexNum pow(int n) {
            if (n == 0) return new ComplexNum(1,0);
            ComplexNum res = new ComplexNum(re, im);
            ComplexNum acc = new ComplexNum(1,0);
            for (int i=0;i<n;i++) acc = acc.mul(res);
            return acc;
        }
        public ComplexNum sqrt() {
            double r = Math.sqrt(re*re + im*im);
            double real = Math.sqrt((r + re)/2.0);
            double imag = Math.signum(im) * Math.sqrt((r - re)/2.0);
            return new ComplexNum(real, imag);
        }
        public String toString() {
            return String.format("%.2f %s %.2fi", re, (im < 0 ? "-" : "+"), Math.abs(im));
        }
    }

    static class Token {
        public String type; 
        public String text;
        public Token(String type, String text) { this.type = type; this.text = text; }
        public String toString(){ return type+":"+text; }
    }

    static class Tokenizer {
        private static final Pattern TOKEN_PAT = Pattern.compile(
            "\\s*(\\(|\\)|[+-]?\\d*\\.\\d+|[+-]?\\d+|[A-Za-z\\^\\+\\-\\*/]+)\\s*");
        private final List<Token> tokens = new ArrayList<>();
        private int idx = 0;
        public Tokenizer(String input) {
            Matcher m = TOKEN_PAT.matcher(input);
            int pos = 0;
            while (m.find()) {
                String tk = m.group(1);
                tokens.add(classifyToken(tk));
                pos = m.end();
            }
            if (tokens.isEmpty()) {
            }
        }
        private Token classifyToken(String tk) {
            if (tk.equals("(")) return new Token("LPAREN", tk);
            if (tk.equals(")")) return new Token("RPAREN", tk);
            if (tk.matches("[+-]?\\d*\\.\\d+|[+-]?\\d+")) return new Token("NUMBER", tk);
            return new Token("IDENT", tk);
        }
        public Token peek() { return (idx < tokens.size()) ? tokens.get(idx) : null; }
        public Token next() { return (idx < tokens.size()) ? tokens.get(idx++) : null; }
        public boolean hasNext() { return idx < tokens.size(); }
    }

    public static abstract class Expr {
        public abstract ComplexNum eval(EvalContext ctx);
        public abstract String toLisp();
        public void collectVars(Set<String> s) {}
    }

    static class ComplexLiteral extends Expr {
        double a, b;
        ComplexLiteral(double a, double b) { this.a=a; this.b=b; }
        public ComplexNum eval(EvalContext ctx) { return new ComplexNum(a,b); }
        public String toLisp() { return "(complex " + fmt(a) + " " + fmt(b) + ")"; }
    }

    static class VarNode extends Expr {
        String name;
        VarNode(String name) { this.name = name; }
        public ComplexNum eval(EvalContext ctx) {
            if (!ctx.vars.containsKey(name)) {
                ctx.askVariable(name);
            }
            if (!ctx.vars.containsKey(name)) throw new RuntimeException("Variável " + name + " não definida.");
            return ctx.vars.get(name);
        }
        public String toLisp() { return name; }
        public void collectVars(Set<String> s) { s.add(name); }
    }

    static class OpNode extends Expr {
        String op;
        List<Expr> args;
        OpNode(String op, List<Expr> args) { this.op = op; this.args = args; }
        public ComplexNum eval(EvalContext ctx) {
            switch (op) {
                case "+": {
                    if (args.size() < 2) throw new RuntimeException("Operador + requer >= 2 argumentos.");
                    ComplexNum sum = new ComplexNum(0,0);
                    for (Expr e: args) sum = sum.add(e.eval(ctx));
                    return sum;
                }
                case "*": {
                    if (args.size() < 2) throw new RuntimeException("Operador * requer >= 2 argumentos.");
                    ComplexNum prod = args.get(0).eval(ctx);
                    for (int i=1;i<args.size();i++) prod = prod.mul(args.get(i).eval(ctx));
                    return prod;
                }
                case "-": {
                    if (args.size() == 1) {
                        ComplexNum v = args.get(0).eval(ctx);
                        return new ComplexNum(-v.re, -v.im);
                    } else if (args.size() == 2) {
                        return args.get(0).eval(ctx).sub(args.get(1).eval(ctx));
                    } else {
                        ComplexNum res = args.get(0).eval(ctx);
                        for (int i=1;i<args.size();i++) res = res.sub(args.get(i).eval(ctx));
                        return res;
                    }
                }
                case "/": {
                    if (args.size() != 2) throw new RuntimeException("Operador / requer exatamente 2 argumentos.");
                    ComplexNum num = args.get(0).eval(ctx);
                    ComplexNum den = args.get(1).eval(ctx);
                    return num.div(den);
                }
                case "conj":
                case "conjugate":
                case "conjugar": {
                    if (args.size() != 1) throw new RuntimeException("conj requer 1 argumento.");
                    return args.get(0).eval(ctx).conj();
                }
                case "sqrt":
                case "root": {
                    if (args.size() != 1) throw new RuntimeException("sqrt requer 1 argumento.");
                    return args.get(0).eval(ctx).sqrt();
                }
                case "^":
                case "pow": {
                    if (args.size() != 2) throw new RuntimeException("^ requer 2 argumentos: ( ^ expr n ).");
                    ComplexNum base = args.get(0).eval(ctx);
                    Expr expExpr = args.get(1);
                    if (!(expExpr instanceof LiteralNumber)) throw new RuntimeException("expoente deve ser inteiro literal.");
                    int n = (int) ((LiteralNumber)expExpr).value;
                    if (n < 0) throw new RuntimeException("expoente negativo não suportado neste implemento.");
                    return base.pow(n);
                }
                default:
                    throw new RuntimeException("Operador desconhecido: " + op);
            }
        }
        public String toLisp() {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(op);
            for (Expr e: args) {
                sb.append("\n    ").append(indent(e.toLisp(), "    "));
            }
            sb.append("\n)");
            return sb.toString();
        }
        private String indent(String s, String prefix) {
            String[] lines = s.split("\n");
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<lines.length;i++) {
                if (i>0) sb.append("\n");
                sb.append(prefix).append(lines[i]);
            }
            return sb.toString();
        }
        public void collectVars(Set<String> s) {
            for (Expr e: args) e.collectVars(s);
        }
    }

    static class LiteralNumber extends Expr {
        double value;
        LiteralNumber(double v) { this.value = v; }
        public ComplexNum eval(EvalContext ctx) { return new ComplexNum(value, 0); } 
        public String toLisp() { return fmt(value); }
    }

    static class Parser {
        private Tokenizer tokens;
        public Parser(String input) { tokens = new Tokenizer(input); }
        public Expr parse() {
            Token t = tokens.peek();
            if (t == null) throw new RuntimeException("Entrada vazia ou token inválido.");
            return parseExpr();
        }
        private Expr parseExpr() {
            Token t = tokens.peek();
            if (t == null) throw new RuntimeException("Expressão incompleta.");
            if (t.type.equals("LPAREN")) {
                tokens.next(); 
                Token op = tokens.next();
                if (op == null || (!op.type.equals("IDENT"))) throw new RuntimeException("Operador esperado após '('");
                String opText = op.text;
                List<Expr> args = new ArrayList<>();
                while (tokens.peek() != null && !tokens.peek().type.equals("RPAREN")) {
                    args.add(parseExpr());
                }
                if (tokens.peek() == null) throw new RuntimeException("Parêntese ) esperado (falta fechar).");
                tokens.next(); 
                if (opText.equalsIgnoreCase("complex")) {
                    if (args.size() != 2 || !(args.get(0) instanceof LiteralNumber) || !(args.get(1) instanceof LiteralNumber))
                        throw new RuntimeException("complex requer dois números literais: (complex a b)");
                    double a = ((LiteralNumber)args.get(0)).value;
                    double b = ((LiteralNumber)args.get(1)).value;
                    return new ComplexLiteral(a,b);
                } else {
                    return new OpNode(opText, args);
                }
            } else if (t.type.equals("NUMBER")) {
                Token n = tokens.next();
                double v = Double.parseDouble(n.text);
                return new LiteralNumber(v);
            } else if (t.type.equals("IDENT")) {
                Token id = tokens.next();
                return new VarNode(id.text);
            } else {
                throw new RuntimeException("Token inválido: " + t.text);
            }
        }
    }

    public static class EvalContext {
        public Map<String, ComplexNum> vars = new HashMap<>();
        private Scanner sc;
        public EvalContext(Scanner sc) { this.sc = sc; }
        public void askVariable(String name) {
            System.out.println("Digite o valor de " + name + " (parte real): ");
            double re = readDouble();
            System.out.println("Digite o valor de " + name + " (parte imaginária): ");
            double im = readDouble();
            vars.put(name, new ComplexNum(re, im));
        }
        private double readDouble() {
            while (true) {
                try {
                    String s = sc.next().replace(",", ".");
                    return Double.parseDouble(s);
                } catch (Exception ex) {
                    System.out.println("Entrada inválida. Digite número válido:");
                }
            }
        }
    }

    private static String fmt(double v) { return String.format("%.2f", v); }

    public static Expr parseExpression(String input) {
        Parser p = new Parser(input);
        return p.parse();
    }

    public static ComplexNum evaluateWithPrompt(Expr expr, Scanner sc) {
        EvalContext ctx = new EvalContext(sc);
        Set<String> vars = new HashSet<>();
        expr.collectVars(vars);
        for (String var : vars) {
            if (!ctx.vars.containsKey(var)) {
                ctx.askVariable(var);
            }
        }
        return expr.eval(ctx);
    }

    public static void handleExpressionInput(Scanner sc, pegarNumeros prompt) {
        System.out.println("Digite a expressão em notação LISP (uma linha). Ex: (+ (complex 1 2) (complex 3 4))");
        String line = null;
        sc.nextLine(); 
        line = sc.nextLine();
        try {
            Expr expr = parseExpression(line);
            System.out.println("arvore:");
            System.out.println(expr.toLisp());
            ComplexNum res = evaluateWithPrompt(expr, sc);
            System.out.println("Resultado: " + res.toString());

            double re = Double.parseDouble(String.format("%.2f", res.re).replace(",", "."));
            double im = Double.parseDouble(String.format("%.2f", res.im).replace(",", "."));
            prompt.quantidadeNumerosComplexos++;
            prompt.adicionarNovoNumero(new double[]{re, im});
            System.out.println("Resultado adicionado como novo Z.");
        } catch (Exception ex) {
            System.out.println("Erro ao processar expressão: " + ex.getMessage());
        }
    }
}

