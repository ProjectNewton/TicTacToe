package Players;

/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
import Game.Board;

public class AIbasic extends Player {

    private class Basic {
        private int numb, coor;
        private String letter;
        Basic(int numb, String letter, int col) {
            this.numb = numb;
            this.letter = letter;
            this.coor = col;
        }
        int getNumb() {return numb;}
        String getLetter() {return letter;}
        int getCoor() {return coor;}
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
        if (board.isEmpty(1,1) || board.isEmpty()) {
            return board.setBoard(getStr(),1,1);
        }
        Basic temp = null;
        for (int i = 0; i < board.getBoard().length; i++) {
            temp = checkRow(board, i);
            if (temp.getLetter().equals(getStr()) && temp.getNumb() == 2 && temp.getCoor()>-1) {
                return board.setBoard(getStr(), i, temp.getCoor());
            } else if ((!temp.getLetter().equals(getStr()) && temp.getNumb() == 2)  && temp.getCoor()>-1) {
                return board.setBoard(getStr(), i, temp.getCoor());
            }
        }
        for (int i = 0; i < board.getBoard().length; i++) {
            temp = checkCol(board, i);
            if (temp.getLetter().equals(getStr()) && temp.getNumb() == 2 && temp.getCoor()>-1) {
                return board.setBoard(getStr(), temp.getCoor(), i);
            } else if ((!temp.getLetter().equals(getStr()) && temp.getNumb() == 2)  && temp.getCoor()>-1) {
                return board.setBoard(getStr(), temp.getCoor(), i);
            }
        }
        return null;
    }

    private Basic checkRow(Board thing, int row) {
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

    private static int getCol(String[] strs, String letter) {
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(" ") && !strs[i].equals(letter)) {
                return i;
            }
        }
        return -1;
    }

    private Basic checkCol(Board thing, int col) {
        String[][] board = thing.getBoard();
        int num = 0;
        String str = "";
        int row = 0;
        for (int i = 0; i < board[0].length; i++) {
            int temp = 0;
            String tempStr = "";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][col].equals(" ")) {
                    break;
                } else if (board[i][col].equals(board[j][col])) {
                    tempStr = board[i][col];
                    temp += 1;
                }
            }
            if (temp > num) {
                num = temp;
                str = tempStr;
                row = getRow(board, col, str);
            }
        }
        return new Basic(num, str, row);
    }

    private static int getRow(String[][] board, int col, String letter) {
        for (int row = 0; row < board.length; row++) {
            if (!board[row][col].equals(letter)) {
                return row;
            }
        }
        return -1;
    }
}