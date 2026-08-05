package arrays;


import java.util.Scanner;

public class TicTacToe {
	static char[][] board = new char[3][3];
	static char currentplayer = 'x';

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		initialiseBoard();
		while (true) {
			printBoard();
			System.out.println("Player " + currentplayer + " Enter row and columns ");
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			if (rows < 0 || cols < 0 || rows > 2 || cols > 2) {
				System.out.println("Invalid position try again");
				continue;
			}
			if (board[rows][cols] != ' ') {
				System.out.println("Cell already occupied with anither player...");
				continue;
			}
			board[rows][cols] = currentplayer;
			if (checkwin()) {
				printBoard() ;
				System.out.println(currentplayer + " Hey u won the game ");
				break;
			}
			if (boardFull()) {
				printBoard() ;
				System.out.println(" Tha game is over....");
				break;
			}
			switchplayer();

		}
	}

	private static void switchplayer() {
		currentplayer = currentplayer == 'x' ? 'O' : 'x';

	}

	static void initialiseBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	static void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	static boolean checkwin() {
		return checkrows() || checkcols() || checkdiag();
	}

	private static boolean checkdiag() {
		for (int j = 0; j < 3; j++) {
			if (board[0][0] == currentplayer && board[1][1] == currentplayer && board[2][2] == currentplayer) {
				return true;
			}
			if (board[0][2] == currentplayer && board[1][1] == currentplayer && board[2][0] == currentplayer) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkcols() {
		for (int j = 0; j < 3; j++) {
			if (board[0][j] == currentplayer && board[1][j] == currentplayer && board[2][j] == currentplayer) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkrows() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == currentplayer && board[i][1] == currentplayer && board[i][2] == currentplayer) {
				return true;
			}

		}
		return false;
	}

	static boolean boardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}