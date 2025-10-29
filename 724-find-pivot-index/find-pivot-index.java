class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int ans =-1;
        for(int i:nums) sum=sum+i;
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            if(prefixSum==sum-nums[i]-prefixSum) return i;
            prefixSum=prefixSum+nums[i];
        }
        return -1;
    }
}