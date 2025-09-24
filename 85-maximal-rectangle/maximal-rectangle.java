class Solution {
    public void  nextSmaller(int [] nextSmall,int [] arr,int n){
        // finds the next smaller element of each element
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
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
    public int largestRectangleArea(int[] heights) {

       int n = heights.length;
       int [] nextSmall =  new int[n];
       int [] preSmall = new int[n];
       nextSmaller(nextSmall,heights,n);
       preSmaller(preSmall,heights,n);
       int ans=0;
       for(int tower=0;tower<n;tower++){
            int area = heights[tower]*(nextSmall[tower]-preSmall[tower]-1);
            ans=Math.max(ans,area);
       }

      return ans; 
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m=matrix[0].length;
        int [][] mat = new int[n][m];
        // fill it
        for(int i=0;i<n;i++){
            if(i==0){
                for(int j=0;j<m;j++){
                    char ch = matrix[i][j];
                    if(ch=='0') mat[i][j]=0;
                    else mat[i][j]=1;
                }
            }
            else{
                for(int j=0;j<m;j++){
                    char ch = matrix[i][j];
                    if(ch=='0') mat[i][j]=0;
                    else mat[i][j]=mat[i-1][j]+1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int [] arr = mat[i];
            int t =largestRectangleArea(arr);
            ans=Math.max(ans,t);
        }

        return ans;
    }
}