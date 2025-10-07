package metodos_ordenacao.selection;

public class SelectionSort {
    public static void main(String[] args) {
        // vetor int de 10 posições
        int[] vetor = new int[10];

        // inserindo valores no vetor
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // exibindo os valores do vetor
            System.out.println(vetor[i]);
        }

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

        // exibindo o vetor ordenado
        System.out.println(" ");
        System.out.println("Vetor ordenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}
