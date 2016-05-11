import java.util.Scanner;

/**
 * Created by Rohan D'Souza on 4/9/2016.
 */
public class Game {
    public static void main(String[] args) {
        boolean win = false;
        Scanner sc = new Scanner(System.in);
        Board board = new Board((short) 3);
        board.fill();
        System.out.print(board);
        HumanPlyr rohan = new HumanPlyr();
        while (!win) {
            rohan.play(board);
            System.out.println(board);
            win = board.checkWin();
        }
        System.out.println("Some one won!!");
        /*String thing = sc.nextLine();
        board.configureBoard(thing,0,1);
        System.out.println(board);*/
    }
}
