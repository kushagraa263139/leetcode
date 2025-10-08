class Solution {

    public void help(int [] arr,List<List<Integer>> ans,List<Integer> temp,int t,int s){
        if(t==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(s==arr.length || t<0) return;

        temp.add(arr[s]);
        help(arr,ans,temp,t-arr[s],s+1);
        temp.remove(temp.size()-1);
        while(s!=arr.length-1 && arr[s]==arr[s+1]) s++;
        help(arr,ans,temp,t,s+1);
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        help(candidates,ans,new ArrayList<>(),target,0);
        return ans;
        
    }
}