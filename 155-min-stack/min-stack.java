import java.util.Stack;

class MinStack {
    
    Stack<Integer> st ;
    int currmin=0;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        // pushn the current element along with current min
        int premin=0;
        if(st.size()==0) premin=Integer.MAX_VALUE;
        else premin=st.peek();
        st.push(val);
        if(val<=premin) st.push(val);
        else st.push(premin);
    }
    
    public void pop() {
        st.pop();
        st.pop();
        
    }
    
    public int top() {
        int t=st.pop();
        int e = st.pop();
st.push(e);
        st.push(t);
       
        return e;
    }
    
    public int getMin() {
        return st.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */