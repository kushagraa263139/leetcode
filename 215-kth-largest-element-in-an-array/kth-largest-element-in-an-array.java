class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:nums) pq.add(i);
        // pop k-1 elements from it
        while(pq.size()>0 && k!=1){
            pq.poll();
            k--;
        }
        
        return pq.peek();
    }
}