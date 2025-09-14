class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // create a map and size of map should be eactly k

    HashMap<Integer,Integer> mp = new HashMap<>();
    int l=0;
    int lbada=0;
    int r=0;

    int ans=0;

    while(r<nums.length){


      int x = nums[r];
      if(mp.containsKey(x)) mp.put(x,mp.get(x) +1);
      else mp.put(x,1);

    //   while(l<r && mp.size()>k){
    //       int v=mp.get(nums[l]);
    //       mp.put(v,mp.get(v)-1);
    //       if(mp.get(v)==0) mp.remove(v);
    //       l++;
        
    //   }


            while (l < r && mp.size() > k) {
            int key = nums[l];
            mp.put(key, mp.get(key) - 1);
            if (mp.get(key) == 0) mp.remove(key);
            l++;
            lbada=l;
        }


      if(mp.size()==k){
        // find sabse chota subaaray that is valid

         while(l<r && mp.get(nums[l]) >1 ){
            mp.put(nums[l],mp.get(nums[l])-1);
            if(mp.get(nums[l])==0) mp.remove(nums[l]);
            l++;
        }
        ans=ans+(l-lbada)+1;
    }
    r++;

    }

    return ans;

    }
}