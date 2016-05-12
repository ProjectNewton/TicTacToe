import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rohan D'Souza on 4/9/2016.
 */
public class Game {
    private static String[] strings;

    public static void main(String[] args) {
        strings = new String[]{"Y", "X",};
        boolean win = false;
        Scanner sc = new Scanner(System.in);
        Board board = new Board((short) 3);
        board.fill();
        System.out.print(board);
        Player Player1 = new HumanPlyr(strings);
        strings = Player1.getStrings();
        Player Player2 = new HumanPlyr(strings);
        strings = Player2.getStrings();

        while (!win) {
            Player1.play(board);
            System.out.println(board);
            win = board.checkWin();
            Player2.play(board);
            System.out.println(board);
            win = board.checkWin();
        }
        System.out.println("Player " + board.getWinnner() + " won!!");
        /*String thing = sc.nextLine();
        board.configureBoard(thing,0,1);
        System.out.println(board);*/
    }
}
