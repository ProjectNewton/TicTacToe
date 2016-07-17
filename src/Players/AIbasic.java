package Players;

/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
import Game.Board;
import Players.Player;

public class AIbasic extends Player {

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
        if(board.isEmpty(1,1)) {
            return board.setBoard(getStr(),1,1);
        }
        return null;
    }

    /**
     * The <code>CheckHorizontal</code> method is to return 1 of 5 different integers: -2, -1, 0, 1, 2
     * <ul>
     *     <li>
     *         -2: The opponent has two letters in a
     *     </li>
     * </ul>
     *
     * @param board is the <code>Board</code> that is used as the board game.
     * @return
     */
    public int CheckHorizontal(Board board) {
        return 3;
    }














}