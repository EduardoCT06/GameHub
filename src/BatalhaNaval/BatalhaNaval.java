package BatalhaNaval;

import BatalhaNaval.control.*;
import BatalhaNaval.model.*;
import BatalhaNaval.visualization.Tela;

public class BatalhaNaval {

    public static void main(String[] args) {
        jogar();
    }

    public static void jogar() {

        Tela tela = new Tela();

        tela.mostrarTitulo();

        int modoJogo = tela.lerModoJogo();

        Jogador[] jogadores =
            ConfiguradorPartida.criarJogadores(
                modoJogo,
                tela
            );

        Comunicador jogo = new Comunicador(
            jogadores[0],
            jogadores[1],
            tela
        );

        jogo.iniciar();
    }
}