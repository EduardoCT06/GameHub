package model;

public abstract class Navio {

    private final String nome;
    private final int tamanho;
    private int acertos;

    public Navio(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.acertos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void receberDano() {
        if (!estaAfundado()) {
            acertos++;
        }
    }

    public boolean estaAfundado() {
        return acertos >= tamanho;
    }
}