import java.lang.*;
class Solution {
    public long maxProduct(int[] nums) {

        long firstMax=Integer.MIN_VALUE;
        long secondMax=Integer.MIN_VALUE;
        long firstMin=Integer.MAX_VALUE;
        long secondMin=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=firstMax){
                secondMax=firstMax;
                firstMax=nums[i];
            }else if (nums[i]>secondMax){
                secondMax = nums[i];
            }
            if(nums[i]<=firstMin){
                secondMin=firstMin;
                firstMin=nums[i];
            }else if (nums[i]<secondMin){
                secondMin = nums[i];
            }
        }
        return 100000*Long.max(Math.abs(firstMax*secondMax), Long.max(Math.abs(firstMax*firstMin), Math.abs(firstMin*secondMin)));
    }
}