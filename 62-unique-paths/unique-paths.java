class Solution {
    int [] [] dp;
    public int helper(int row,int col, int m , int n){
        if(row<0 || col<0 || row>=m || col>=n) return 0;
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=0) return dp[row][col];
        int ans1=helper(row+1,col,m,n); // down
        int ans2=helper(row,col+1,m,n); // right

        return dp[row][col] = ans1+ans2;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        
        return helper(0,0,m,n);
    }
}