package recAdvProblems;

import java.util.ArrayList;
import java.util.List;

public class RecAdvProblems {
//    -----------------------------------------------------------------------------------------------------------------------------
//                                              Travelling to the Other end of a Maze(Matrix)
//    -----------------------------------------------------------------------------------------------------------------------------

//    Function to return the count of ways we can reach to the last cell from first cell by making the move where we can either go down or Right.
//    (3,3) -> (0,0)
/*          * _ _
*           _ _ _   => rrdd,rdrd,rddr,drrd,drdr,ddrr ( Means total 6 ways of reaching the other end)
*           _ _ *
* */
    static int countWays(int row,int col){
        if (row == 1 || col == 1){
            return 1;
        }
        return countWays(row -1,col) + countWays(row,col-1);
    }

//    -----------------------------------------------------------------------------------------------------------------------------
//    Follow-up of above problem where instead of ways count the actual ways are being returned.
    static ArrayList<String> waysToReach(int row, int col,StringBuilder path){
        ArrayList<String> ans = new ArrayList<>();

        if(row == 1 && col == 1){
            ans.add(path.toString());
            return ans;
        }
        if (col > 1) {
            ans.addAll(waysToReach(row, col - 1, new StringBuilder(path).append("R")));
        }
        if(row > 1){
            ans.addAll(waysToReach(row-1,col, path.append("D")));
        }
        return ans;
    }

//    -----------------------------------------------------------------------------------------------------------------------------
//    list of path by which we can reach to the other end including diagonal move where D,V,H represent diagonal, Down, Right move made.
    static ArrayList<String> waysToReachIncDiagonal(int row, int col,StringBuilder path){
        ArrayList<String> ans = new ArrayList<>();

        if(row == 1 && col == 1){
            ans.add(path.toString());
            return ans;
        }

        if (col > 1) {
            ans.addAll(waysToReachIncDiagonal(row, col - 1, new StringBuilder(path).append("H")));
        }
        if(row > 1){
            ans.addAll(waysToReachIncDiagonal(row-1,col, new StringBuilder(path).append("V")));
        }
        if(row > 1 && col > 1){
            ans.addAll(waysToReachIncDiagonal(row -1,col-1,path.append("D")));
        }
        return ans;
    }


//    -----------------------------------------------------------------------------------------------------------------------------
//                                      Travelling in a Maze With Obstacles(cell which cannot be reached or from which we cannot travel)
//    -----------------------------------------------------------------------------------------------------------------------------
    /*
    * Travelling in a maze which contains some obstacles in any of the cell such that we cannot travel using that cell
    * for this problem (0,0) is considered as the starting cell
    *       _ _ _
    *       _ X _       here we cannot use (1,1) cell.So the ways are RRDD,DDRR only.
    *       _ _ _
    *
    * */
    /**
     * a function to return the paths to reach the last cell in the maze from the start cell (0,0) where only right and down movement are allowed.
     *
    * @param maze -> a boolean 2D array representing the valid cell as true
    * @param row -> row denoting the current row
    * @param col -> col denoting the current column
    * @param path -> a String Denoting the moves made till the current cell.
    *
    * @return returns an Arraylist of String denoting all the ways/steps to reach the last cell.
    * */
    static ArrayList<String> waysWithObstacle(boolean[][] maze,int row,int col,String path){
        ArrayList<String> ans = new ArrayList<>();
        if (row == maze.length -1 && col == maze[row].length -1){
            ans.add(path);
            return ans;
        }

//        Check if the current cell is not traversable as it contains obstacle
        if(!maze[row][col]){
            return ans;
        }
        if (row < maze.length - 1)
            ans.addAll(waysWithObstacle(maze,row + 1,col,path+"D"));
        if (col < maze[row].length-1)
            ans.addAll(waysWithObstacle(maze,row,col + 1,path+"R"));

        return ans;
    }
    //    -----------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println(countWays(4,4)); //6
        System.out.println(waysToReach(3,3,new StringBuilder())); // [RRDD, RDRD, RDDR, DRRD, DRDR, DDRR]
        System.out.println(waysToReachIncDiagonal(3,3,new StringBuilder())); // [HHVV, HVHV, HVVH, HVD, HDV, VHHV, VHVH, VHD, VVHH, VDH, DHV, DVH, DD] ==> H-> right, V-> Down , D-> Diagonal

//    -----------------------------------------------------------------------------------------------------------------------------
        boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true},
                {true,true,true}
        };
        System.out.println(waysWithObstacle(board,0,0,"")); // [DDDRR, DDRDR, DDRRD, RRDDD] can't travel (1,1) cell of maze as it contains obstacle.
    }
}
