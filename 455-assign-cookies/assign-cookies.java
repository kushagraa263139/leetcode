class Solution {
    public int findContentChildren(int[] greed, int[] csize) {

    Arrays.sort(greed);
    Arrays.sort(csize);

    int i=0;
    int j=0;
    int ans=0;

    while(i<greed.length && j<csize.length){
      if(csize[j]>=greed[i]){
        i++;
        ans++;
      }
      j++;
      
    }

    return ans;
        
    }
}