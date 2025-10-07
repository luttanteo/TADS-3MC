package listadupla;

public class ListaDuplaEncadeada <Tipo> {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaDuplaEncadeada() {
        this.tamanho = 0;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public No get(int posicao) {
        // validacao
        No atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            if(atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }
        return atual;
    }

    public int buscar(Tipo elemento) {
        No <Tipo> atual = this.inicio;
        for (int i = 0; i < getTamanho(); i++) {
            if (atual.getElemento().equals(elemento)) {
                System.out.println("O conteúdo procurado existe e está na posição " + i + "!");
                return i;
            }
            atual = atual.getProximo();
        }
        System.out.println("O conteúdo procurado não existe!");
        return -1;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "ListaEncadeada{" + "inicio: " + inicio + "}";
    }

    public void adiciona(Tipo elemento) {
        No<Tipo> celula = new No<Tipo>(elemento);
        if (this.inicio == null && this.fim == null) {
            this.inicio = celula;
            this.fim = celula;
        } else {
            this.fim.setProximo(celula);
            celula.setAnterior(fim);
            this.fim = celula;
        }
        this.tamanho++;
    }

    public void remover(Tipo elemento) {
        No anterior = null;
        No atual = this.inicio;
        for (int i = 0; i < this.getTamanho(); i++) {
            if (atual.getElemento().equals(elemento)) {
                if (this.tamanho == 1) {
                    this.inicio = null;
                    this.fim = null;
                } else if (atual == inicio) {
                    this.inicio = atual.getProximo();
                } else if (atual == fim) {
                    this.fim = anterior;
                    anterior.setProximo(null);
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                atual = null;
                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }
}
