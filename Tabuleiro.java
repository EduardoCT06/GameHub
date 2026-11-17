
package sudoku1;

public class Tabuleiro {
	
	public boolean inserirNumero(int linha, int coluna, int numero) {

	    
	    if (linha < 0 || linha > 8 || coluna < 0 || coluna > 8) {
	        return false;
	    }

	    
	    if (posicaoFixa(linha, coluna)) {
	        return false;
	    }

	    
	    if (grade[linha][coluna] != 0) {
	        return false;
	    }

	    
	    if (!jogadaValida(linha, coluna, numero)) {
	        return false;
	    }

	    
	    grade[linha][coluna] = numero;

	    return true;
	}
	
	public boolean removerNumero(int linha, int coluna) {

	    
	    if (linha < 0 || linha > 8 || coluna < 0 || coluna > 8) {
	        return false;
	    }

	    
	    if (posicaoFixa(linha, coluna)) {
	        return false;
	    }

	    
	    if (grade[linha][coluna] == 0) {
	        return false;
	    }

	    
	    grade[linha][coluna] = 0;

	    return true;
	}
	public Tabuleiro() {
	    copiarGradeOriginal();
	}
	private void copiarGradeOriginal() {

	    for (int i = 0; i < 9; i++) {

	        for (int j = 0; j < 9; j++) {

	            original[i][j] = grade[i][j];

	        }
	    }
	}
	public boolean posicaoFixa(int linha, int coluna) {

	    return original[linha][coluna] != 0;

	}
	

public boolean verificarLinha(int linha, int numero) {

    for (int j = 0; j < 9; j++) {

        if (grade[linha][j] == numero) {
            return false;
        }

    }

    return true;
}

	

public boolean verificarColuna(int coluna, int numero) {

    for (int i = 0; i < 9; i++) {

        if (grade[i][coluna] == numero) {
            return false;
        }

    }

    return true;
}

	

public boolean verificarBloco(int linha, int coluna, int numero) {

    int inicioLinha = (linha / 3) * 3;
    int inicioColuna = (coluna / 3) * 3;

    for (int i = inicioLinha; i < inicioLinha + 3; i++) {

        for (int j = inicioColuna; j < inicioColuna + 3; j++) {

            if (grade[i][j] == numero) {
                return false;
            }

        }

    }

    return true;
}


public boolean jogadaValida(int linha, int coluna, int numero) {
	
	if (linha < 0 || linha > 8 ||
		    coluna < 0 || coluna > 8) {

		    return false;
	}
	
    if (numero < 1 || numero > 9) {
        return false;
    }

    if (!verificarLinha(linha, numero)) {
        return false;
    }

    if (!verificarColuna(coluna, numero)) {
        return false;
    }

    if (!verificarBloco(linha, coluna, numero)) {
        return false;
    }

    return true;
}

	
	
	private int[][] grade = {

        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}

    };
	private int[][] original = new int[9][9];

public void exibirTabuleiro() {

    System.out.println("    1 2 3   4 5 6   7 8 9");

    for (int i = 0; i < 9; i++) {

        if (i % 3 == 0) {
            System.out.println("  +-------+-------+-------+");
        }

        System.out.print((i + 1) + " | ");

        for (int j = 0; j < 9; j++) {

            if (grade[i][j] == 0) {
                System.out.print(". ");
            } else {
                System.out.print(grade[i][j] + " ");
            }

            if ((j + 1) % 3 == 0) {
                System.out.print("| ");
            }
        }

        System.out.println();
    }

    System.out.println("  +-------+-------+-------+");
}

public boolean verificarVitoria() {

    for (int i = 0; i < 9; i++) {

        for (int j = 0; j < 9; j++) {

            if (grade[i][j] == 0) {
                return false;
                
            }
            int numero = grade[i][j];
            grade[i][j] = 0;
            boolean valido = jogadaValida(i, j, numero);
            grade[i][j] = numero;
            if (!valido) {
                return false;
            }
        }

    }
    
    
    return true;
}
public void carregarSolucaoTeste() {
    int[][] solucao = {
    	{5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    grade = solucao;
}
}
