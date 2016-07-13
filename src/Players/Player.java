package Players;
/**
 * Created by Rohan D'Souza on 7/10/2016.
 */
import java.util.Scanner;
import Game.Board;
public abstract class Player {
    String str;
    String[] strings;
    Scanner sc = new Scanner(System.in);

    public String getStr() {return str;}
    public String[] getStrings() {return strings;}

    public abstract Board play(Board board);

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
}
