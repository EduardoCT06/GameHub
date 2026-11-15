package model;

import visualization.Tela;

public abstract class Jogador {

    private final String nome;
    private final Tabuleiro tabuleiro;

    public Jogador(String nome) {

        this.nome = nome;
        this.tabuleiro = new Tabuleiro();
    }

    public String getNome() {
        return nome;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract void posicionarNavios(Tela tela);

    protected Navio[] criarFrota() {

        return new Navio[] {
            new PortaAvioes(),
            new Encouracado(),
            new Cruzador(),
            new Contratorpedeiro(),
            new Submarino()
        };
    }

    public abstract Coordenada escolherTiro(
            Tela tela,
            Tabuleiro alvo
    );
}