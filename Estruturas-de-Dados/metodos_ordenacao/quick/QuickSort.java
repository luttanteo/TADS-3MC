package metodos_ordenacao.quick;

public class QuickSort {

    public static void main(String[] args) {
        // vetor int de 10 posições
        int[] vetor = new int[10];

        // inserindo valores no vetor
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            // exibindo os valores do vetor
            System.out.println(vetor[i]);
        }

        // chamando o método para a ordenação
        ordenacao(vetor, 0, vetor.length - 1);

        // exibindo o vetor ordenado
        System.out.println(" ");
        System.out.println("Vetor ordenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
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
        int meio = (int) (esquerda + direita) / 2;
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
