/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
public class AIbasic extends Player {

    public AIbasic (String[] strs) {
        if (strs.length == 2) {
            System.out.println("This AI will have to be player " + strs[1]);
            str = strs[1];
            super.strings = new String[1];
            System.out.println(getStrings().length);
            super.strings[0] = strs[0];
        }
        else if(strs.length == 1) {
            System.out.println("This AI will have to be player " + strs[0]);
            str = strs[0];
            strings = new String[0];
        }
        else {
            str = null;
            strings = null;
        }
    }

    @Override
    public Board play(Board board) {
        return null;
    }
}
