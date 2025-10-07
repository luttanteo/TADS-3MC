package projeto_estrutura_estatica;

public class Teste2 {
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<Integer>();

        fila.enfileira(1);
        fila.enfileira(2);
        fila.enfileira(3);

        System.out.println("A fila está vazia? " + fila.estaVazia());
        System.out.println("Qual o tamanho da fila? " + fila.tamanho());
        System.out.println(fila.toString());

        System.out.println(fila.espiar());

        if(fila.espiar() == null) {
            System.out.println("Fila vazia.");
        } else {
            System.out.println("O elemento na primeira posição é: " + fila.espiar());
        }

        System.out.println(fila.toString());
        System.out.println(fila.desenfileira());
        System.out.println(fila.toString());
    }
}
