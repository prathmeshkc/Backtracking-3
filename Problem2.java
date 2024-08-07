// Time Complexity : O(m*n*3^L)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * We start the dfs when we find the first character of the word in the board.
 * We then explore all the directions from that point and backtrack if the path is not valid.
 * If we reach the end of the word, we return true.
 * If we exhaust all the possibilities, we return false.
 */


public class Problem2 {

    private int m, n;
    private int[][] dirs;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][] {
                {0, 1}, //right
                {1, 0}, //down
                {0, -1}, //left
                {-1, 0} //up
        };

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, int idx, String word) {
        //base
        if(idx == word.length()) return true;
        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] == '$') return false;
        //logic
        if(board[r][c] == word.charAt(idx)) {
            //action
            char temp = board[r][c];
            board[r][c] = '$';
            //recurse
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if( dfs(board, nr, nc, idx + 1, word)) {
                    return true;
                }
            }
            //backtrack
            board[r][c] = temp;
        }
        return false;
    }
}
