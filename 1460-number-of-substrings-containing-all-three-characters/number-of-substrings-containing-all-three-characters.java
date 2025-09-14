class Solution {
    public int numberOfSubstrings(String s) {

        int count=0;
        int l=0;
        int r=0;
        boolean check = true;
        HashMap<Character,Integer> mp = new HashMap<>();

        while(r<s.length()){

            if(check){
                if(mp.containsKey(s.charAt(r))) mp.put(s.charAt(r),mp.get(s.charAt(r))+1);
                else mp.put(s.charAt(r),1);
            }
          

          if(mp.size()==3){
            check = false;
            int rem = s.length()-r;
            count=count+rem;
            mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
            if(mp.get(s.charAt(l)) == 0) mp.remove(s.charAt(l));
            l++;
            if(l==r) {
                check = true;
                r++;
            }

          }
          else{
            check = true;
            r++;
          }
          

        }
        return count;
        
    }
}