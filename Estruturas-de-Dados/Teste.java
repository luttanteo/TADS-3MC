package projeto_revisao;

public class Teste {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(5);

        vetor.adiciona("Elemento 1");
        vetor.adiciona("Elemento 2");

        System.out.println("Quantidade de informações no vetor: " + vetor.tamanho());
        System.out.println("Conteúdo do vetor: " + vetor.toString());
        System.out.println("Informação armazenada no vetor na posição: " + vetor.busca(1));
        System.out.println("Buscar o endereço da informação Elemento 1: " + vetor.buscaConteudo("Elemento 1"));
    }
}
