class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];
        // set last row and last col as 1
        for(int col=n-1;col>=0;col--){
            if(obstacleGrid[m-1][col]==1) dp[m-1][col]=0;
            else if(col==n-1) dp[m-1][col]=1;
            else dp[m-1][col]=dp[m-1][col+1];
        }
        for(int row=m-1;row>=0;row--){
            if(obstacleGrid[row][n-1]==1) dp[row][n-1]=0;
            else if(row==m-1) dp[row][n-1]=1;
            else dp[row][n-1]=dp[row+1][n-1];
        }

        // dp[i][j]=dp[i+1][j]+dp[i][j+1]
        for(int row=m-2;row>=0;row--){
            for(int col=n-2;col>=0;col--){
                if(obstacleGrid[row][col]==1) dp[row][col]=0;
                else dp[row][col]=dp[row+1][col]+dp[row][col+1];
            }
        }

        return dp[0][0];
    }
}