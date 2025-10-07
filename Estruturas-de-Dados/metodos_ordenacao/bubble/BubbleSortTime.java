package metodos_ordenacao.bubble;

public class BubbleSortTime {
    public static void main(String[] args) {
        int [] vetor = new int[1000000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        // variável que registra o tempo de execução no início
        long inicio = System.currentTimeMillis();

        // Método BubbleSort
        int auxiliar;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] > vetor[j]) {
                    auxiliar = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = auxiliar;
                }
            }
        }

        // variável para registrar o tempo de execução no final
        long fim = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (fim-inicio));
    }
}
