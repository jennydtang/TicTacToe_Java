package TicTacToe;

import java.util.Scanner;

public class TicTacToeClass {
    public static final int EMPTY = 0;
    private int turns;
    // static final int X = 1;
    // static final int Y = 2;
    public static final int ROWS = 3, COLS = 3; // number of rows and columns
    // Instance Variables; board with 3 columns, 3 rows
    private static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // Two players: X and O
        char player1 = 'X', player2 = 'O';
        // Initialize turn
        int turns = 1;

        System.out.println("Let's Play Tic-Tac-Toe!");
        // Call the board and Display it
        initBoard();
        displayBoard();

        // Run this while there is not a winner and board is not full; "while playing"
        while (!(isWinner('X') || isWinner('O') || isFull())) {

            System.out.println("Turn #" + turns + ": ");
            if (turns % 2 != 0) {
                playerChoice(player1);
                turns++;
            } else {
                playerChoice(player2);
                turns++;
            }

            displayBoard(); // Display updated board after each turn

            // check for game end
            if (isWinner(player1)) {
                System.out.println("'" + player1 + "' wins the game!");
                break;
            } else if (isWinner(player2)) {
                System.out.println("'" + player2 + "' wins the game!");
                break;
                // If game has more than 9 turns, it is a tie
            } else if (turns > 9) {
                System.out.println("This game is a tie.");
                break;
            }

        }
    }

    // Accessor Methods
    private static void playerChoice(char p) {
        // Take user input to find rows and columns
        Scanner keyboard = new Scanner(System.in);
        int r, c;
        System.out.print("'" + p + "', choose your location (row, column): ");
        r = keyboard.nextInt();
        c = keyboard.nextInt();

        // If the spot is already taken/not valid, try again.
        // Currently exits game when invalid. Need to fix incrementing turns
        if (isValid(r, c) == false) {
            System.out.println("That is not a valid location. Try again.");
        } else if (playerAt(r, c) != ' ') {
            System.out.println("That location is already full. Try again.");
        }
        // Shows board after move
        board[r][c] = p;

        playMove(p, r, c);

    }

    // initialize the board
    private static void initBoard() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';// This makes all 9 squares empty
    }

    // Displays the board
    public static void displayBoard() {
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
        return false;
        // for (int r = 0; r < 3; r++) {
        // for (int c = 0; c < 3; c++) {
        // if (board[r][c] == EMPTY) {
        // return false;
        // }
        // }
        // }
        // return true;
    }

    // Returns true if all nine spaces are filled AND neither X nor O has won
    public boolean isCat() {
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (board[r][c] == EMPTY) {
                    return false; // an empty cell found, not draw, exit
                }
            }
        }
        return true;
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
        // switch turns
        if (p == 'X')
            p = 'O';
        else
            p = 'X';

    }
}