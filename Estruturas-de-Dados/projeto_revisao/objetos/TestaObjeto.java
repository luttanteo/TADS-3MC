package projeto_revisao.objetos;

public class TestaObjeto {
    public static void main(String[] args) {
        VetorObjeto vetor = new VetorObjeto(5);

        Contato c1 = new Contato("Ana", "40028922", "ana@email.com");
        Contato c2 = new Contato("Lui", "20033006", "lui@email.com");
        Contato c3 = new Contato("Vitor", "50131350", "vitor@email.com");

        try{
            vetor.adiciona(c1);
            vetor.adiciona(c2);
            vetor.adiciona(c3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Quantidade de informações no vetor: " + vetor.tamanho());
        System.out.println("Conteúdo do vetor: " + vetor);
    }
}
