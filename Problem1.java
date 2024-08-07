// Time Complexity : O(N!)
// Space Complexity : O(nxn)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

/**
 * The strategy here is to put a queen in a column and repeat this for each row. Keep checking
 * if it is safe to put the queen in that cell, keeping in mind the queens cannot attack
 * each other.
 */

public class Problem1 {
    private List<List<String>> res;
    private boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        this.board = new boolean[n][n];
        backtrack(0, n);
        return res;
    }

    private void backtrack(int r, int n) {
        //base
        if(r == n) {
            List<String> ways = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ways.add(sb.toString());
            }
            res.add(ways);
            return;
        }
        //logic
        for(int j = 0; j < n; j++) {
            if(isSafe(r, j, n)) {
                //action
                board[r][j] = true;
                //recurse
                backtrack(r + 1, n);
                //backtrack
                board[r][j] = false;
            }
        }
    }

    private boolean isSafe(int r, int c, int n) {
        //UP
        for(int i = 0; i < r; i++) {
            if(board[i][c]) return false;
        }
        //Diagonal UpLeft
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0) {
            if(board[i][c]) return false;
            i--;
            j--;
        }
        //Diagonal UpRight
        i = r;
        j = c;
        while(i >= 0 && j < n) {
            if(board[i][c]) return false;
            i--;
            j++;
        }

        return true;
    }
}
