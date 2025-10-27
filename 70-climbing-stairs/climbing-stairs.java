class Solution {
    int [] dp;
    public int helper(int n){
        if(n==1 || n==0) return 1;
        
        if(dp[n-1]==-1) dp[n-1]=helper(n-1);
        if(dp[n-2]==-1) dp[n-2]=helper(n-2);
        return dp[n-1]+dp[n-2];
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
}