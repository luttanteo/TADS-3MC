package ado_bibliotecas;

import java.util.Scanner;

public class TestaBiblioteca {
    public static void main(String[] args) throws Exception {
        VetorBiblioteca biblioteca = new VetorBiblioteca(50);
        Scanner scanner = new Scanner(System.in);
        boolean ligado = true;
        int escolha;

        while(ligado){
            System.out.println("Boas vindas à Biblioteca Central!");
            System.out.println("-----MENU-----");
            System.out.println("1 - Adicionar um livro ao seu acervo");
            System.out.println("2 - Adicionar um livro no início do seu acervo");
            System.out.println("3 - Remover um livro do seu acervo");
            System.out.println("4 - Verificar o tamanho do seu acervo");
            System.out.println("5 - Buscar um livro com base em sua posição");
            System.out.println("6 - Verificar a existência de um livro no seu acervo");
            System.out.println("7 - Verificar os livros do seu acervo");
            System.out.println("8 - Sair do programa");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do livro:");
                    String livro = scanner.next();
                    biblioteca.adicionaLivro(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome do livro:");
                    String livro2 = scanner.next();
                    biblioteca.adicionaInicio(0, livro2);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite a posição do livro no acervo (apenas números):");
                    int posicao = scanner.nextInt();
                    biblioteca.removeLivro(posicao);
                    if(posicao == 0) {
                        System.out.println("Livro removido com sucesso!");
                    }
                    break;
                case 4:
                    System.out.println("Quantidade de livros no acervo: " + biblioteca.tamanhoAcervo());
                    break;
                case 5:
                    System.out.println("Digite a posição escolhida (apenas números):");
                    int posicao2 = scanner.nextInt();
                    biblioteca.buscaLivro(posicao2);
                    System.out.println("Livro: " + biblioteca.buscaLivro(posicao2));
                    break;
                case 6:
                    System.out.println("Digite o nome do livro:");
                    String livro3 = scanner.next();
                    biblioteca.buscaConteudo(livro3);
                    break;
                case 7:
                    System.out.println("Livros do seu acervo: " + biblioteca);
                    break;
                case 8:
                    System.out.println("Saindo do programa...");
                    ligado = false;
                    break;
                default:
                    System.out.println("Entrada inválida! Tente novamente");
                    break;
            }
        }
    }
}