import java.util.IllegalFormatException;

/**
 * Created by Rohan D'Souza on 4/8/2016.
 */
public class Board {
    public String[][] board;

    public Board() {
        this.board = null;
    }
    public Board(String[][] board) {
        if (board == null || board[0] == null) {
            this.board = null;
        }
        else {
            String[][] temp = new String[board.length][board[0].length];
            for (int boardIndex = 0; boardIndex < board.length; boardIndex++) {
                for (int board2Index = 0; board2Index < board[0].length; board2Index++) {
                    temp[boardIndex][board2Index] = board
                }
            }
        }
    }
}