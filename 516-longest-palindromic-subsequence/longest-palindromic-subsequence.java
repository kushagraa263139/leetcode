class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m =text2.length();

        int [][] dp = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                char a = text1.charAt(i);
                char b = text2.charAt(j);
                if(a==b){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s,reversed);
    }
}