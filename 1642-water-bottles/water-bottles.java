class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        int ans =0;
        int emptybottle=0;

        int x = numBottles;
        int z = numExchange;
        
        while(x>0){
            // pila do 
            ans=ans+x;
            emptybottle=emptybottle+x;
            // new bottle kitne bana sakte ho
            x=emptybottle/z;
            // kitne abhi bhi empty raha gaye
            emptybottle=emptybottle%z;
        }
        return ans;
    }
}