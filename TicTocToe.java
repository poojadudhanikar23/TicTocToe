package project;

import java.util.Scanner;

public class TicTocToe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Game board 
        char[] board = {'1','2','3','4','5','6','7','8','9'};

        char player = 'X';
        int move;
        boolean gameOver = false;

        while (!gameOver) {

            // Print board
            System.out.println();
            System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
            System.out.println("-----------");
            System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
            System.out.println("-----------");
            System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);

            System.out.println("\nPlayer " + player + ", choose position (1-9): ");
            move = sc.nextInt();

            // Check valid input
            if (move < 1 || move > 9) {
                System.out.println("❌ Enter number between 1 and 9 only!");
                continue;
            }

            // Place move
            if (board[move - 1] != 'X' && board[move - 1] != 'O') {
                board[move - 1] = player;
            } else {
                System.out.println("❌ Position already taken!");
                continue;
            }

            // Win check
            if (
                (board[0]==player && board[1]==player && board[2]==player) ||
                (board[3]==player && board[4]==player && board[5]==player) ||
                (board[6]==player && board[7]==player && board[8]==player) ||
                (board[0]==player && board[3]==player && board[6]==player) ||
                (board[1]==player && board[4]==player && board[7]==player) ||
                (board[2]==player && board[5]==player && board[8]==player) ||
                (board[0]==player && board[4]==player && board[8]==player) ||
                (board[2]==player && board[4]==player && board[6]==player)
            ) {
                System.out.println("🎉 Player " + player + " Wins!");
                gameOver = true;
            }

            // Change player
            player = (player == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}
