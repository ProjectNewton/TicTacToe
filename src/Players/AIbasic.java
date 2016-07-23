package Players;

/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
import Game.Board;

public class AIbasic extends Player {

    public static class Basic {
        private int numb, col;
        private String letter;
        public Basic (int numb, String letter, int col) {
            this.numb = numb;
            this.letter = letter;
            this.col = col;
        }
        public int getNumb() {return numb;}
        public String getLetter() {return letter;}
        public int getCol() {return col;}
    }

    public AIbasic (String[] strs) {
        if (strs.length == 2) {
            System.out.println("This AI will have to be player " + strs[1]);
            str = strs[1];
            super.strings = new String[1];
            super.strings[0] = strs[0];
        }
        else if(strs.length == 1) {
            System.out.println("This AI will have to be player " + strs[0]);
            str = strs[0];
            strings = new String[0];
        }
        else {
            str = null;
            strings = null;
        }
    }

    @Override
    public Board play(Board board) {
        if (board.isEmpty()) {
            return board.setBoard(getStr(),1,1);
        }
        Basic temp = null;
        for (int i = 0; i < board.getBoard().length; i++) {
            temp = checkRow(board, i);
            if (temp.getLetter().equals(getStr()) && temp.getNumb() == 2) {
                return board.setBoard(getStr(), i, temp.getCol());
            } else if ((!temp.getLetter().equals(getStr()) && temp.getNumb() == 2)) {
                return board.setBoard(getStr(), i, temp.getCol());
            }
        }
        return null;
    }

    public static Basic checkRow(Board thing, int row) {
        String[][] board = thing.getBoard();
        int num = 0;
        String str = "";
        int col = 0;
        for (int i = 0; i < board.length; i++) {
            int temp = 0;
            String tempStr = "";
            for (int j = 0; j < board.length; j++) {
                if (board[row][i].equals(" ")) {
                    break;
                } else if (board[row][i].equals(board[row][j])) {
                    tempStr = board[row][i];
                    temp += 1;
                }
            }
            if (temp > num) {
                num = temp;
                str = tempStr;
                col = getCol(board[row], str);
            }
        }
        return new Basic(num, str, col);
    }

    public static int getCol(String[] strs, String letter) {
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].equals(letter)) {
                return i;
            }
        }
        return -1;
    }

    public static int checkRowInnerLoop(String[][] board, int row, int i) {
        int temp = 0;
        for (int j = 0; j < board.length; j++) {
            if (board[row][i].equals(board[row][j])) {
                temp += 1;
            }
        }
        return temp;
    }

    public static int checkRowOuterLoop(String[][] board, int row) {
        int num = 0;
        for (int i = 0; i < board.length; i++) {
            int temp = 0;
            String tempStr = null;
            for (int j = 0; j < board.length; j++) {
                if (board[row][i].equals(board[row][j])) {
                    tempStr = board[row][i];
                    temp += 1;
                }
            }
            if (temp > num) {
                num = temp;
            }
        }
        return num;
    }














}