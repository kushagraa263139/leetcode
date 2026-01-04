class Solution {
    public String convert(String s){
        StringBuilder ans = new StringBuilder();
        int [] fre = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            fre[ch-97]++;
        }
        for(int i=0;i<26;i++){
            if(fre[i]!=0){
                ans.append(fre[i]+""+(char)(i+97));
            }
        }
        return ans.toString();

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            String res = convert(s);
            if(mp.containsKey(res)){
                mp.get(res).add(s);
            }
            else {
                List<String> temp= new ArrayList<>();
                temp.add(s);
                mp.put(res,temp);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> i : mp.values()){
            ans.add(i);
        }
        return ans;
    }
}