package algorithms;

import nqueens.Chessboard;
import latinsquare.LatinSquare;

import java.util.LinkedList;

/**
 * Created by Szymon on 23.03.2018.
 */
public class BacktrackingAlgorithm {

    private static LinkedList<CoordAssignment> assignments;


    public static Object backtracking(int n, String problem){
        Object result;
        switch(problem){
            case "Latin Square":
                result = latinSquareBacktracking(n);
                break;
            case "Queen":
                assignments = new LinkedList<>();
                result = nqueensBacktracking(n);
                break;
            default:
                result = null;

        }
        return result;
    }

    private static LatinSquare latinSquareBacktracking(int n){
        LatinSquare result = new LatinSquare(n);


        return result;
    }

    private static Chessboard nqueensBacktracking(int n){
        boolean finished = false;

        Chessboard chessboard = new Chessboard(n);

        int startX = 0;
        int startY = 0;

        chessboard = placeQueens(startX, startY, chessboard);

        int i=0;

        while(chessboard.getQueensNumber() < n && !finished ){

            chessboard.printChessboard();
            System.out.println("Queens placed: " + chessboard.getQueensNumber() + ". Backtracking.");
            System.out.println("+++++++++++++++++++++++++++++++++++++");


            int lastX = startX;
            int lastY = startY;
            i++;
            if(assignments.size()>0) {
                CoordAssignment lastAssignment = assignments.pop();

                lastX = lastAssignment.getX();
                lastY = lastAssignment.getY();


                chessboard.deleteQueen(lastX, lastY);
                chessboard.lockField(lastX,lastY);
            }



            lastY++;

                if(lastY>=n)
                {
                    lastY=0;
                    lastX++;

                    if(lastX>=n)
                    {
                        startY++;
                        if(startY>=n){
                            startY = 0;
                            startX++;
                        }
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Changing start point to: "+ startX + " " + startY);
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                        chessboard.clearChessboard();

                    }
                }

                if(startX>=n){
                    System.out.println("Couldnt find solution.");
                    break;
                }



            System.out.println("Starting point: " + lastX + " " + lastY);

            placeQueens(lastX, lastY, chessboard);

        }

        return chessboard;
    }

    private static Chessboard placeQueens(int x, int y, Chessboard chessboard){

        for(int i = x; i < chessboard.getN(); i++){
            for(int j = y; j < chessboard.getN(); j++){

                if(chessboard.canQueenBePlaced(i,j)) {
                    chessboard.setQueen(i, j);
                    CoordAssignment lastAssignment = new CoordAssignment(i,j);
                    assignments.addFirst(lastAssignment);
                }
            }
        }
        return chessboard;
    }


//    private static boolean isConstraintSatisfied(Object var1, Object var2, String constraint){
//
//        switch(constraint){
//            case "Not in same row":
//        }
//
//    }



}
