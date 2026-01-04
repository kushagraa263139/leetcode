class Solution {
    public int maxArea(int[] height) {
        // area = height * width 
        int l=0;
        int r=height.length-1;
        int ans=0;
        while(l<r){
            int lh=height[l];
            int rh=height[r];
            int area = Math.min(lh,rh)*(r-l);
            ans=Math.max(ans,area);

            if(lh>=rh) r--;
            else l++; 
        }
        return ans;
    }
}