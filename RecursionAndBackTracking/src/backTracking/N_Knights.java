package backTracking;

public class N_Knights {
    public static int nKnight(boolean[][] maze,int row,int col ,int target){
        if (target == 0){ // if all knights are placed safely
            display(maze);
            System.out.println();
            return 1;
        }
//        If reach outside the maze rows simply return 0
        if(row == maze.length)return 0;

        int count = 0;

        // at end column -> Move to next row without going below otherwise it'll end up in a infinite recursion due to the last call which is occurred irrespective of whether safe or not.
        if (col == maze.length){
            return nKnight(maze,row+1,0,target);
        }
        if(isSafe(maze,row,col)){
            maze[row][col] = true;
            count += nKnight(maze,row,col+1,target-1);
            maze[row][col] = false;
        }
        count += nKnight(maze,row,col+1,target);

        return count;
    }

    private static boolean isSafe(boolean[][] maze, int row, int col) {
        if (isValid(maze,row -1 ,col-2)){
            if (maze[row - 1][col - 2])return false;
        }
        if (isValid(maze,row-1,col +2)){
            if (maze[row-1][col + 2])return false;
        }
        if (isValid(maze,row -2,col -1)){
            if (maze[row -2 ][col - 1])return false;
        }
        if (isValid(maze,row-2,col + 1)) {
            if (maze[row - 2][col + 1]) return false;
        }
        return true;
    }

    private static boolean isValid(boolean[][] maze,int row, int col){
        return row >= 0 && row < maze.length && col >= 0 && col < maze.length;
    }
    //    Function to display the board after successfull placement of the Queens.
    private static void display(boolean[][] board) {
        for(boolean[] ar: board){
            for (boolean bool : ar){
                if (bool){
                    System.out.print("K ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    static void main(String[] args) {

        int n = 4;
        boolean[][] maze = new boolean[n][n];

        int ans = nKnight(maze,0,0,n);
        System.out.println(ans); // 412
    }
}
