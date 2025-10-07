package projeto_estrutura_estatica;

public class Main {
    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<Integer>();

//        for(int i = 1; i <= 10; i++) {
//            pilha.adiciona(i);
//        }

        System.out.println("Verifica se a pilha está vazia: " + pilha.estaVazia());
        System.out.println("Dados da pilha: " + pilha.toString());
        System.out.println("Quantidade de dados na pilha: " + pilha.tamanho());

        System.out.println(" ");

        System.out.println("Verifica se a pilha está vazia: " + pilha.estaVazia());
        System.out.println("Informação no topo da pilha: " + pilha.topo());

        pilha.adiciona(1);
        pilha.adiciona(2);
        pilha.adiciona(3);

        System.out.println("Verifica se a pilha está vazia: " + pilha.estaVazia());
        System.out.println("Informação no topo da pilha: " + pilha.topo());

        System.out.println(" ");

        System.out.println("Dados da pilha: " + pilha.toString());
        System.out.println("Quantidade de dados na pilha: " + pilha.tamanho());

        System.out.println(" ");

        System.out.println("Dados da pilha: " + pilha.toString());
        System.out.println("Quantidade de dados na pilha: " + pilha.tamanho());

        pilha.desempilha();

        System.out.println("Dados da pilha: " + pilha.toString());
        System.out.println("Quantidade de dados na pilha: " + pilha.tamanho());
    }
}
