class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        int cnt=0;
        int l=0,r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(r<n && l<m){
            if(g[r]<=s[l]){
                r++;
                cnt++;
            }
            l++;
        }
        return cnt;
    }
}