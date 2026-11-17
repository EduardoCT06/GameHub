package BatalhaNaval.visualization;

import java.util.Scanner;
import BatalhaNaval.model.Coordenada;
import BatalhaNaval.model.Tabuleiro;

public class Tela {

    private final Scanner scanner;

    public Tela() {
        scanner = new Scanner(System.in);
    }

    public String lerNome() {

        System.out.print("Digite seu nome: ");

        return scanner.nextLine();
    }

    public int lerModoJogo() {

        int modoJogo;

        System.out.print("Escolha como deseja jogar: ");
        System.out.print("\n1 - Jogador x Jogador");
        System.out.print("\n2 - Jogador x Bot");
        System.out.print("\n3 - Bot x Bot");

        return modoJogo = Integer.parseInt(scanner.nextLine());

    }

    public void mostrarMensagem(String mensagem) {

        System.out.println(mensagem);
    }

    public void mostrarTitulo() {

        System.out.println("==============================");
        System.out.println("       BATALHA NAVAL");
        System.out.println("==============================");
    }

    public void mostrarTabuleiro(
            Tabuleiro tabuleiro,
            boolean mostrarNavios) {

        tabuleiro.exibir(mostrarNavios);
    }

    public Coordenada lerCoordenada() {

        int linha;
        int coluna;

        while (true) {

            try {

                System.out.print("Digite a linha (0-9): ");
                linha = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite a coluna (0-9): ");
                coluna = Integer.parseInt(scanner.nextLine());

                return new Coordenada(linha, coluna);

            } catch (NumberFormatException e) {

                System.out.println(
                    "Digite somente numeros inteiros!"
                );
            }
        }
    }

    public boolean lerOrientacao() {

        while (true) {

            System.out.print(
                "Orientacao (H = Horizontal / V = Vertical): "
            );

            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("H")) {
                return true;
            }

            if (resposta.equalsIgnoreCase("V")) {
                return false;
            }

            System.out.println(
                "Orientacao invalida! Digite H ou V."
            );
        }
    }

    public void mostrarResultadoTiro(String nome,
                                     int linha,
                                     int coluna,
                                     String resultado) {

        System.out.println(
            nome + " disparou na posicao ["
            + linha + "][" + coluna + "]"
        );

        System.out.println("Resultado: " + resultado);
    }

    public void encerrar() {

        scanner.close();
    }

    public void aguardarEnter() {

        System.out.println(
            "\nPressione ENTER para continuar..."
        );

        scanner.nextLine();

    }
}