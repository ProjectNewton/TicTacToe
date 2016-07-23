import Game.Board;
import Players.AIbasic;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Rohan D'Souza on 7/22/2016.
 */
public class AIBasicTest {
    @Test
    public void checkRowInnerLoopTest() {
        Board b1 = new Board(new String[][]{
                {"X", "X", " "},
                {"Y", " ", " "},
                {"Y", "Y", " "}
        });
        Board b2 = new Board(new String[][]{
                {"X", "Y", "X"},
                {" ", "Y", "Y"},
                {"Y", " ", "X"}
        });
        assertEquals(2, AIbasic.checkRowInnerLoop(b1.getBoard(), 0,0));
        assertEquals(1, AIbasic.checkRowInnerLoop(b1.getBoard(), 1,0));
        assertEquals(2, AIbasic.checkRowInnerLoop(b1.getBoard(), 2,0));
        assertEquals(2, AIbasic.checkRowInnerLoop(b2.getBoard(), 0,0));
        assertEquals(2, AIbasic.checkRowInnerLoop(b2.getBoard(), 1,1));
        assertEquals(1, AIbasic.checkRowInnerLoop(b2.getBoard(), 2,0));
    }

    @Test
    public void checkRowOuterLoopTest() {
        Board b1 = new Board(new String[][]{
                {"X", "X", " "},
                {"Y", " ", " "},
                {"Y", "Y", " "}
        });
        Board b2 = new Board(new String[][]{
                {"X", "Y", "X"},
                {" ", "Y", "X"},
                {"Y", " ", "X"}
        });
        assertEquals(2, AIbasic.checkRowOuterLoop(b1.getBoard(), 0));
        assertEquals(2, AIbasic.checkRowOuterLoop(b1.getBoard(), 1));
        assertEquals(2, AIbasic.checkRowOuterLoop(b1.getBoard(), 2));
        assertEquals(2, AIbasic.checkRowOuterLoop(b2.getBoard(), 0));
        assertEquals(1, AIbasic.checkRowOuterLoop(b2.getBoard(), 1));
        assertEquals(1, AIbasic.checkRowOuterLoop(b2.getBoard(), 2));
    }

    @Test
    public void checkRowTest() {
        Board b1 = new Board(new String[][]{
                {"X", "X", " "},
                {"Y", " ", " "},
                {"Y", "Y", " "}
        });
        Board b2 = new Board(new String[][]{
                {"X", "Y", "X"},
                {" ", "Y", "X"},
                {"Y", " ", "X"}
        });
        assertEquals(2, AIbasic.checkRow(b1,0).getNumb());
        assertEquals("X", AIbasic.checkRow(b1,0).getLetter());
        assertEquals(2, AIbasic.checkRow(b1,0).getCol());
    }
}
