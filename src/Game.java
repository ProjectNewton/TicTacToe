import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rohan D'Souza on 4/9/2016.
 */
public class Game {

    public static void main(String[] args) {
        String[] strings = new String[]{"Y", "X",};
        int win = -1;
        Scanner sc = new Scanner(System.in);
        Board board = new Board((short) 3);
        board.fill();
        System.out.print(board);
        Player Player1 = new HumanPlyr(strings);
        strings = Player1.getStrings();
        Player Player2 = new HumanPlyr(strings);
        strings = Player2.getStrings();

        while (win == -1) {
            Player1.play(board);
            System.out.println(board);
            win = board.checkWin();
            if (win != -1) break;
            Player2.play(board);
            System.out.println(board);
            win = board.checkWin();
            if (win != -1) break;
        }
        if (win == 2) System.out.println("ITS A TIE... YOU BOTH SUUUUCK!!!");
        else System.out.println("Player " + board.getWinnner() + " wiiinssss!!");
        /*String thing = sc.nextLine();
        board.configureBoard(thing,0,1);
        System.out.println(board);*/
    }
}
