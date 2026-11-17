package GameHub;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Forca.Forca;
import Forca.services.LimpaTela;
import JogoDaVelha.JogoDaVelha;
import BatalhaNaval.BatalhaNaval;
import Sudoku.Sudoku;

public class GameHubMenu {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException, IOException {
		desenharMenu();
		while (true) {
			menuPrincipal();
			int opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				Forca.forca();
				break;
			case 2:
				JogoDaVelha.jogar();
				break;
				case 3:
					Sudoku.jogar();
			case 4:
				BatalhaNaval.jogar();
				break;
			}
			TimeUnit.SECONDS.sleep(2);
			LimpaTela.limparConsole();
			fimDeJogo();
			char decisao = sc.next().charAt(0);
			if (decisao == 'n') {
				break;
			}
		}
	}

	public static void desenharMenu() throws InterruptedException, IOException {
		System.out.println("""
				▄░▀▀▀░  ░▀▀▀░▄  				        """);
		TimeUnit.MILLISECONDS.sleep(400);
		LimpaTela.limparConsole();
		System.out.println("""
				▄░▀▀▀░  ░▀▀▀░▄    ▄░▒░▄░▒░▄  ▀░░▀▀░
								        """);
		TimeUnit.MILLISECONDS.sleep(400);
		LimpaTela.limparConsole();

		System.out.println("""
				▄░▀▀▀░  ░▀▀▀░▄    ▄░▒░▄░▒░▄  ▀░░▀▀░ ▀░░▀ ▀░░▀ ▀▓▓▀  ▀▓▓▀ ▀▓▓▀▀▓▄
				▒▒            ▓▓   ▒▒▀ ▒ ▀▒▒   ▒▒     ▒▒   ▒▒   ▒▒    ▒▒   ▒▒   ▒▀
								        """);
		TimeUnit.MILLISECONDS.sleep(400);
		LimpaTela.limparConsole();

		System.out.println("""
				▄░▀▀▀░  ░▀▀▀░▄    ▄░▒░▄░▒░▄  ▀░░▀▀░ ▀░░▀ ▀░░▀ ▀▓▓▀  ▀▓▓▀ ▀▓▓▀▀▓▄
				▒▒            ▓▓   ▒▒▀ ▒ ▀▒▒   ▒▒     ▒▒   ▒▒   ▒▒    ▒▒   ▒▒   ▒▀
				▄▄ ▄▄▄▄   ▄▄▄▄▄▄   ▄▄  ▄  ▄▄   ▄▄     ▄▄▄▄▄▄▄   ▄▄    ▄▄   ▄▄ ▄▄▄
				▓▓   ▓▓ ▄▓▀   ▓▓   ▓▓  ▒  ▓▓   ▓▓     ▓▓   ▓▓   ▓▓    ▓▓   ▓▓  ▀▓▄
				▒▒   ▒▒ ▒▒    ▒▒   ▒▒  ░  ▒▒   ▒▒▄█   ▒▒   ▒▒   ▒▒    ▒▒   ▒▒   ▒▒
				░░   ░░ ░░    ░░   ░░     ░░   ░░ ▀   ░░   ░░   ░░    ░░   ░░   ░░
								        """);
		TimeUnit.SECONDS.sleep(1);
		LimpaTela.limparConsole();

		System.out.println("""
				▄░▀▀▀░  ░▀▀▀░▄    ▄░▒░▄░▒░▄  ▀░░▀▀░ ▀░░▀ ▀░░▀ ▀▓▓▀  ▀▓▓▀ ▀▓▓▀▀▓▄
				▒▒            ▓▓   ▒▒▀ ▒ ▀▒▒   ▒▒     ▒▒   ▒▒   ▒▒    ▒▒   ▒▒   ▒▀
				▄▄ ▄▄▄▄   ▄▄▄▄▄▄   ▄▄  ▄  ▄▄   ▄▄     ▄▄▄▄▄▄▄   ▄▄    ▄▄   ▄▄ ▄▄▄
				▓▓   ▓▓ ▄▓▀   ▓▓   ▓▓  ▒  ▓▓   ▓▓     ▓▓   ▓▓   ▓▓    ▓▓   ▓▓  ▀▓▄
				▒▒   ▒▒ ▒▒    ▒▒   ▒▒  ░  ▒▒   ▒▒▄█   ▒▒   ▒▒   ▒▒    ▒▒   ▒▒   ▒▒
				░░   ░░ ░░    ░░   ░░     ░░   ░░ ▀   ░░   ░░   ░░    ░░   ░░   ░░
				██   ██ ██    ██   ██     ██   ██     ██   ██   ██    ██   ██   ██
				██   ██ ██    ██   ██     ██   ██     ██   ██   ██    ██   ██   ██
				░█   ░█ ░█    ░█   ░█     ░█   ░█     ░█   ░█   ░█    ░█   ░█   ░█
				░█   ░█ ░█    ░█   ░█     ░█   ░█     ░█   ░█   ░█    ░█   ░█   ░█
				▀█▄▄░▒  ▀█▄▄▄░█▄ ▄██▄   ▄██▄ ▄░█▄▄░ ▄██▄ ▄██▄   ▀█▄▄░▀   ▄░█▄▄█▀
								        """);
				TimeUnit.SECONDS.sleep(2);
	}

	public static void fimDeJogo() throws InterruptedException {
		System.out.println(
				"""
						████████╗  ██████╗██████████╗████████╗           ████╗  ████╗    ██████╗  ████╗           ████╗    ██████╗  ████╗  ██████╗    ████╗  ██╗   ██╗
						██╔═════╝██╔═════╝╚═══██╔═══╝██╔═════╝           ╚═██║██╔═══██╗██╔═════╝██╔═══██╗       ██╔═══██╗██╔═════╝██╔═══██╗██╔═══██╗██╔═══██╗██║   ██║
						██████╗  ╚═████╗      ██║    ██████╗               ██║██║   ██║██║ ████╗██║   ██║       ████████║██║      ████████║██████╔═╝██║   ██║██║   ██║
						██╔═══╝    ╚═══██╗    ██║    ██╔═══╝         ██╗   ██║██║   ██║██║ ╚═██║██║   ██║       ██╔═══██║██║      ██╔═══██║██╔═══██╗██║   ██║██║   ██║
						████████╗██████╔═╝    ██║    ████████╗       ╚═████╔═╝╚═████╔═╝╚═██████║╚═████╔═╝       ██║   ██║╚═██████╗██║   ██║██████╔═╝╚═████╔═╝╚═████╔═╝
						╚═══════╝╚═════╝      ╚═╝    ╚═══════╝         ╚═══╝    ╚═══╝    ╚═════╝  ╚═══╝         ╚═╝   ╚═╝  ╚═════╝╚═╝   ╚═╝╚═════╝    ╚═══╝    ╚═══╝

											""");
		TimeUnit.SECONDS.sleep(1);
		System.out.println(
				"""
						  ██████╗  ████╗    ██████╗██████████╗  ████╗  ██████╗  ██████╗  ████╗         ██████╗  ████████╗           ████╗  ████╗    ██████╗  ████╗  ██████╗         ██████╗  ████████╗██╗     ██╗  ████╗  ██╗     ██╗  ████╗  ██████╗
						██╔═════╝██╔═══██╗██╔═════╝╚═══██╔═══╝██╔═══██╗██╔═══██╗╚═██╔═╝██╔═══██╗       ██╔═══██╗██╔═════╝           ╚═██║██╔═══██╗██╔═════╝██╔═══██╗██╔═══██╗       ██╔═══██╗██╔═════╝████╗   ██║██╔═══██╗██║     ██║██╔═══██╗╚═════██╗
						██║ ████╗██║   ██║╚═████╗      ██║    ████████║██████╔═╝  ██║  ████████║       ██║   ██║██████╗               ██║██║   ██║██║ ████╗████████║██████╔═╝       ██║   ██║██████╗  ██╔═██╗ ██║██║   ██║██║     ██║██║   ██║  ████╔═╝
						██║ ╚═██║██║   ██║  ╚═══██╗    ██║    ██╔═══██║██╔═██║    ██║  ██╔═══██║       ██║   ██║██╔═══╝         ██╗   ██║██║   ██║██║ ╚═██║██╔═══██║██╔═██║         ██║   ██║██╔═══╝  ██║ ╚═████║██║   ██║╚═██╗ ██╔═╝██║   ██║  ╚═══╝
						╚═██████║╚═████╔═╝██████╔═╝    ██║    ██║   ██║██║ ╚═██╗██████╗██║   ██║       ██████╔═╝████████╗       ╚═████╔═╝╚═████╔═╝╚═██████║██║   ██║██║ ╚═██╗       ██████╔═╝████████╗██║   ╚═██║╚═████╔═╝  ╚═██╔═╝  ╚═████╔═╝  ██╗
						  ╚═════╝  ╚═══╝  ╚═════╝      ╚═╝    ╚═╝   ╚═╝╚═╝   ╚═╝╚═════╝╚═╝   ╚═╝       ╚═════╝  ╚═══════╝         ╚═══╝    ╚═══╝    ╚═════╝╚═╝   ╚═╝╚═╝   ╚═╝       ╚═════╝  ╚═══════╝╚═╝     ╚═╝  ╚═══╝      ╚═╝      ╚═══╝    ╚═╝


											""");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("s/n:");
	}

	public static void menuPrincipal() {
		System.out.println("""
Escolha seu jogo
Digite:

1 - Jogo da Forca
2 - Jogo da Velha
3 - Sudoku
4 - Batalha Naval

Digite sua escolha:""");

	}
}
