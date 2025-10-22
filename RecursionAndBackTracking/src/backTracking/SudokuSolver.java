package backTracking;

public class SudokuSolver {
    /*Leetcode: 37 -> Sudoku Solver
    *
    * a program to solve a Sudoku puzzle by filling the empty cells.
    * A sudoku solution must satisfy all the following rules:
    * Each of the digits 1-9 must occur exactly once in each row.
    * Each of the digits 1-9 must occur exactly once in each column.
    * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    * The '.' character indicates empty cells.
    * */
    private static boolean solve(int[][] board){
        int row = -1,col = -1;
        int n = board.length;
        boolean emptyLeft = false;
//        Traverse through the array and check for any empty(0) cell. And if it is found then break(Come out) of the both loops.
        for (row = 0; row < n; row++) {
            for (col = 0; col <n; col++) {
                if (board[row][col] == 0){
                    emptyLeft = true;
                    break;
                }
            }
            if (emptyLeft)break;
        }
//        If there was not any empty cell left then simply return as all the cells are filled.
        if (!emptyLeft)return true;

//        For the empty cell try the combination of number from 1 to 9.
        for (int i = 1; i <= 9; i++) {
//            Check whether the number is safe to place here currently.
            if (isSafe(board,row,col,i)){
//                if it is safe to place the update the grid with the current number and again traverse for another empty cell recursively.
                board[row][col] = i;
                if (solve(board)){
                    return true;
                }
//                If somehow the choice for number made was not correct then rollback the changes made in the original grid.
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board,int row,int col,int num){
//        Checking if the number is already in the same row or same column.
        for(int i = 0;i< board.length;i++){
            if (board[row][i] == num || board[i][col] == num)return false;
        }

//        Checking within the same grid.
        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i <rowStart+3 ; i++) {
            for (int j = colStart;j<colStart+3;j++){
                if (board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }


    static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if (solve(sudoku)){
            display(sudoku);
        }else {
            System.out.println("Sudoku cannot be solved");
        }

    }

    private static void display(int[][] sudoku) {
        for (int i = 0;i<sudoku.length;i++){
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}
