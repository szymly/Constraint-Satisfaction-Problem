package algorithms;

import latinsquare.LatinSquare;
import nqueens.Chessboard;

/**
 * Created by Szymon on 23.03.2018.
 */
public class ForwardCheckingAlgorithm {

    public static Object forwardChecking(int n, String problem){
        Object result;
        switch(problem){
            case "Latin Square":
                result = latinSquareForwardChecking(n);
                break;
            case "Queen":
                result = nqueensForwardChecking(n);
                break;
            default:
                result = null;

        }
        return result;
    }

    private static LatinSquare latinSquareForwardChecking(int n){
        LatinSquare result = new LatinSquare(n);


        return result;
    }

    private static Chessboard nqueensForwardChecking(int n){
        Chessboard result = new Chessboard(n);

        return result;
    }

}
