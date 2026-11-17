package BatalhaNaval.model;

import java.util.Random;
import BatalhaNaval.visualization.Tela;

public class JogadorBot extends Jogador {

    private final Random random;

    public JogadorBot(String nome) {

        super(nome);

        random = new Random();
    }

    @Override
    public void posicionarNavios(Tela tela) {

        Navio[] frota = criarFrota();

        for (Navio navio : frota) {

            boolean posicionado = false;

            while (!posicionado) {

                int linha = random.nextInt(10);
                int coluna = random.nextInt(10);

                boolean horizontal = random.nextBoolean();

                Coordenada inicio = new Coordenada(
                    linha,
                    coluna
                );

                posicionado = getTabuleiro().posicionarNavio(
                    navio,
                    inicio,
                    horizontal
                );
            }
        }
    }

    @Override
    public Coordenada escolherTiro(
            Tela tela,
            Tabuleiro alvo) {

        int linha;
        int coluna;

        do {

            linha = random.nextInt(10);
            coluna = random.nextInt(10);

        } while (alvo.jaFoiAtacado(linha, coluna));

        return new Coordenada(linha, coluna);

    }
}