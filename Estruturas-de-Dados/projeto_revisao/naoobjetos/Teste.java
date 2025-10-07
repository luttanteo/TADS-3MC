package projeto_revisao.naoobjetos;

public class Teste {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(5);

        vetor.adiciona("Elemento 1");
        vetor.adiciona("Elemento 2");
        vetor.adiciona("Elemento 3");
        vetor.adiciona("Elemento 4");
        vetor.adiciona("Elemento 5");
        vetor.adiciona("Elemento 6");
        vetor.adiciona("Elemento 7");

        System.out.println("Quantidade de informações no vetor: " + vetor.tamanho());
        System.out.println("Conteúdo do vetor: " + vetor);
        System.out.println("Informação armazenada no vetor na posição 1: " + vetor.busca(1));
        System.out.println("Buscar o endereço da informação Elemento 1: " + vetor.buscaConteudo("Elemento 1"));

        vetor.adicionaInicio(0, "Elemento 0");

        System.out.println(" ");
        System.out.println("Quantidade de informações no vetor: " + vetor.tamanho());
        System.out.println("Conteúdo do vetor: " + vetor);
        System.out.println("Informação armazenada no vetor na posição 1: " + vetor.busca(1));
        System.out.println("Buscar o endereço da informação Elemento 1: " + vetor.buscaConteudo("Elemento 1"));

        vetor.remove(3);

        System.out.println(" ");
        System.out.println("Quantidade de informações no vetor: " + vetor.tamanho());
        System.out.println("Conteúdo do vetor: " + vetor);
        System.out.println("Informação armazenada no vetor na posição 1: " + vetor.busca(1));
        System.out.println("Buscar o endereço da informação Elemento 3: " + vetor.buscaConteudo("Elemento 3"));

    }
}
