package metodos_ordenacao.insertion;

public class InsertionSort {
    public static void main(String[] args) {
        // vetor int de 10 posições
        int[] vetor = new int[10];

        // inserindo valores no vetor
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // exibindo os valores do vetor
            System.out.println(vetor[i]);
        }

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

        // exibindo o vetor ordenado
        System.out.println(" ");
        System.out.println("Vetor ordenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}
