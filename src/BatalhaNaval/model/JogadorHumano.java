package BatalhaNaval.model;

import BatalhaNaval.visualization.Tela;

public class JogadorHumano extends Jogador {

    public JogadorHumano(String nome) {
        super(nome);
    }

    @Override
    public void posicionarNavios(Tela tela) {

        Navio[] frota = criarFrota();

        for (Navio navio : frota) {

            boolean posicionado = false;

            while (!posicionado) {

                tela.mostrarTabuleiro(
                    getTabuleiro(),
                    true
                );

                tela.mostrarMensagem(
                    "Posicione seu " + navio.getNome()
                    + " (tamanho: " + navio.getTamanho() + ")"
                );

                Coordenada inicio = tela.lerCoordenada();

                boolean horizontal = tela.lerOrientacao();

                posicionado = getTabuleiro().posicionarNavio(
                    navio,
                    inicio,
                    horizontal
                );

                if (!posicionado) {
                    tela.mostrarMensagem(
                        "Posicao invalida! Tente novamente."
                    );
                }
            }
        }
    }

    @Override
    public Coordenada escolherTiro(
            Tela tela,
            Tabuleiro alvo) {

        Coordenada tiro;

        do {

            tiro = tela.lerCoordenada();

            if (!alvo.dentroDoTabuleiro(
                    tiro.getLinha(),
                    tiro.getColuna())) {

                tela.mostrarMensagem(
                    "Coordenada fora do tabuleiro!"
                );

            } else if (alvo.jaFoiAtacado(
                    tiro.getLinha(),
                    tiro.getColuna())) {

                tela.mostrarMensagem(
                    "Voce ja atacou essa posicao!"
                );
            }

        } while (
            !alvo.dentroDoTabuleiro(
                tiro.getLinha(),
                tiro.getColuna()
            )
            ||
            alvo.jaFoiAtacado(
                tiro.getLinha(),
                tiro.getColuna()
            )
        );

        return tiro;
    }
}