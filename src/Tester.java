import java.util.Scanner;

/**
 * Created by Rohan D'Souza on 4/9/2016.
 */
public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board((short) 3);
        board.fill();
        System.out.print(board);
        String thing = sc.nextLine();
        board.setBoard(thing,0,1);
        System.out.println(board);
    }
}
