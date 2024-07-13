package abstractionbutnotconcretion;

public class Round {

    Player player1;
    Player player2;


    Iplayer iPlayer1;
    Iplayer iPlayer2;


    //this is instantiation with concrete class
    public Round(boolean player1IsHuman, boolean player2IsHuman, char player1symbol, char player2Symbol) {
        this.player1 = new Player(player1IsHuman, player1symbol);
        this.player2 = new Player(player2IsHuman, player2Symbol);
    }

    public Round(boolean player1IsHuman, char player1symbol, char player2Symbol) {
        if(player1IsHuman) {
            iPlayer1 = new HumanPlayer(player1symbol);
        } else {
            iPlayer2 = new ComputerPlayer(player2Symbol);
        }
    }

    //this is abstraction + injection
    public Round(Iplayer iPlayer1,Iplayer iPlayer2) {
        this.iPlayer1 = iPlayer1;
        this.iPlayer2 = iPlayer2;
    }


    //this is injection
    public Round(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public void move(boolean turn) {
        //turn is true for player 1, false for player 2
        if(turn) {
            iPlayer1.move();
        } else {
            iPlayer2.move();
        }
    }

    public void moveWithConcreteInstantiation(boolean turn) {
        //turn is true for player 1, false for player 2
        if(turn) {
            player1.move();
        } else {
            player2.move();
        }
    }



}
