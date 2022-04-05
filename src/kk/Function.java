package kk;

import java.util.Scanner;

public class Function {
	public static void printBoard(char[][] board) {
		int d = board.length;	//rozmiar tablicy
		
		System.out.print("  ");
		for( int i = 0; i < d; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for ( int row = 0; row < d; row++) {
			System.out.print(row + " ");
			for (int column = 0; column < d; column++) {
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean moveWasCorrect(char[][] board, char activePlayer) {
		System.out.println(activePlayer + " podaj nr wiersza");
		int row = checkNumber(new Scanner(System.in).nextInt());
		System.out.println(activePlayer + " podaj nr kolumny");
		int column = checkNumber(new Scanner(System.in).nextInt());
		
		if(board[row][column]==0) {							//sprawdzanie czy pole jest puste	
			board[row][column] = activePlayer;				//przypisanie znaku gracza do pola
			return true;
		}else {
			return false;
		}
	}
	

	public static int checkNumber(int n) {
			if (n<3 && n>=0) {
				return n;
			}else {
				System.out.println("Wartosc z poza zakresu 0-2");
				n = new Scanner(System.in).nextInt();
				checkNumber(n);
			}
			return n;
	}

	
	public static boolean checkWinColumns(char[][] board, char activePlayer) {
		for(int col=0; col<board.length; col++) {
			if(board[0][col]==activePlayer &&		
			   board[1][col]==activePlayer &&
			   board[2][col]==activePlayer) {
				System.out.println("Wygrana "+ activePlayer);
				printBoard(board);
				return true;
			}
		}
		return false;
	}
	public static boolean checkWinRows(char[][] board, char activePlayer) {
		for(int row=0; row<board.length; row++) {
			if(board[row][0]==activePlayer &&		
			   board[row][1]==activePlayer &&
			   board[row][2]==activePlayer) {
				System.out.println("Wygrana "+ activePlayer);
				printBoard(board);
				return true;
			}
		}
		return false;
	}
	public static boolean checkWinDiagonal(char[][] board, char activePlayer) {
			//col = row  przek¹tna
			if(board[0][0]==activePlayer &&		//poprawic
			   board[1][1]==activePlayer &&
			   board[2][2]==activePlayer) {
				System.out.println("Wygrana "+ activePlayer);
				printBoard(board);
				return true;
			}
		
		//col != row  przek¹tna
		if(board[2][0]==activePlayer &&			//poprawic
		   board[1][1]==activePlayer &&
		   board[0][2]==activePlayer) {
			System.out.println("Wygrana "+ activePlayer);
			printBoard(board);
			return true;
		}
		return false;
	}
	public static boolean checkWin(char[][] board, char activePlayer){
		if(checkWinColumns(board, activePlayer) ||
		   checkWinRows(board, activePlayer)||
		   checkWinDiagonal(board, activePlayer)) {
			return true;
		}else return false;
	}
}
