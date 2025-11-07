class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        HashSet<Integer> st = new HashSet<>();
        for(int i:nums){
            if(i<=min) min=i;
            if(i>=max) max=i;
            st.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!st.contains(i)) ans.add(i);
        }
        return ans;
    }
}