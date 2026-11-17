package BatalhaNaval.model;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

    private final int TAMANHO = 10;

    private final char[][] matriz;
    private final List<Navio> navios;

    private final Navio[][] ocupacao;
    private boolean[][] tirosRecebidos;

    public Tabuleiro() {

        matriz = new char[TAMANHO][TAMANHO];

        ocupacao = new Navio[TAMANHO][TAMANHO];

        tirosRecebidos = new boolean[TAMANHO][TAMANHO];

        navios = new ArrayList<>();

        inicializar();
    }

    private void inicializar() {

        for (int i = 0; i < TAMANHO; i++) {

            for (int j = 0; j < TAMANHO; j++) {

                matriz[i][j] = '~';
                ocupacao[i][j] = null;
                tirosRecebidos[i][j] = false;

            }
        }
    }

    public boolean posicionarNavio(
            Navio navio,
            Coordenada inicio,
            boolean horizontal) {

        int linha = inicio.getLinha();
        int coluna = inicio.getColuna();

        // Verifica se o navio cabe no tabuleiro.

        for (int i = 0; i < navio.getTamanho(); i++) {

            int l = linha + (horizontal ? 0 : i);
            int c = coluna + (horizontal ? i : 0);

            if (l < 0 || l >= TAMANHO ||
                c < 0 || c >= TAMANHO) {

                return false;
            }

            // Verifica se a posição já está ocupada.

            if (ocupacao[l][c] != null) {
                return false;
            }
        }

        // Se todas as posições forem válidas, posiciona.

        for (int i = 0; i < navio.getTamanho(); i++) {

            int l = linha + (horizontal ? 0 : i);
            int c = coluna + (horizontal ? i : 0);

            matriz[l][c] = 'N';
            ocupacao[l][c] = navio;
        }

        navios.add(navio);

        return true;
    }

    public ResultadoTiro receberTiro(Coordenada coordenada) {

        int linha = coordenada.getLinha();
        int coluna = coordenada.getColuna();

        if (!dentroDoTabuleiro(linha, coluna)) {
            throw new IllegalArgumentException(
                "Coordenada fora do tabuleiro."
            );
        }

        if (tirosRecebidos[linha][coluna]) {
            return ResultadoTiro.REPETIDO;
        }

        tirosRecebidos[linha][coluna] = true;

        if (ocupacao[linha][coluna] != null) {

            matriz[linha][coluna] = 'X';

            ocupacao[linha][coluna].receberDano();

            return ResultadoTiro.ACERTO;
        }

        matriz[linha][coluna] = 'O';

        return ResultadoTiro.AGUA;
    }

    public boolean dentroDoTabuleiro(int linha, int coluna) {

        return linha >= 0 && linha < TAMANHO &&
               coluna >= 0 && coluna < TAMANHO;
    }

    public boolean jaFoiAtacado(int linha, int coluna) {

        return dentroDoTabuleiro(linha, coluna)
                && tirosRecebidos[linha][coluna];
    }

    public boolean todosAfundados() {

        if (navios.isEmpty()) {
            return false;
        }

        for (Navio navio : navios) {

            if (!navio.estaAfundado()) {
                return false;
            }
        }

        return true;
    }

    public void exibir(boolean mostrarNavios) {

        System.out.print("   ");

        for (int i = 0; i < TAMANHO; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < TAMANHO; i++) {

            System.out.printf("%2d ", i);

            for (int j = 0; j < TAMANHO; j++) {

                char simbolo = matriz[i][j];

                // Esconde os navios quando necessário.

                if (!mostrarNavios && simbolo == 'N') {
                    simbolo = '~';
                }

                System.out.print(simbolo + " ");
            }

            System.out.println();
        }
    }
}