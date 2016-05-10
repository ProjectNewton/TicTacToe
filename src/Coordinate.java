/**
 * Created by Rohan D'Souza on 5/10/2016.
 */
public class Coordinate {
    private int row;
    private int col;
    public Coordinate() {
        row = -1;
        col = -1;
    }
    Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
