package Players;

/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
import Game.Board;

import java.util.*;

public class AIbasic extends Player {

    private class Basic {
        private int numb;
        private String letter;
        private int row, col;
        /**
         * @param numb is the number of times that the <code>letter</code> appears.
         * @param letter is the <code>String</code> that appears the most.
         * @param row <ul><li>The specific row that the <code>AIBasic</code> chose
         *            for its turn.</li><li>-1: there is no row that <code>AIBasic</code> can choose.</li></ul>
         * @param col <ul><li>The specific col that the <code>AIBasic</code> chose
         *            for its turn.</li><li>-1: there is no col that <code>AIBasic</code> can choose.</li></ul>
         */
        Basic(int numb, String letter, int row, int col) {
            this.numb = numb;
            this.letter = letter;
            this.row = row;
            this.col = col;
        }
        int getNumb() {return numb;}
        String getLetter() {return letter;}
        int getRow() {return row;}
        int getCol() {return col;}

        public void setNumb(int numb) {
            this.numb = numb;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public void setCol(int col) {
            this.col = col;
        }

        private boolean checkBasicCoor () {
            return getRow() > -1 && getCol() > -1;
        }
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
        /*Basic temp = null;
        for (int i = 0; i < board.getBoard().length; i++) {
            temp = checkRow(board, i);
            if (temp.getLetter().equals(getStr()) && temp.getNumb() == 2 && temp.checkBasicCoor()) {
                return board.setBoard(getStr(), temp.getRow(), temp.getCol());
            } else if ((!temp.getLetter().equals(getStr()) && temp.getNumb() == 2)  && temp.checkBasicCoor()) {
                return board.setBoard(getStr(), temp.getRow(), temp.getCol());
            }
        }
        for (int i = 0; i < board.getBoard().length; i++) {
            temp = checkCol(board, i);
            if (temp.getLetter().equals(getStr()) && temp.getNumb() == 2 && temp.checkBasicCoor()) {
                return board.setBoard(getStr(), temp.getRow(), temp.getCol());
            } else if ((!temp.getLetter().equals(getStr()) && temp.getNumb() == 2)  && temp.checkBasicCoor()) {
                return board.setBoard(getStr(), temp.getRow(), temp.getCol());
            }
        }*/
        return null;
    }

    List getHorizontalStrs (String[][] board) {
        ArrayList<String[]> setOfHorz = new ArrayList<String[]>(board.length);
        Collections.addAll(setOfHorz, board);
        return setOfHorz;
    }
    List getVerticalStrs (String[][] board) {
        ArrayList<String[]> setOfVerts = new ArrayList<String[]>(board.length);
        String[] str1 = new String[board.length];
        String[] str2 = new String[board.length];
        String[] str3 = new String[board.length];
        for (String[] strs : board) {
            str1[0] = strs[0]; str2[1] = strs[1]; str3[2] = strs[2];
        }
        setOfVerts.add(str1);
        setOfVerts.add(str2);
        setOfVerts.add(str3);
        return setOfVerts;
    }
    List getDiagonalStrs (String[][] board) {
        ArrayList<String[]> setOfVerts = new ArrayList<String[]>(board.length);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                
            }
        }
    }

    /*
            if else public static private protected class interface new this super do while continue break int short long boolean goto for final float return null void 
        if else public static private protected class interface new this super do while continue break int short long boolean goto for final float return null void 
        if else public static private protected class interface new this super do while continue break int short long boolean goto for final float return null void 
        if else public static private protected class interface new this super do while continue break int short long boolean goto for final float return null void 
        if else public static private protected class interface new this super do while continue break int short long boolean goto for final float return null void 
        if else public static private protected class interface new this super do while continue break int short long boolean goto for final float return null void 
        if else public static private protected class interface new this super do while continue break int short long boolean goto for final float return null void 
        if else public static private protected class interface new this super do while continue break int short long boolean goto for final float return null void 

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
        return new Basic(num, str, row, col);
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
        return new Basic(num, str, row, col);
    }

    private static int getRow(String[][] board, int col, String letter) {
        for (int row = 0; row < board.length; row++) {
            if (!board[row][col].equals(letter)) {
                return row;
            }
        }
        return -1;
    }

    private Basic checkDiag (Board thing) {
        Basic basic1 = new Basic(0, "", -1, -1);
        Basic basic2 = new Basic(0, "", -1, -1);
        String str = "";
        String[][] board = thing.getBoard();
        String[][] diagonals = new String[2][board.length];
        for (int i = 0; i < board.length; i++) {
            diagonals[0][i] = board[i][i];
            diagonals[1][i] = board[board.length-(i+1)][i];
        }
        for (int i = 0; i < diagonals[0].length; i++) {
            Basic temp0 = new Basic(0,null,-1,-1);
            Basic temp1 = new Basic(0,null,-1,-1);
            for (int j = 0; j < diagonals[0].length; j++) {
                if (diagonals[0][i].equals(diagonals[0][j])) {
                    temp0.setLetter(diagonals[0][i]);
                    temp0.setNumb(temp0.getNumb() + 1);
                }
                if (diagonals[1][i].equals(diagonals[1][j])) {
                    tempNum1++;
                }
            }
            if (tempNum0 > num0) {
                num0 = tempNum0;
            }
            if (tempNum1 > num1) {
                num1 = tempNum1;
            }
        }
    }*/
}