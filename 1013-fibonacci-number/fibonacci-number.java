class Solution {
    int [] dp;
    public int helper(int n){
        if(dp[n]==-1) dp[n]=helper(n-1)+helper(n-2);
        return dp[n];
    }
    public int fib(int n) {
        dp = new int[n+1];
        for(int i=0;i<dp.length;i++) dp[i]=-1;
        dp[0]=0;
        if(dp.length>1) dp[1]=1;
        return helper(n);
    }
}