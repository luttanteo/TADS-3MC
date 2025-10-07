package metodos_ordenacao.quick;

public class QuickSortTime {
    public static void main(String[] args) {
        int[] vetor = new int[1000000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        // variável que registra o tempo de execução no início
        long inicio = System.currentTimeMillis();

        // chamando o método para a ordenação
        ordenacao(vetor, 0, vetor.length - 1);

        // variável para registrar o tempo de execução no final
        long fim = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (fim-inicio));
    }

    // método para ordenar
    static void ordenacao(int [] vetor, int esquerda, int direita) {
        if(esquerda < direita) {
            int p = particao(vetor, esquerda, direita);
            ordenacao(vetor, esquerda, p);
            ordenacao(vetor, p + 1, direita);
        }
    }

    // metodo para criar as partições (dividir o vetor em partes)
    static int particao(int[] vetor, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        int pivo = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while(true) {
            do {
                i++;
            } while(vetor[i] < pivo);
            do {
                j--;
            } while(vetor[j] > pivo);
            if(i >= j) {
                return j;
            }
            int auxiliar = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = auxiliar;
        }
    }
}
