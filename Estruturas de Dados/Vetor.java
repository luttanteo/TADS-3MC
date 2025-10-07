package projeto_revisao;

public class Vetor {
    public String[] elementos;
    public int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(String elemento) throws Exception {
        if (this.tamanho < this.elementos.length) { // o tamanho deve ser menor que a capacidade
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("O vetor já está cheio. Não é possível adicionar novos elementos.");
        }
    }

    public int tamanho() {
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

    public String busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return this.elementos[posicao];
        } else {
            throw new Exception ("Posição inválida!");
        }
    }

    public int buscaConteudo (String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equalsIgnoreCase(elemento)) {
                return i;
            }
        }
        return -1;
    }
}
