import java.util.Scanner;
/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
public class HumanPlyr implements Player{
    private String str;
    private String[] strings;
    Scanner sc = new Scanner(System.in);
    public HumanPlyr(String[] strs){
        if (strs.length == 1) {
            System.out.println("You're going to have to be player " + strs[0]);
            str = strs[0];
            strings = new String[0];
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

    public String getStr() {
        return str;
    }

    public String[] getStrings() {
        return strings;
    }

    public String getOtherString (String[] strs) {
        if (strs.length == 2) {
            if (strs[0].equals(str)) {
                return strs[1];
            }
            else if (strs[1].equals(str))
                return strs[0];
        }
        return null;
    }

    @Override
    public Board play(Board board) {
        System.out.println("ITS PLAYER " + str + "'s TURN!");
        System.out.print("What is the row of your choice:");
        int row = sc.nextInt();
        System.out.print("What is the column of your choice:");
        int col = sc.nextInt();
        if (row >= board.getBoard().length || col >= board.getBoard()[0].length)
            System.out.println("You inputted data that is out of Bounds. Loser");
        else
            return board.setBoard(str,row,col);
        return board.clone();
    }
}
