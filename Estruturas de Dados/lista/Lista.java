package lista;

public class Lista {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        System.out.println("Tamanho da lista: " + lista.getTamanho());
        System.out.println(" ");

        lista.adiciona("Claudio");

        System.out.println(lista);
        System.out.println("Tamanho da lista: " + lista.getTamanho());
        System.out.println("Inicio da lista: " + lista.getInicio().getElemento());
        System.out.println("Fim da lista: " + lista.getFim().getElemento());
        System.out.println(" ");

        lista.adiciona("Camila");

        System.out.println(lista);
        System.out.println("Tamanho da lista: " + lista.getTamanho());
        System.out.println("Inicio da lista: " + lista.getInicio().getElemento());
        System.out.println("Fim da lista: " + lista.getFim().getElemento());
        System.out.println(" ");

        lista.adiciona("Ana");
        lista.adiciona("Mateo");
        lista.adiciona("Elias");
        lista.adiciona("João");

        System.out.println(lista);
        System.out.println("Tamanho da lista: " + lista.getTamanho());
        System.out.println("Inicio da lista: " + lista.getInicio().getElemento());
        System.out.println("Fim da lista: " + lista.getFim().getElemento());
        System.out.println(" ");

        lista.remover("Ana");
        System.out.println(lista);
        System.out.println("Tamanho da lista: " + lista.getTamanho());
        System.out.println("Inicio da lista: " + lista.getInicio().getElemento());
        System.out.println("Fim da lista: " + lista.getFim().getElemento());

        lista.buscar("Mateo");
    }
}
