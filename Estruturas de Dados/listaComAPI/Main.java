package listaComAPI;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();

        System.out.println("Tamanho da lista: " + lista.size());

        lista.add("Mateo");
        lista.add("Lutt");
        lista.add("Elias");

        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Início da lista: " + lista.getFirst());
        System.out.println("Fim da lista: " + lista.getLast());

        lista.remove("Lutt");

        System.out.println(" ");
        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Início da lista: " + lista.getFirst());
        System.out.println("Fim da lista: " + lista.getLast());

    }
}
