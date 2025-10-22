package backTracking;

public class NQueens {
//    This is a continuity of backtracking so have a look to backtracking intro.
//    ------------------------------------------------------------------------------------------------------------------------------------
//                                                      N - QUEENS
//    ------------------------------------------------------------------------------------------------------------------------------------
    /*  N queens problems are the type of problem statement which asks to return all the ways such that 'N' Queens can be placed on the board of size N X N.
     *  not any queens can discard other by each other movements
     *  As we know that a queen can move either in a straight line or Diagonally
     *
     * EX:
     *          _ Q _ _             _ _ Q _
     *          _ _ _ Q             Q _ _ _
     *          Q _ _ _      OR     _ _ _ Q         SO, Total 2 ways 4 queens can be arranged on a 4 X 4 Board.
     *          _ _ Q _             _ Q _ _
    * */
    static int nQueen(boolean[][] board,int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
//        Check in current row if there is any safe place to place the queen
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += nQueen(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }
//  Function to check whether the current position (row,col) is safe to place the queen or not
    static boolean isSafe(boolean[][] board, int row, int col) {
        // Check if any queen is present vertically in same col.
        for(int i = 0;i<row;i++){
            if (board[i][col]){
                return false;
            }
        }
//        Check left Diagonal
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i])return false;
        }
//        Check Right Diagonal
        int maxRight = Math.min(row,board.length - 1 - col);
        for (int i =1;i<= maxRight;i++){
            if(board[row - i][col + i])return false;
        }


        return true;
    }

//    Function to display the board after successfull placement of the Queens.
    private static void display(boolean[][] board) {
        for(boolean[] ar: board){
            for (boolean bool : ar){
                if (bool){
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }


    static void main(String[] args) {
        int n = 4;
        boolean [][] board = new boolean[n][n];

        System.out.println(nQueen(board,0));
    }
}
