import java.util.Arrays;

class Solution {
    public long maxProduct(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) nums[i]=nums[i]*-1;
        }
        Arrays.sort(nums);
        return 100000L*nums[nums.length-1]*nums[nums.length-2];
        
    }
}
