import Game.Board;
import Players.AIbasic;
import Players.HumanPlyr;
import Players.Player;
import java.util.Scanner;

/**
 * Created by Rohan D'Souza on 4/9/2016.
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"Y", "X",};
        int win = -1;
        Scanner sc = new Scanner(System.in);
        Board board = new Board((short) 3);
        board.fill();
        System.out.print(board);
        Player Player1 = new AIbasic(strings);
        strings = Player1.getStrings();
        Player Player2 = new HumanPlyr(strings);
        strings = Player2.getStrings();//*
    }
}