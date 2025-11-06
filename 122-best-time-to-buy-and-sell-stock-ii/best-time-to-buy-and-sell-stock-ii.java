class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n+1][2];

        for(int r=n-1;r>=0;r--){
            for(int c=0;c<=1;c++){
                if(c==0){
                    // buy or skip
                    dp[r][c]=Math.max(-prices[r]+dp[r+1][1],dp[r+1][0]);
                }
                else{
                    // sell or skip
                    dp[r][c]= Math.max(prices[r]+dp[r+1][0],dp[r+1][1]);
                }
            }
        }
        return dp[0][0];
    }
}