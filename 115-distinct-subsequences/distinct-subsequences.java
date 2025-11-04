class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m=  t.length();

        int [][] dp = new int[n+1][m+1];
        for(int r=0;r<=n;r++){
            dp[r][m]=1;
        }

        for(int l1=n-1;l1>=0;l1--){
            for(int l2=m-1;l2>=0;l2--){
                if(n-l1-2>=m-l2-2){
                    if(s.charAt(l1)==t.charAt(l2)){
                        dp[l1][l2]=dp[l1+1][l2+1]+dp[l1+1][l2];
                    }
                    else{
                        dp[l1][l2]=dp[l1+1][l2];
                    }
                }
            }
        }

        return dp[0][0];
    }
}