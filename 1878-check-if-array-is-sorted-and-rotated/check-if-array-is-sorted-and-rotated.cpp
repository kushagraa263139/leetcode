class Solution {
public:
    bool check(vector<int>& nums) {
        int n = nums.size();
        int curr=1;
        while(curr<n){
            if(nums[curr]<nums[curr-1]) break;
            curr++;
        }
        if (curr == n) return true; 
        if(nums[curr]>nums[0]) return false;
        curr++;
        while(curr<n){
            if(nums[curr]<nums[curr-1] || nums[curr]>nums[0]) return false;
            curr++;
        }
        return true;
    }
};