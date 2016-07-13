package Players;
/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
import Game.Board;

public class HumanPlyr extends Player {
    public HumanPlyr(String[] strs){
        if (strs.length == 1) {
            System.out.println("The other person playing... Yes you... You're going to have to be player " + strs[0]);
            str = strs[0];
            super.strings = new String[0];
        }
        else if (strs.length == 2) {
            System.out.println("DO you Want to be player " + strs[0] + " or player " + strs[1]);
            System.out.println("(only type \"" + strs[0] + "\" or \"" + strs[1] + "\")");
            String string = sc.nextLine();
            if (string.toUpperCase().equals(strs[0]) || string.toUpperCase().equals(strs[1])) {
                str = string;
                //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
                strings = new String[]{getOtherString(strs)};
            }
            else {
                System.out.println("You screwed up on the easiest task in this game." +
                        "congratulations you are lower than average.\n");
                str = strs[0];
                System.out.println("Now I get to pick for you \nYou are going to be Player " + strs[0]);
                strings = new String[]{strs[1]};
            }
        }
        else {
            str = null;
            strings = null;
        }
    }


    @Override
    public Board play(Board board) {
        System.out.println("ITS PLAYER " + str + "'s TURN!");

        System.out.print("What is the row of your choice:");
        int row = sc.nextInt();
        while (row > 2) {
            System.out.println("That is out of bounds. Enter a valid row!!!");
            row = sc.nextInt();
        }

        System.out.print("What is the column of your choice:");
        int col = sc.nextInt();
        while (col > 2) {
            System.out.println("That is out of bounds. Enter a valid column!!!");
            col = sc.nextInt();
        }

        if (board.isEmpty(row,col)) return board.setBoard(str,row,col);
        else{
            System.out.println("That position is already taken... lol sorry... try to see next time!!!");
            return play(board);
        }
    }
}
