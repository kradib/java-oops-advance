package abstractionbutnotconcretion;
import java.util.Random;
public class ComputerPlayer implements Iplayer{

    private char symbol;
    private Board board;
    public ComputerPlayer(char symbol, Board board) {
        this.symbol = symbol;
        this.board=board;
    }

    @Override
    public void move() {
        Random random =new Random();
        int size=board.getSize();
        while(true){
            int row=random.nextInt(size);
            int col=random.nextInt(size);

            if(board.getCell(row,col)==' '){
                board.setCell(row,col,symbol);
                System.out.println("Computer placed"+symbol);
                break;
            }
        }
    }

}
