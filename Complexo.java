public class Complexo {
    public Double real;
    public Double imaginario;

    public Complexo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public Complexo soma(Complexo outro) {
        return new Complexo(this.real + outro.real, this.imaginario + outro.imaginario);
    }

    public Complexo subtracao(Complexo outro) {
        return new Complexo(this.real - outro.real, this.imaginario - outro.imaginario);
    }

    public Complexo multiplicacao(Complexo outro) {
        double real = this.real * outro.real - this.imaginario * outro.imaginario;
        double imaginario = this.real * outro.imaginario + this.imaginario * outro.real;
        return new Complexo(real, imaginario);
    }

    public Complexo divisao(Complexo outro) {
        double denom = outro.real * outro.real + outro.imaginario * outro.imaginario;
        if (denom == 0.0) throw new ArithmeticException("Divisão por zero!");

        double real = (this.real * outro.real + this.imaginario * outro.imaginario) / denom;
        double imaginario = (this.imaginario * outro.real - this.real * outro.imaginario) / denom;

        return new Complexo(real, imaginario);
    }

    public Complexo conjulgado() {
        return new Complexo(this.real, this.imaginario * -1);
    }

    public Complexo elevar(int n) {
        if (n == 0) return new Complexo(1, 0);
        Complexo resultado = new Complexo(1,0);
        Complexo base = new Complexo(this.real, this.imaginario);
        for (int i = 0; i < n; i++) resultado = resultado.multiplicacao(base);
        return resultado;
    }

    public Complexo sqrt() {
        double r = Math.hypot(this.real, this.imaginario);
        double real = Math.sqrt((r + this.real) / 2.0);
        double imaginario = Math.signum(this.imaginario) * Math.sqrt((r - this.real) / 2.0);
        return new Complexo(real, imaginario);
    }

    @Override
    public String toString() {
        return real + " + " + imaginario + "i";
    }
}
