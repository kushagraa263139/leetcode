class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
    dp.add(new ArrayList<>()); // add empty lists or placeholders
}
        List<Integer> lastList = new ArrayList<>(triangle.get(n-1));
        dp.set(n - 1, lastList);
        for(int row=n-2;row>=0;row--){
            List<Integer> temp = new ArrayList<>();
            List<Integer> t = new ArrayList<>(triangle.get(row));
            for(int i=0;i<t.size();i++){
                int val = t.get(i)+Math.min(dp.get(row+1).get(i),dp.get(row+1).get(i+1));
                temp.add(val);
            }
            dp.set(row,temp);
        }
        return dp.get(0).get(0);
    }
}