class Solution {
    public int lcs(String s){
        int n=s.length();
        int [][]dp=new int[n+1][n+1];
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
              dp[i][j]=1+dp[i-1][j-1];
        }
         else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
    public int longestPalindromeSubseq(String s) {
       Callable<Integer>callable=()->lcs(s);
       FutureTask<Integer>future=new FutureTask<>(callable);
       new Thread(future).start();
       try{
        return future.get();
       }catch(Exception e){
        return 0;
       }
    }
}