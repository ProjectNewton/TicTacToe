import java.util.Scanner;
/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
public class HumanPlyr implements Player{
    public static String str1 = "X";
    public static String str2 = "Y";
    private String str;
    Scanner sc = new Scanner(System.in);
    public HumanPlyr(){
        System.out.println("DO you Want to be player X or player Y");
        System.out.println("(only type \"X\" or \"Y\")");
        String string = sc.nextLine();
        if (string.toUpperCase().equals("X") || string.toUpperCase().equals("Y"))
            str = string;
        else {
            System.out.println("You screwed up on the easiest task in this game." +
                    "congratulations you are lower than average.\n");
            str = null;
            throw new IllegalArgumentException();
        }


    }
    @Override
    public Board play(Board board) {
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
