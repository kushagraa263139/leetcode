class Solution {
    // public int helper(int start, int end, String s){
    //     if(start>=end) return 0;

    //     if(s.charAt(start)==s.charAt(end)) return helper(start+1,end-1,s);
    //     return 1+Math.min(helper(start+1,end,s),helper(start,end-1,s));
    // }
    public int minInsertions(String s) {
        int n = s.length();
        int [][] dp = new int[n][n];
        for(int start=n-2;start>=0;start--){
            for(int end=0;end<n;end++){
                if(start<end){
                    if(s.charAt(start)==s.charAt(end)) dp[start][end]=dp[start+1][end-1];
                    else dp[start][end] = 1 +Math.min(dp[start+1][end],dp[start][end-1]);
                }
            }
        }
        // return helper(0,s.length()-1,s);
        return dp[0][n-1];
    }
}