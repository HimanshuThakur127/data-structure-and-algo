/*
 * 
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */
class Solution {
    class Pair {
        int u;
        int v;
        Pair(int u, int v){
            this.u = u;
            this.v = v;
        }
        private int getU(){
            return this.u;
        }
        private int getV(){
            return this.v;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
       int[][] direction = {{-1, 0},{1,0},{0,-1},{0,1}};
       int m = maze.length;
       int n = maze[0].length;
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(entrance[0], entrance[1]));
       maze[entrance[0]][entrance[1]] = '+';
       int steps = 0;
       while(!q.isEmpty()){
         steps++;
         int queue_len = q.size();
         while(queue_len-->0){
           Pair curr = q.poll();
           for(int i = 0; i<direction.length;i++){
                int row = curr.getU()+direction[i][0];
                int col = curr.getV()+direction[i][1];
                if(0 <= row && row < m && 0 <= col && col < n){
                    if(maze[row][col] == '+') continue;
                    if(row == 0 || row == m-1 || col == 0 || col == n-1) {
                        return steps;
                    }
                    
                    q.add(new Pair(row, col)); 
                    maze[row][col] = '+'; 
                    
                }
            } 
        }
         
       }
       return -1; 
    }
}