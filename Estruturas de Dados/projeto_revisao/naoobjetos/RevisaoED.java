package projeto_revisao.naoobjetos;

public class RevisaoED {
    public static void main(String[] args) {
        double[] temperatura = new double[365];
        temperatura[0] = 25.7;
        temperatura[1] = 27.4;
        temperatura[2] = 29.3;
        temperatura[3] = 31.4;
        temperatura[4] = 30.2;
        temperatura[5] = 29.6;

        System.out.println("O valor da temperatura do dia 3 é: " + temperatura[2]);
        System.out.println("O tamanho do vetor é: " + temperatura.length);

        for (int i = 0; i < temperatura.length; i++) {
            System.out.println("O valor da temperatura do dia " + (i + 1) + " é " + temperatura[i]);
        }

        for (double temp : temperatura) {
            System.out.println(temp);
        }
    }
}
