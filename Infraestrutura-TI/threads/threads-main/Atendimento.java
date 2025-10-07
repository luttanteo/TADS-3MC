package atendimento;

public class Atendimento implements Runnable {
    private String mesa;

    public Atendimento(String mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        System.out.println("Arrumar a " + mesa);
        System.out.println("Servir as bebidas na " + mesa);
        System.out.println("Servir as entradas na " + mesa);
        System.out.println("Servir os pratos na " + mesa);
    }
}
