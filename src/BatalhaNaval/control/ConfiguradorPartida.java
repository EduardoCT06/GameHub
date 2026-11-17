package BatalhaNaval.control;

import BatalhaNaval.model.*;
import BatalhaNaval.visualization.Tela;

public class ConfiguradorPartida {

    public static Jogador[] criarJogadores(
            int modo,
            Tela tela) {

        Jogador jogador1;
        Jogador jogador2;

        switch (modo) {

            case 1 -> {
                jogador1 = new JogadorHumano(
                        tela.lerNome()
                );

                jogador2 = new JogadorHumano(
                        tela.lerNome()
                );
            }

            case 2 -> {
                jogador1 = new JogadorHumano(
                        tela.lerNome()
                );

                jogador2 = new JogadorBot("Computador");
            }

            case 3 -> {
                jogador1 = new JogadorBot("Bot 1");

                jogador2 = new JogadorBot("Bot 2");
            }

            default -> throw new IllegalArgumentException(
                    "Modo de jogo invalido."
                );
        }

        return new Jogador[] {
            jogador1,
            jogador2
        };
    }
}