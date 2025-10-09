class Solution {
    public int trap(int[] height) {
        int maxheight=Integer.MIN_VALUE;
        int index=0;
        int sum=0;
        int n=height.length;
        for(int i=0; i<n; i++){
            if(maxheight<height[i]){
                maxheight=height[i];
                index=i;
            }
        }
        int leftmax=0;
        for(int i=0; i<index;i++){
            if(height[i]>leftmax)  leftmax=height[i];
            else  sum+=leftmax-height[i];
        }
        int rightmax=0;
        for(int i=n-1; i>index; i--){
            if(height[i]>rightmax)   rightmax=height[i];
            else  sum+=rightmax-height[i];
        }
        return sum;
    }
}