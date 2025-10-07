package metodos_ordenacao.insertion;

public class InsertionSortTime {
    public static void main(String[] args) {
        int [] vetor = new int[1000000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        // variável que registra o tempo de execução no início
        long inicio = System.currentTimeMillis();

        // método InsertionSort
        int auxiliar, j;
        for (int i = 0; i < vetor.length; i++) {
            auxiliar = vetor[i];
            j = i - 1;
            while(j >= 0 && vetor[j] > auxiliar) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = auxiliar;
        }

        // variável para registrar o tempo de execução no final
        long fim = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (fim-inicio));
    }
}
