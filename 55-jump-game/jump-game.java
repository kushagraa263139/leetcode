class Solution {
    public boolean canJump(int[] nums) {


        // at max you have to take nums[i] steps
        int n =nums.length;
        int maxIndex=0;

        for(int i=0;i<n;i++){
            if(maxIndex>=n-1) return true;
            if(i==maxIndex && nums[i]==0) return false;
            maxIndex=Math.max(maxIndex,i+nums[i]);
        }
        return true;
    }
}