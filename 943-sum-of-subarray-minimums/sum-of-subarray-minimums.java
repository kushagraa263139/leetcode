class Solution {
    public void  nextSmaller(int [] nextSmall,int [] arr,int n){
        // finds the next smaller element of each element
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            
            while(st.size()>0 && arr[st.peek()]>arr[i]) st.pop();
            if(st.size()==0) nextSmall[i]=n;
            else nextSmall[i]=st.peek();
            st.push(i);
        }
    }

    public void preSmaller(int [] preSmall,int [] arr , int n){
        // find the pre smaller element of each element
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) preSmall[i]=-1;
            else preSmall[i]=st.peek();
            st.push(i);
        }
    }
    public int sumSubarrayMins(int[] arr) {
        
       int n = arr.length;
       int [] nextSmall =  new int[n];
       int [] preSmall = new int[n];
       nextSmaller(nextSmall,arr,n);
       preSmaller(preSmall,arr,n);
       long ans=0;

       for(int i=0;i<n;i++){
        int val=arr[i];
        int pre=preSmall[i];
        int next=nextSmall[i];
        long m = next-i;
        long k = i-pre-1;
       
        ans=(ans+(k+1)*m*val )% 1000000007;

       }

       return (int) ans;
    }
}