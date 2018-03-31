import algorithms.BacktrackingAlgorithm;
import nqueens.Chessboard;

/**
 * Created by Szymon on 23.03.2018.
 */
public class CSP {

    private static final String N_QUEENS_PROBLEM = "Queen";

    public static void main(String[] args){
        Chessboard result = (Chessboard) BacktrackingAlgorithm.backtracking(8, N_QUEENS_PROBLEM);
        result.printChessboard();
    }
}
