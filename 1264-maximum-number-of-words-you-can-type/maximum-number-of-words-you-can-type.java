class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        HashSet<Character> st = new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++)  st.add(brokenLetters.charAt(i));
        int ans=0;
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch==' ') {
                ans++;
                continue;
            }
            if(st.contains(ch)){
                int j=i;
                while(j<text.length() && text.charAt(j)!=' ') j++;
                i=j;
            }
            if( i==text.length()-1) ans++;
            
        }
        return ans ;  
        
        
    }
}