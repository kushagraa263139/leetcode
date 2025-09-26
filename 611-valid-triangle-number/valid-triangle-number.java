class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
       
        int n = nums.length;
        int ans=0;
        for(int i=n-1;i>1;i--){
            int x = nums[i];
            int a=0;
            int b = i-1;
            while(a<b){
                if(nums[a]+nums[b]<=x) a++;
                else {
                    ans=ans+b-a;
                    b--;
                }
            }
        }
        return ans;
    }
}