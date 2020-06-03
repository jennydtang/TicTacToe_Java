package TicTacToe;

import java.util.Scanner;

public class TicTacToeClass {
    // Instance Variables; board with 3 columns, 3 rows
    private static char[][] board = new char[3][3];
    private int turns;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // Two players: X and O
        char player1 = 'X', player2 = 'O';
        // Initialize turn
        int turn = 1;

        System.out.println("Let's Play Tic-Tac-Toe!");
        // Call the board and Display it
        initBoard();
        displayBoard();

        while (!(isWinner('X') || isWinner('O') || isFull())) {
            System.out.println("Turn #" + turn + ": ");
            if (turn % 2 != 0) {
                // Determine whose turn it is; player 1 will be odd turns; player 2 = even
                // turns(0,2,4,6)
                playerChoice(player1);
                turn++;
            } else {
                playerChoice(player2);
                turn++;
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
            } else if (turn > 9) {
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
                board[r][c] = ' ';
    }

    // returns true if the letter passed in currently has three in a row
    private static boolean isWinner(char p) {
        for (int r = 0; r < 3; r++)

        {
            if (p == board[r][0] && board[r][0] == board[r][1] && board[r][1] == board[r][2])
                return true;
        }

        // check vertical
        for (int c = 0; c < 3; c++) {
            if (p == board[0][c] && board[0][c] == board[1][c] && board[1][c] == board[2][c])
                return true;
        }

        // check diagonal
        if (p == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        else if (p == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;

        return false;
    }

    // returns true if nine turns have been played and false otherwise
    public static boolean isFull() {
        return false;
    }

    // Returns true if all nine spaces are filled AND neither X nor O has won
    public boolean isCat() {
        return false;
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

    // Displays the board
    public static void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public static void playMove(char p, int r, int c) {
        if (p == 'X')
            p = 'O';
        else
            p = 'X';

    }

}