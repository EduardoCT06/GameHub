package Sudoku;
import java.util.Scanner;

public class Main {
	public static int lerNumero(Scanner entrada) {

	    while (!entrada.hasNextInt()) {

	        System.out.println("Entrada inválida! Digite apenas números.");

	        entrada.next();

	    }

	    return entrada.nextInt();
	}
	
	
	public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        
        

        tabuleiro.exibirTabuleiro();
        
        boolean jogando = true;
        
       while (jogando && !tabuleiro.verificarVitoria()) {
        	System.out.println("===== MENU SUDOKU =====");
        	System.out.println("1 - Inserir número");
        	System.out.println("2 - Remover número");
        	System.out.println("3 - Sair do jogo");
        	System.out.println("Escolha uma opção: ");

        	int opcao = lerNumero(entrada);
        	
        	switch (opcao) {

            case 1:{
                System.out.println("Inserir número");
                
                System.out.println("Digite a linha (0 a 8): ");
                int linha = lerNumero(entrada);
                System.out.println("Digite a coluna (0 a 8): ");
                int coluna = lerNumero(entrada);

                System.out.println("Digite o número (1 a 9): ");
                int numero = lerNumero(entrada);

                if (tabuleiro.inserirNumero(linha, coluna, numero)) {
                    System.out.println("Número inserido com sucesso!");
                } else {
                    System.out.println("Jogada inválida!");
                }
                
                break;
            }
            case 2:{

                System.out.println("Digite a linha (0 a 8): ");
                int linha = lerNumero(entrada);

                System.out.println("Digite a coluna (0 a 8): ");
                int coluna = lerNumero(entrada);

                if (tabuleiro.removerNumero(linha, coluna)) {
                    System.out.println("Número removido com sucesso!");
                } else {
                    System.out.println("Não foi possível remover o número!");
                }

                break;
            }
            
            case 3: {
			    System.out.println("Saindo do jogo...");
			    jogando = false;
			    break;
			}

            default:
                System.out.println("Opção inválida!");
                break;
        }
        	if (jogando) {
        		tabuleiro.exibirTabuleiro();
        	}
        	

            
            
        }
       if (tabuleiro.verificarVitoria()) {
    	    System.out.println("Parabéns! Você venceu o Sudoku!");
    	}
        
        entrada.close();
    }
}
