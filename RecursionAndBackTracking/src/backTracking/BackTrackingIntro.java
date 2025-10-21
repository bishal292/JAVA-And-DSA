package backTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class BackTrackingIntro {

    /*This is a continuity of the previous maze problems and Introduction to BackTracking
     *
     * Now what if the move to all directions were allowed (Up,Down,Left,Right).
     *
     *   _ _ _
     *   _ _ _    => "DDRUURDD","RRDLLDRR" ,.... also could be a way to reach the destination(last cell).
     *   _ _ _
     *
     * In an all-direction maze (up, down, left, right), recursion may visit the same cell multiple times and fall into infinite loops.
     * To prevent this, we maintain a `visited[][]` matrix that marks which cells are already explored in the current path.
     * If we reach a cell that is already visited, we simply return and do not explore that direction again.
     *
     * But this will again create a new problem i.e we know that in java all the objects are passed by reference means changes made in any recursion call to the visited array will be reflected in all other calls.
     * So after each call we have to reverse the changes made in that call before going back (being exhausted,returning)
     * ---------------------------------------------------------------------------------------------------------------------
     *                              THIS IS KNOWN AS BACKTRACKING
     * ---------------------------------------------------------------------------------------------------------------------
     *      Backtracking basically means
     *      -> Move forward (make a choice).
     *      -> if a dead end is hit or choice made was invalid, then backtrack(go back) in way that this choice was not ever made and tey another way(path/direction)
     *      -> Continue this process until an exit or solution is found.
     *
     */
    /**
     * a function to return the paths to reach the last cell in the maze from the start cell (0,0) where all direction movement are allowed.
     *
     * @param maze -> a boolean 2D array representing the valid cell(Not-visited cells) as true
     * @param row -> row denoting the current row (starts from 0)
     * @param col -> col denoting the current column (Starts from 0)
     * @param path -> a String Denoting the moves made till the current cell.
     *
     * @return returns an Arraylist of String denoting all the ways/steps to reach the last cell.
     * */
    static ArrayList<String> allDirMaze(boolean[][] maze, int row, int col, String path){
        ArrayList<String> ans = new ArrayList<>();
        if (row == maze.length -1 && col == maze[row].length -1){
            ans.add(path);
            return ans;
        }

//        Check if the current cell is not traversable(Visited Earlier).
        if(!maze[row][col]){
            return ans;
        }
//        Mark the current maze as false as it is visited.
        maze[row][col] = false;

//        Moves Down
        if (row < maze.length - 1)
            ans.addAll(allDirMaze(maze,row + 1,col,path+"D"));
//        Moves Right
        if (col < maze[row].length-1)
            ans.addAll(allDirMaze(maze,row,col + 1,path+"R"));
//        Moves Up
        if (row > 0)
            ans.addAll(allDirMaze(maze,row-1,col,path+"U"));
//        Moves Left
        if (col > 0)
            ans.addAll(allDirMaze(maze,row,col - 1,path+"L"));
//      Before returning from the function reverse the changes made i.e reverse the value of maze change within this func call.
        maze[row][col] = true;
        return ans;
    }

//  ----------------------------------------------------------------------------------------------------------------------------
//    An advance version of the previous question where along with the moves made also print the path in a matrix format.
//  ----------------------------------------------------------------------------------------------------------------------------
    static void printAllPath(boolean[][] maze, int row,int col,String p,int[][] path,int step){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            path[row][col] = step;
            for(int[] ar: path){
                System.out.println(Arrays.toString(ar));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[row][col]){
            return;
        }

        maze[row][col] = false;// marked as visited
        path[row][col]= step;
        // Moves down
        if(row < maze.length - 1)
            printAllPath(maze,row + 1,col,p + "D",path,step + 1);
        // Moves right
        if(col < maze[0].length - 1)
            printAllPath(maze,row,col+1,p+"R",path,step + 1);
        // Moves Up
        if(row > 0)
            printAllPath(maze,row - 1,col,p+"U",path,step + 1);
        // Moves Left
        if(col > 0)
            printAllPath(maze,row,col - 1,p+"L",path,step + 1);

        maze[row][col] = true;// unmark the cell
        path[row][col]= 0;
    }



    public static void main(String[] args) {
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        ArrayList<String> ans = allDirMaze(maze,0,0,"");
//        System.out.println(ans); // [DDRR, DDRURD, DDRUURDD, DRDR, DRRD, DRURDD, RDDR, RDRD, RDLDRR, RRDD, RRDLDR, RRDLLDRR]

        printAllPath(maze,0,0,"",path,1);
    }
}
