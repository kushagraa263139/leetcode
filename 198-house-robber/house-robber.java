class Solution {
    int [] dp;
    public int helper(int [] nums, int curr){
        if(curr>=nums.length) return 0;
        // pick this element 
        int res1=0;
        if(dp[curr+2]==-1) res1=nums[curr]+helper(nums,curr+2);
        else res1=nums[curr]+dp[curr+2];
        
        // donot pick this elemnt 
        int res2=0;
        if(dp[curr+1]==-1) res2=helper(nums,curr+1);
        else res2=dp[curr+1];
        
        
        
        dp[curr]=Math.max(res1,res2);
        return Math.max(res1,res2);
    }
    public int rob(int[] nums) {
        dp=new int[nums.length+4];
        Arrays.fill(dp,-1);
        return helper(nums,0);
    }
}