class Solution {
    public int helper(int[][] mat, int n, int m) {
        int [][] dp = new int[n][m];
        dp[n-1] = mat[n-1].clone();  // clone the last row array to avoid reference assignment

        for (int row = n-2; row >= 0; row--) {
            for (int col = 0; col < m; col++) {
                int ans1 = Integer.MAX_VALUE, ans2, ans3 = Integer.MAX_VALUE;
                if (col != 0) ans1 = dp[row+1][col-1];
                ans2 = dp[row+1][col];
                if (col != m-1) ans3 = dp[row+1][col+1];
                dp[row][col] = mat[row][col] + Math.min(ans1, Math.min(ans2, ans3));
            }
        }

        int fans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            fans = Math.min(fans, dp[0][i]);  // should check dp[0][i] not mat[0][i]
        }
        return fans;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        return helper(matrix, n, m);
    }
}
