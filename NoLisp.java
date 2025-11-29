import java.util.ArrayList;
import java.util.List;

public class NoLisp {
    String valor;
    List<NoLisp> filhos;

    NoLisp(String valor) {
        this.valor = valor;
        this.filhos = new ArrayList<>();
    }
}
