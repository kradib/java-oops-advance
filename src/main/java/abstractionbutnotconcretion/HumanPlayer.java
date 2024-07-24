package abstractionbutnotconcretion;

import java.util.Scanner;

public class HumanPlayer implements Iplayer {

    public char symbol;
    private Board board;
    private Scanner scanner;
    public HumanPlayer(char symbol,Board board) {
        this.board=board;
        this.scanner=new Scanner(System.in);
        this.symbol = symbol;
    }

    @Override
    public void move() {
        System.out.println("Player with symbol"+symbol+"enter move");
        int row=scanner.nextInt();
        int col=scanner.nextInt();

        if(board.getCell(row,col)!=' '){
            System.out.println("Invalid move");
            return;
        }
        board.setCell(row,col,symbol);
    }
    public char getSymbol(){
        return symbol;
    }
}
