class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character,Integer> mp = new HashMap<>();

       for(int i=0;i<t.length();i++){
        if(mp.containsKey(t.charAt(i))) mp.put(t.charAt(i),mp.get(t.charAt(i))+1);
        else mp.put(t.charAt(i),1);
       }

        int l=0;
        int r=0;
        int count=0;
        String ans = "";

        while(r<s.length()){
            char ch = s.charAt(r);

            if(mp.containsKey(ch)){
                if(mp.get(ch)>0) count++;
                mp.put(ch,mp.get(ch)-1);
                
            }
           
            if(count==t.length()){
                // ans is found try to minimize it
                int m=l;
                while(m<r && (!mp.containsKey(s.charAt(m)) || mp.get(s.charAt(m))<0)){
                    if(mp.containsKey(s.charAt(m))) mp.put(s.charAt(m),mp.get(s.charAt(m))+1);
                    m++;
                }
                if(ans.length()==0) ans  = s.substring(m,r+1);
                else if(ans.length() > (r - m + 1)) ans = s.substring(m, r + 1);

                mp.put(s.charAt(m),mp.get(s.charAt(m))+1);
                m++; 

                // 2nd valid element
                while(m<r && (!mp.containsKey(s.charAt(m)) || mp.get(s.charAt(m))<0)){
                    if(mp.containsKey(s.charAt(m))) mp.put(s.charAt(m),mp.get(s.charAt(m))+1);
                    m++;
                }
                count--;
                l=m;
            }
            r++;
        }
        return ans;
    }
}