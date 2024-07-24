package abstractionbutnotconcretion;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Board board=new Board(3);//create a 3*3 board

        //create Players
        Iplayer humanPlayer=new HumanPlayer('X',board);
        Iplayer computerPlayer=new ComputerPlayer('O',board);

        Round round=new Round(humanPlayer,computerPlayer);

        boolean isHumanTurn=true;

        while (!isGameOver(board)) {
            // Print current board state
           // printBoard(board);

            // Determine whose turn it is
            if (isHumanTurn) {
                System.out.println("Human player's turn (symbol: 'X')");
                round.move(true);
            } else {
                System.out.println("Computer player's turn (symbol: 'O')");
                round.move(false);
            }
            isHumanTurn = !isHumanTurn;
        }
        // Game over, print final board state
        printBoard(board);

// Determine the winner or if it's a draw
        char winner = checkWinner(board);
        if (winner == ' ') {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player with symbol '" + winner + "' wins!");
        }

        scanner.close();

    }
    public static void printBoard(Board board) {
        for(int row=0;row<board.getSize();row++){
            for(int col=0;col<board.getSize();col++){
                System.out.println(board.getCell(row,col)+" ");
            }
            System.out.println();
        }

    }
    private static boolean isGameOver(Board board){
        return checkWinner(board)!=' '||isBoardFull(board);
    }

    private static boolean isBoardFull(Board board){
        for(int row=0;row<board.getSize();row++){
            for(int col=0;col<board.getSize();col++){
                if(board.getCell(row,col)==' '){
                    return false;
                }
            }
        }
        return true;
    }
    // Method to check if there is a winner
    private static char checkWinner(Board board) {
        // Check rows
        for (int row = 0; row < board.getSize(); row++) {
            if (board.getCell(row, 0) == board.getCell(row, 1) &&
                    board.getCell(row, 1) == board.getCell(row, 2) &&
                    board.getCell(row, 0) != ' ') {
                return board.getCell(row, 0); // Found a winning row
            }
        }

        // Check columns
        for (int col = 0; col < board.getSize(); col++) {
            if (board.getCell(0, col) == board.getCell(1, col) &&
                    board.getCell(1, col) == board.getCell(2, col) &&
                    board.getCell(0, col) != ' ') {
                return board.getCell(0, col); // Found a winning column
            }
        }

        // Check diagonals
        if (board.getCell(0, 0) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 2) &&
                board.getCell(0, 0) != ' ') {
            return board.getCell(0, 0); // Found a winning diagonal (top-left to bottom-right)
        }

        if (board.getCell(0, 2) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 0) &&
                board.getCell(0, 2) != ' ') {
            return board.getCell(0, 2); // Found a winning diagonal (top-right to bottom-left)
        }

        return ' '; // No winner yet
    }
}


