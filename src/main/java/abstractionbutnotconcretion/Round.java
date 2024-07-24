package abstractionbutnotconcretion;

public class Round {
    Iplayer iPlayer1;
    Iplayer iPlayer2;


    //this is instantiation with concrete class
    public Round(Iplayer iPlayer1,Iplayer iPlayer2) {
        this.iPlayer1=iPlayer1;
        this.iPlayer2=iPlayer2;
    }
    public void move(boolean turn) {
        //turn is true for player 1, false for player 2
        if(turn) {
            iPlayer1.move();
        } else {
            iPlayer2.move();
        }
    }




}
