package projeto_temperatura;

import javax.swing.JOptionPane;

public class ProjetoTemperatura {
    public static void main(String[] args) {
        double[] temperatura = new double[7];
        double soma = 0;
        double media;
        int contador;
        int dias_acima = 0;
        int dias_abaixo = 0;

        for(contador = 0; contador < 7; contador++) {
            temperatura[contador] = Double.parseDouble(JOptionPane.showInputDialog("Digite a " + (contador + 1) + "º temperatura: "));
            soma = soma + temperatura[contador];
        }

        media = soma / 7;

        for(contador = 0; contador < 7; contador ++) {
            if(temperatura[contador] > media) { // se a temperatura for acima da média...
                dias_acima++; // o contador de "dias acima" aumenta
            }
            if(temperatura[contador] < media) { // se a temperatura for abaixo da média...
                dias_abaixo++; // o contador de "dias abaixo" aumenta
            }
        }

        JOptionPane.showMessageDialog(null, "A média das temperaturas é: " + media); // mostra pop-up bonitinho
        JOptionPane.showMessageDialog(null, "A quantidade de dias com temperaturas acima da média é: " + dias_acima); // mostra pop-up bonitinho
        JOptionPane.showMessageDialog(null, "A quantidade de dias com temperaturas abaixo da média é: " + dias_abaixo); // mostra pop-up bonitinho
    }
}