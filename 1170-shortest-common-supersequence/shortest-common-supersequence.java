class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int [][] dp = new int[n+1][m+1];

        for(int r=n-1;r>=0;r--){
            for(int c=m-1;c>=0;c--){
                if(str1.charAt(r)==str2.charAt(c)){
                    dp[r][c]=1+dp[r+1][c+1];
                }
                else{
                    dp[r][c]=Math.max(dp[r+1][c],dp[r][c+1]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int i=0;
        int j=0;

        while(i<n && j<m){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
           
            if(ch1==ch2){
                ans.append(ch1);
                i++;
                j++;
            }
            else{
                if(dp[i+1][j]>=dp[i][j+1]) {
                    ans.append(ch1);
                    i++;
                }
                else{
                    ans.append(ch2);
                    j++;
                }

            }
        }
        while (i < n) ans.append(str1.charAt(i++));
        while (j < m) ans.append(str2.charAt(j++));
        return ans.toString();

    }
}