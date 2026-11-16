package JogoDaVelha;

import java.util.Scanner;

public class Humano extends Jogador {
    public Humano(char simbolo) {
        super(simbolo);
    }

    @Override
    public int[] escolherJogada(Tabuleiro tabuleiro, Scanner scanner) {
        while (true) {
            System.out.print("Jogador " + simbolo + " (digite uma posicao de 1 a 9): ");
            int posicao = scanner.nextInt();
            if (posicao >= 1 && posicao <= 9) {
                
                int linha = (posicao - 1) / 3;
                int coluna = (posicao - 1) % 3;

                if (tabuleiro.jogadaValida(linha, coluna)) {
                    return new int[]{linha, coluna};
                }
            }
            System.out.println("Jogada invalida. Tente novamente.");
        }
    }
}
