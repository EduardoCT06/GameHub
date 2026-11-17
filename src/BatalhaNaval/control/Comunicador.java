package BatalhaNaval.control;

import BatalhaNaval.model.*;
import BatalhaNaval.visualization.Tela;

public class Comunicador {

    private final Jogador jogador1;
    private final Jogador jogador2;

    private final Tela tela;

    public Comunicador(Jogador jogador1,
                Jogador jogador2,
                Tela tela) {

        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tela = tela;
    }

    public void iniciar() {

        tela.mostrarMensagem(
            "Preparando os tabuleiros..."
        );

        jogador1.posicionarNavios(tela);
        jogador2.posicionarNavios(tela);

        tela.mostrarMensagem(
            "Todos os navios foram posicionados!"
        );

        executarPartida();
    }

    private void executarPartida() {

        Jogador atual = jogador1;
        Jogador adversario = jogador2;

        boolean terminou = false;

        while (!terminou) {

            tela.mostrarMensagem(
                "\nTurno de: " + atual.getNome()
            );

            tela.mostrarMensagem(
                "\nSeu tabuleiro:"
            );

            tela.mostrarTabuleiro(
                atual.getTabuleiro(),
                true
            );

            tela.mostrarMensagem(
                "\nTabuleiro adversario:"
            );

            tela.mostrarTabuleiro(
                adversario.getTabuleiro(),
                false
            );

            if (atual instanceof JogadorHumano) {

                tela.mostrarMensagem(
                    "\nEscolha a posicao para atacar:"
                );

            } else {

                tela.mostrarMensagem(
                    "\nO bot esta escolhendo uma posicao..."
                );
            }


            Coordenada tiro = atual.escolherTiro(
                tela,
                adversario.getTabuleiro()
            );

            ResultadoTiro resultado =
                adversario.getTabuleiro().receberTiro(tiro);

            switch (resultado) {

                case ACERTO -> tela.mostrarResultadoTiro(
                        atual.getNome(),
                        tiro.getLinha(),
                        tiro.getColuna(),
                        "ACERTOU UM NAVIO!"
                    );

                case AGUA -> tela.mostrarResultadoTiro(
                        atual.getNome(),
                        tiro.getLinha(),
                        tiro.getColuna(),
                        "AGUA!"
                    );

                case REPETIDO -> tela.mostrarMensagem(
                        "Posicao ja atacada."
                    );
            }


            if (adversario.getTabuleiro().todosAfundados()) {

                tela.mostrarMensagem(
                    "\nFIM DE JOGO!"
                );

                tela.mostrarMensagem(
                    "Vencedor: " + atual.getNome()
                );

                terminou = true;

            } else if(resultado == ResultadoTiro.AGUA) {

                Jogador auxiliar = atual;

                atual = adversario;

                adversario = auxiliar;
                
            }

            if (!terminou && atual instanceof JogadorHumano) {

                 tela.aguardarEnter();
            }
        }
    }

}