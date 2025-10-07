package ado_bibliotecas;

public class VetorBiblioteca {
    public Object[] elementos;
    public int tamanho;

    public VetorBiblioteca(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public void adicionaLivro(Object elemento) {
        this.aumentaCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    public int tamanhoAcervo() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(); //
        s.append("["); // concatena informações

        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]"); // concatena informações

        return s.toString();
    }

    public Object buscaLivro(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return this.elementos[posicao];
        } else {
            System.out.println(("Posição inválida!"));
        }
        return null;
    }

    public int buscaConteudo (Object elemento) { // verifica se o conteudo existe e dá a posição dele
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                System.out.println("O conteúdo procurado existe e está na posição " + i + "!");
                return i;
            }
        }
        System.out.println("O conteúdo procurado não existe!");
        return -1;
    }

    public boolean adicionaInicio(int posicao, Object elemento) {
        this.aumentaCapacidade();
        if(posicao >= 0 && posicao < tamanho) {
            for(int i = this.tamanho - 1; i >= posicao; i--) {
                this.elementos[i + 1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        }
        return true;
    }

    private void aumentaCapacidade() {
        if(this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for(int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public void removeLivro(int posicao) throws Exception {
        if(posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
            this.elementos[tamanho] = null;
            this.tamanho--;
        } else {
            System.out.println(("Posição inválida!"));
        }
    }
}
