class Solution {


    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        // set last row and last col as 1
        for(int col=0;col<n;col++){
            dp[m-1][col]=1;
        }
        for(int row=0;row<m;row++){
            dp[row][n-1]=1;
        }

        // dp[i][j]=dp[i+1][j]+dp[i][j+1]
        for(int row=m-2;row>=0;row--){
            for(int col=n-2;col>=0;col--){
                dp[row][col]=dp[row+1][col]+dp[row][col+1];
            }
        }

        return dp[0][0];
    }
}