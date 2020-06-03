package TicTacToe;

import java.util.Scanner;

public class TicTacToeClass {
    private static int turns;

    public static final int ROWS = 3, COLS = 3; // number of rows and columns
    // Instance Variables; board with 3 columns, 3 rows
    private static char[][] board = new char[3][3];

    // Constructor
    public TicTacToeClass() {
        board = new char[3][3];
        turns = 0;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';

    }

    // Accessor Methods

    // initialize the board
    private static void initBoard() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';// This makes all 9 squares empty
    }

    // Displays the board
    public static void displayBoard() {
        System.out.println("Turn #" + turns + ": ");

        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // returns true if the letter passed in currently has three in a row
    static boolean isWinner(char p) {
        for (int r = 0; r < 3; r++)
        // check for horizontal win
        {
            // if Row values are the same, return true
            if (p == board[r][0] && board[r][0] == board[r][1] && board[r][1] == board[r][2])
                return true;
        }

        // check vertical win
        for (int c = 0; c < 3; c++) {
            // If Column values are the same; return true
            if (p == board[0][c] && board[0][c] == board[1][c] && board[1][c] == board[2][c])
                return true;
        }

        // check diagonal win
        if (p == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        else if (p == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;

        return false;
    }

    // returns true if nine turns have been played and false otherwise
    public static boolean isFull() {
        if (turns == 9) {
            return true;
        } else {
            return false;
        }
    }

    // Returns true if all nine spaces are filled AND neither X nor O has won
    public boolean isCat() {
        if ((turns == 9) && !isWinner('X') && !isWinner('O')) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if space is valid
    public static boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2)
            return true;
        else
            return false;
    }

    // Returns number of turns played so far
    public int numTurns() {
        return turns;
    }

    // Returns the character: 0, x, 0
    public static char playerAt(int r, int c) {
        if (isValid(r, c))
            return board[r][c];
        else
            return '@';
    }

    // Modifiers
    public static void playMove(char p, int r, int c) {
        board[r][c] = p;
        turns++; // increment number of turns each time

    }
}