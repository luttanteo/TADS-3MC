package bar;

import atendimento.Atendimento;

public class Bar {
    public static void main(String[] args) {
        Thread cliente1 = new Thread(new Atendimento("mesa 1"));
        Thread cliente2 = new Thread(new Atendimento("mesa 2"));
        Thread cliente3 = new Thread(new Atendimento("mesa 3"));

        cliente1.start();
        cliente2.start();
        cliente3.start();
    }
}
