package metodos_ordenacao.selection;

public class SelectionSortTime {
    public static void main(String[] args) {
        int[] vetor = new int[1000000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        // variável que registra o tempo de execução no início
        long inicio = System.currentTimeMillis();

        // método SelectionSort
        int menor_posicao, auxiliar;
        for (int i = 0; i < vetor.length; i++) {
            menor_posicao = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor_posicao]) {
                    menor_posicao = j;
                }
            }
            auxiliar = vetor[menor_posicao];
            vetor[menor_posicao] = vetor[i];
            vetor[i] = auxiliar;
        }

        // variável para registrar o tempo de execução no final
        long fim = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (fim-inicio));
    }
}
