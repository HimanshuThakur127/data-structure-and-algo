/*
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 
 */

 class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int level = 0;
        int[][] direction = {{-1, 0},{0,1},{1,0},{0,-1}};
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0; 
        while(!q.isEmpty()){
            int que_len = q.size();
            boolean rotted = false;
            while(que_len-->0){
               int[] orange = q.poll(); 
               for(int i = 0; i<direction.length;i++){
                    int row = orange[0]+direction[i][0];
                    int col = orange[1]+direction[i][1];
                    if(0 <= row && row < m && 0 <= col && col < n){
                       if(grid[row][col] == 0 || grid[row][col] == 2) continue; 
                       if(grid[row][col] == 1) {
                        fresh--;
                        rotted = true;
                        grid[row][col] = 2;
                        q.add(new int[]{row, col});
                       }
                    }
                }  
            }
            if(rotted) level++;
        }
        return fresh == 0 ? level : -1;
    }
}