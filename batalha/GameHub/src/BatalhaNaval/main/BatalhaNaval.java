package BatalhaNaval;

import control.*;
import model.*;
import visualization.Tela;

public class BatalhaNaval {

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

        tela.encerrar();
    }
}
