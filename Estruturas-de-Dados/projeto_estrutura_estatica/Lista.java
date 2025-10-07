package projeto_estrutura_estatica;

public class Lista<T> extends EstruturaEstatica<T>{
    public Lista(int capacidade) {
        super(capacidade);
    }

    public Lista() {
        super();
    }

    public boolean adiciona(T elemento) {
        return super.adiciona(elemento);
    }

    public boolean adiciona(int posicao, T elemento) {
        return super.adiciona(posicao, elemento);
    }
}
