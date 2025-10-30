class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2 != 0)
            return false;
        int n=nums.length;
        Boolean[][] dp = new Boolean[n][sum/2+1];
        return sum(nums,n,1,sum/2,dp);

        // return dp[nums.length-1][sum/2];
    }

    private boolean sum(int[] nums, int n, int i, int sum, Boolean[][] dp){
        if(sum==0)
            return true;
        if(i==n || sum<0)
            return false;
        if(dp[i][sum]!=null)
            return dp[i][sum];
        return dp[i][sum] = sum(nums, n, i+1, sum-nums[i], dp) || sum(nums, n, i+1, sum, dp);
    }
}