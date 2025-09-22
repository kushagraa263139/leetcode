class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] ans = new int[nums1.length];
        HashMap<Integer,Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=nums2.length-1;i>=0;i--){
            int nge=-1;
            while(st.size()>0 && (st.peek()<=nums2[i])) st.pop();
            if(st.size()>0) nge=st.peek();
            st.push(nums2[i]);
            mp.put(nums2[i],nge);
        }
        for(int i=0;i<nums1.length;i++){
            int e = nums1[i];
            ans[i]=mp.get(e);
        }
        return ans;
    }
}