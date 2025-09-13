class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        HashMap<Integer,Integer> mp = new HashMap<>();


        for(int i=0;i<nums.length;i++){

            int se=target-nums[i];
            if(mp.containsKey(se)){
                ans[0]=mp.get(se);
                ans[1]=i;
                return ans;
            }
            else{
                mp.put(nums[i],i);
            }
            
        }
        return ans;


        
        
    }
}