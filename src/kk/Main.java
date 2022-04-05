package kk;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = new char[3][3];
		
		int moveCount = 0;
		
		char activePlayer = 'X';
				
		while(moveCount < 9) {
			Function.printBoard(board);
			if(Function.moveWasCorrect(board, activePlayer)) {	
				if(Function.checkWin(board, activePlayer)) break;
				moveCount++;				//zwiekszenie licznika ruchow										
				activePlayer = activePlayer == 'X' ? 'O' : 'X';	//zmiana znaku gracza
			}
			else 		System.out.println("Nieprawidowy ruch, powtorz");

		}
	}
}
