package projeto_estrutura_estatica;

public class Pilha<T> extends EstruturaEstatica<T>{
    public Pilha() {
        super();
    }

    public Pilha(int capacidade) {
        super(capacidade);
    }

    public void empilha(T elemento) {
        super.adiciona(elemento);
    }

    public T topo() {
        if(this.estaVazia()) {
            return null;
        } else {
            return this.elementos[tamanho - 1];
        }
    }

    public T desempilha() {
        if(this.estaVazia()) {
            return null;
        }
        T elemento = this.elementos[tamanho - 1];
        super.remove(tamanho - 1);
        return elemento;
    }
}
