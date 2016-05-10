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
        System.out.println("DO you Want to be player \"X\" or player \"Y\"");
        System.out.println("");
        str = sc.nextLine();

    }
    @Override
    public Board play(Board board) {
        System.out.print("What is the row of your choice:");
        int row = sc.nextInt();
        System.out.print("What is the column of your choice:");
        int col = sc.nextInt();

        return null;
    }
    @Override
    public int[] play(int[] board) {
        return new int[0];
    }
}
