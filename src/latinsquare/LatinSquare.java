package latinsquare;

/**
 * Created by Szymon on 23.03.2018.
 */
public class LatinSquare {

    private int[][] square;

    public LatinSquare(int n) {
        this.square = new int[n][n];
    }

    public int[][] getSquare() {
        return square;
    }

    public void setSquare(int[][] square) {
        this.square = square;
    }

}
