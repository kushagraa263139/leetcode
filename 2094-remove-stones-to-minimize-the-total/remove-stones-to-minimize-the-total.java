class Solution {
    public int minStoneSum(int[] piles, int k) {

        // algo

        // create a maxheap of piles

        int totalStones=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:piles){
            pq.add(i);
            totalStones=totalStones+i;
        }

        // traverse pq
        
        int stonesremoves=0;
        while(pq.size()>0 && k!=0){
            int max=pq.poll();
            stonesremoves=stonesremoves+max/2;
            int rem = max - (max/2);
            if(rem!=0) pq.add(rem);
            k--;
        }
        return totalStones-stonesremoves;
            
    }
}