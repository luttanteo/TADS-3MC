import java.util.Scanner;

public class ExercicioInfra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = -1;
        int n2 = -1;

        System.out.println("Soma de 2 números (entre 0 e 100)");
        while (n1 < 0 || n1 > 100) {
            System.out.print("Digite um número entre 0 e 100: ");
            if (scanner.hasNextInt()) {
                n1 = scanner.nextInt();
                if (n1 < 0 || n1 > 100) {
                    System.out.println("O número deve estar entre 0 e 100.");
                }
            } else {
                System.out.println("Entrada inválida! Tente novamente.");
                scanner.next();
            }
        }

        while (n2 < 0 || n2 > 100) {
            System.out.print("Digite um segundo número entre 0 e 100: ");
            if (scanner.hasNextInt()) {
                n2 = scanner.nextInt();
                if (n2 < 0 || n2 > 100) {
                    System.out.println("O número deve estar entre 0 e 100.");
                }
            } else {
                System.out.println("Entrada inválida! Tente novamente.");
                scanner.next();
            }
        }

        int soma = n1 + n2;
        System.out.println("Resultado da soma: " + soma);

        scanner.close();
    }
}
