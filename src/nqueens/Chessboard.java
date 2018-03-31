package nqueens;

/**
 * Created by Szymon on 23.03.2018.
 */
public class Chessboard {

    private int[][] chessboard;
    private int n;

    public Chessboard(int n) {
        this.n = n;
        this.chessboard = new int[n][n];
    }

    public boolean hasQueen(int x, int y){
        return this.chessboard[x][y]==1;
    }

    public void setQueen(int x, int y){
        this.chessboard[x][y] = 1;
    }

    public void deleteQueen(int x, int y){
        if(chessboard[x][y]==1) {
            chessboard[x][y] = 0;
        }
    }

    public void lockField(int x, int y){
        this.chessboard[x][y] = -1;
    }

    public void printChessboard(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(chessboard[i][j]==1)
                System.out.print("X | ");
                else{
                    System.out.print("  | ");
                }
            }
            System.out.print("\n");
            for(int z = 0; z < n; z++){
                System.out.print("----");
            }
            System.out.print("\n");
        }
    }


    public boolean canQueenBePlaced(int i, int j) {
        return noQueensInRow(i) && noQueensInColumn(j) && noQueensOnDiagonals(i,j) && !isFieldLocked(i,j);
    }

    private boolean noQueensOnDiagonals(int i, int j) {

        int sum = i + j;
        int diff = i - j;

        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if( sum == (x + y) || diff == (x - y) ){
                    if( hasQueen(x,y) )
                        return false;
                }
            }
        }

        return true;
    }

    private boolean noQueensInColumn(int i) {

        for(int j = 0; j < n; j++){
            if(hasQueen(j,i))
                return false;
        }
        return true;
    }

    private boolean noQueensInRow(int i) {

    for(int j = 0; j < n; j++){
            if(hasQueen(i,j))
                return false;
        }
        return true;
    }

    private boolean isFieldLocked(int x, int y){
        return chessboard[x][y] == -1;
    }

    public int getQueensNumber() {
        int result = 0;

        for(int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (chessboard[x][y] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public int getN() {
        return n;
    }

    public void clearChessboard(){
        this.chessboard = new int[n][n];
    }
}
