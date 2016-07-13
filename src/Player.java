import java.util.Scanner;

/**
 * Created by Rohan D'Souza on 7/10/2016.
 */
public abstract class Player {
    String str;
    String[] strings;
    Scanner sc = new Scanner(System.in);

    String getStr() {
        return str;
    }
    String[] getStrings() {
        return strings;
    }

    abstract Board play(Board board);

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
