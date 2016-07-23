package Players;
/**
 * Created by Rohan D'Souza on 7/10/2016.
 */
import java.util.Scanner;
import Game.*;
public abstract class Player {
    String str;
    String[] strings;
    Scanner sc = new Scanner(System.in);

    public String getStr() {return str;}
    public String[] getStrings() {return strings;}

    public abstract Board play(Board board);

    public String getOtherString(String[] strs) {
        if (str.equals(Main.PlayerX)) {
            return Main.PlayerO;
        }
        return Main.PlayerX;
    }
}
