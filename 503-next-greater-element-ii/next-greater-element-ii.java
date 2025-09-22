class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        // [1,2,1] -> [1,2,1,1,2,1]

        
        int ans [] = new int[nums.length];
        int size= nums.length+nums.length;
        Stack<Integer> st = new Stack<>();
       
        for(int i=size-1;i>=0;i--){
            int acc = i;
            int idx=i%nums.length;
         
            int e = nums[idx];
            while(st.size()>0 && e>=st.peek()) st.pop();
           
            if(acc<nums.length){
                if(st.size()==0) ans[idx]=-1;
                else ans[idx]=st.peek();
            }
            st.push(e);
        }

        return ans;
    }
}