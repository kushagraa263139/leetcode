class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];

        // set base case to generate amount 0 you have 1 way
        dp[0]=0;
        // define the transition 
        for(int sum=1;sum<=amount;sum++){
            int ans=Integer.MAX_VALUE-1;
            for(int i:coins){
                if(sum>=i) ans=Math.min(ans,1+dp[sum-i]); 
            }
            
            dp[sum]=ans;
        }
        if(dp[amount]==Integer.MAX_VALUE-1) return -1;
        return dp[amount];
    }
}