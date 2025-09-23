import java.util.Stack;

class Solution {

    // Next smaller element for each element
    private void nextSmaller(int[] nextSmall, int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nextSmall[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    // Previous smaller element for each element
    private void preSmaller(int[] preSmall, int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            preSmall[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    // Next greater element for each element
    private void nextGreater(int[] nextGreater, int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            nextGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    // Previous greater element for each element
    private void preGreater(int[] preGreater, int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            preGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] nextSmall = new int[n];
        int[] preSmall = new int[n];
        int[] nextGreater = new int[n];
        int[] preGreater = new int[n];

        nextSmaller(nextSmall, nums, n);
        preSmaller(preSmall, nums, n);
        nextGreater(nextGreater, nums, n);
        preGreater(preGreater, nums, n);

        long sumMax = 0, sumMin = 0;
        int mod = 1000000007;  // If modulo is required by problem

        for (int i = 0; i < n; i++) {
            long val = nums[i];
            long leftSm = i - preSmall[i];
            long rightSm = nextSmall[i] - i;
            long leftGr = i - preGreater[i];
            long rightGr = nextGreater[i] - i;

            sumMin += val * leftSm * rightSm;
            sumMax += val * leftGr * rightGr;
        }

        return sumMax - sumMin;
    }
}
