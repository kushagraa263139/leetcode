class Solution {
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int [][] dp = new int[row][col];

        // set base case
        dp[row-1][col-1]=grid[row-1][col-1];

        // set last row and col

        for(int c=col-2;c>=0;c--){
            dp[row-1][c]=grid[row-1][c]+dp[row-1][c+1];
        }

        for(int r=row-2;r>=0;r--){
            dp[r][col-1]=grid[r][col-1]+dp[r+1][col-1];
        }

        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
                dp[i][j]=grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}