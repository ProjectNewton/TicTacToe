/**
 * Created by Rohan D'Souza on 4/8/2016.
 */
public class Board {
    /**
     * <p><code>board</code> is a 2 dimensional array represented in by
     * a <code>[row][col]</code> configuration</p>
     */
    private String[][] board;
    //public static final String Player1 = "X";
    //public static final String Player2 = "Y";

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
                    temp[boardIndex][board2Index] = board[boardIndex][board2Index];
                }
            }
            this.board = temp;
        }
    }
    public Board(int len) {
        this.board = new String[len][len];
    }

    public String[][] getBoard() {
        return board;
    }

    public void fill() {
        for (int boardIndex = 0; boardIndex < board.length; boardIndex++) {
            for (int board2Index = 0; board2Index < board[0].length; board2Index++) {
                board[boardIndex][board2Index] = " ";
            }
        }
    }

    /*public boolean isEmptyNotFilled() {
        return board == null;
    }*/
    public boolean isEmpty() {
        if (board == null) {
            return true;
        }
        for (int boardIndex = 0; boardIndex < board.length; boardIndex++) {
            for (int board2Index = 0; board2Index < board[0].length; board2Index++) {
                if (board[boardIndex][board2Index] == null || board[boardIndex][board2Index].equals("")
                    || board[boardIndex][board2Index].equals(" "))
                    return true;
            }
        }
        return false;
    }
    public boolean isEmpty(short num1, short num2) {
        return board[num1][num2] == null;
    }

    public void configureBoard(String val ,int row, int col) {
        if(row >= board.length || col >= board[0].length) {
            throw new ArrayIndexOutOfBoundsException("LOL. Are you Blind, That doesnt fit.");
        }
        board[row][col] = val.toUpperCase();
    }
    public Board setBoard(String val , int row, int col) {
        if(row >= board.length || col >= board[0].length) {
            throw new ArrayIndexOutOfBoundsException("LOL. Are you Blind, That doesnt fit.");
        }
        board[row][col] = val.toUpperCase();
        return new Board(board.clone());
    }

    @Override
    public Board clone() {
        return new Board(board.clone());
    }

    public boolean checkWin() {
        for (int i = 0; i < board.length; i++){
            if (checkHorizontal(i))
                return true;
            else if (checkVerticle(i))
                return true;
            else if (checkDiagonal())
                return true;
        }
        return false;
    }

    public boolean checkHorizontal(int row) {
        if (row >= board.length)
            return false;
        for (int col = 0; col < board[row].length-1; col++) {
            if (board[row][col].contains(" "))
                return false;
            if (!board[row][col].equals(board[row][col+1])) {return false;}
        }
        return true;
    }

    public boolean checkVerticle(int col) {
        if (col >= board.length)
            return false;
        for (int row = 0; row < board.length-1; row++) {
            if (board[row][col].contains(" "))
                return false;
            if (!board[row][col].equals(board[row+1][col])) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal() {
        for (int i = 0; i < board.length-1; i++) {
            if (board[i][i].contains(" "))
                return false;
            if (!board[i][i].equals(board[i+1][i+1]))
                return false;
        }
        for (int i = board.length; i > 0; i--) {
            if (board[i][i].contains(" "))
                return false;
            if (!board[i][i].equals(board[i-1][i-1]))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "\n";
        System.out.print(str);
        for (int row = 0; row<this.board.length; row++) {
            for (int col = 0; col < this.board.length; col++) {
                if (col==0) {
                    str = str + row + "  ";
                }
                else str = str + " ";
                str = str + (this.board[row][col]);
                if (col < this.board[0].length - 1) str = str + (" |");
                else str = str + "\n";
            }
            if (row < this.board.length - 1) str = str + ("  -----------\n");
        }
        str = str + ("\n   0   1   2\n\n");
        return str;
    }
}