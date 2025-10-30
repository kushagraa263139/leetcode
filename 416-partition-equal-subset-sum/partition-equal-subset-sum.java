class Solution {
    public Boolean isSubsetSum(int arr[], int sum) {
        
        boolean [][] dp = new boolean[arr.length+1][sum+1];
        int n = dp.length;
        // set first col as true becoz sum 0 can be generated easily and always
        
        for(int row=0;row<dp.length;row++){
            dp[row][0]=true;
        }
        
        for(int row=n-2;row>=0;row--){
            for(int col=1;col<sum+1;col++){
                
                boolean res1=false,res2=false;
                // take it
                if(col>=arr[row]) res1=dp[row+1][col-arr[row]];
                // skip it
                res2=dp[row+1][col];
                
                dp[row][col]=(res1||res2);
            }
        }
        
        return dp[0][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums) sum=sum+i;
        if(sum%2!=0) return false;
        return isSubsetSum(nums,sum/2);
    }
}