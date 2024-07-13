package abstractionbutnotconcretion;

public class Player {

    private char symbol;

    private boolean isHuman;



    public Player(boolean isHuman, char symbol) {
        this.isHuman = isHuman;
        this.symbol = symbol;

    }

    void move() {
        if(isHuman) {
            //wait for the input
        } else {
            //computer makes
        }
    }




}
