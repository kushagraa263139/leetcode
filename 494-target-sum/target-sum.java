class Solution {
    int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int [][] dp = new int[n+1][target+1];
        
        dp[n][0]=1;
        
        for(int r=dp.length-2;r>=0;r--){
            for(int s=0;s<=target;s++){
                if(s>=nums[r]){
                    dp[r][s]=dp[r+1][s-nums[r]]+dp[r+1][s];
                }
                else dp[r][s]=dp[r+1][s];
            }
        }
        return dp[0][target];
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums) sum=sum+i;
        if(target<0) target=target*-1;
        int fs=(sum+target);
        if(fs%2!=0) return 0;
        fs=fs/2;
        return perfectSum(nums,fs);
    }
}