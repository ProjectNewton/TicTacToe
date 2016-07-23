package Game;

import Game.Board;
import Players.AIbasic;
import Players.HumanPlyr;
import Players.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Rohan D'Souza on 4/9/2016.
 */
public class Main {
    public static final String PlayerO = "O";
    public static final String PlayerX = "X";
    public static void main(String[] args) {
        String[] strings = new String[]{PlayerO, PlayerX};
        int win = -1;
        Scanner sc = new Scanner(System.in);
        Board board = new Board((short) 3);
        board.fill();
        System.out.print(board);
        Player Player1 = new AIbasic(strings);
        strings = Player1.getStrings();
        Player Player2 = new HumanPlyr(strings);
        strings = Player2.getStrings();

        while (true) {
            Player1.play(board);
            System.out.println("AI PLAYED");
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
    }

    public static String getOtherStr (String str) {
        if (str.equals(PlayerO))
            return PlayerX;
        else if (str.equals(PlayerX))
            return PlayerO;
        throw new InputMismatchException();
    }
}