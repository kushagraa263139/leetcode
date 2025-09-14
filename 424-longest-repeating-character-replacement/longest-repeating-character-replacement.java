class Solution {
    public int characterReplacement(String s, int k) {

      HashMap<Character,Integer> mp = new HashMap<>();

      int i=0;
      int j=0;
      int ans=0;
      int maxFre=0;

      while(j<s.length()){

        char curr= s.charAt(j);
        if(mp.containsKey(curr)) mp.put(curr,mp.get(curr)+1);
        else mp.put(curr,1);
        maxFre=Math.max(maxFre,mp.get(curr));

        if((j-i+1)-maxFre <= k) ans=Math.max(ans,j-i+1);
        else{
            char st=s.charAt(i);
            mp.put(st,mp.get(st)-1);
            if(mp.get(st)==0) mp.remove(st);
            i++;
        }
        j++;

    } 

    return ans;


    }
}