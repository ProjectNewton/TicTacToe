package Players;

/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
import Game.Board;

import java.util.*;

public class AInode extends Player {
    public static final int WIN = 2;
    public static final int LOSS = -2;
    public static final int TIE = 1;

    private Node tree;


    public static class Node {
        private int heuristic;
        private Board board;
        private List<Node> childs;
        public Node(Board board, List<Node> childs) {
            this.heuristic = sumChildsHeuristic();
            this.board = board;
            this.childs = childs;
        }

        public void setHeuristic(int heuristic) {
            this.heuristic = heuristic;
        }
        public int getHeuristic() {
            return heuristic;
        }
        private int sumChildsHeuristic() {
            int sum = 0;
            for (Node child: childs) {
                sum += child.getHeuristic();
            }
            return sum;
        }
    }


    public AInode (String[] strs) {
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
        if (this.tree == null) {
            this.tree = new Node(board,createTree(board, str));
        }
        return board;
    }

    private List<Node> createTree(Board board, String letter) {
        if (board.checkWin()>0) {
            List<Node> child = new ArrayList<Node>(1);
        }
        return null;
    }

    /*private List<Node> createList(Board board, String letter) {
        ArrayList<Node> children = new ArrayList<Node>();
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[0].length; j++) {
                if (!board.isEmpty(i,j))
                    children.add(new Node(board.setBoard(letter,i,j)));
            }
        }

    }*/

}
