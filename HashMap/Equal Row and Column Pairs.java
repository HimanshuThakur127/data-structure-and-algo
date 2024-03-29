// Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

// A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

// Example 1:


// Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
// Output: 1
// Explanation: There is 1 equal row and column pair:
// - (Row 2, Column 1): [2,7,7]


class Solution {
    public int equalPairs(int[][] grid) {
        int total_row = 0, total_col = 0, n = grid[0].length;
        HashMap<Integer, Integer> rows = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> cols = new HashMap<Integer, Integer>();
        for(int r = 0;r<n;r++){
            total_row = total_col = 0;
            for(int c = 0; c<n;c++){
                total_row += grid[r][c];
                total_col += grid[c][r];
            }
            rows.put(r, total_row);
            cols.put(r, total_col);
        }
        int ans = 0;
        for(int r = 0;r<n;r++){
            int row_sum = rows.get(r);
            for(int c = 0;c<n;c++){
                if(row_sum == cols.get(c)){
                    int i = 0;
                    while(i<n){
                       if(grid[r][i] != grid[i][c]) break;
                       i+=1;
                    }
                    if(i == n) ans += 1;
                }
            }
        }
        return ans;
    }
}