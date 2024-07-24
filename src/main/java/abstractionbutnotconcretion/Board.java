package abstractionbutnotconcretion;

public class Board {
    private char[][] board;
    private int size;


    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = ' ';

            }
        }
    }
        public int getSize() {
            return size;
        }
        public char getCell(int row,int col) {
            return board[row][col];
        }

        public void setCell(int row, int col, char symbol) {
            board[row][col] = symbol;
        }


}
