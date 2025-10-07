package metodos_ordenacao.bubble;

public class BubbleSort {
    public static void main(String[] args) {
        // vetor int de 10 posições
        int[] vetor = new int[10];

        // inserindo valores no vetor
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // exibindo os valores do vetor
            System.out.println(vetor[i]);
        }

        // método de ordenação BubbleSort
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

        // exibindo o vetor ordenado
        System.out.println(" ");
        System.out.println("Vetor ordenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}
