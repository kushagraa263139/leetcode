class Solution {
    

    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            int e = num.charAt(i)-48;
            while(st.size()>0 && k>0 && st.peek()>e){
                k--;
                st.pop();
            }
            st.push(e);
            
        }

        while(k>0){
             st.pop();
             k--;
        }
        StringBuilder ans = new StringBuilder();
        while(st.size()>0) ans.append(st.pop());
        ans.reverse();
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        if(ans.length()==0) return "0";
        return ans.toString();
    }
}