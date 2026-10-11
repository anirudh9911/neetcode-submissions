class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countZeros = 0;
        int n = nums.length;
        int[] ans = new int[n];
        for(int it : nums){
            if(it == 0){
                countZeros++;
            }
        }

        if(countZeros > 1){
            return ans;
        }
        if(countZeros == 1){
            int prod = 1;
            int index = -1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    prod = prod * nums[i];
                }
                else{
                    index = i;
                }
            }
            ans[index] = prod;
            return ans;
        }
        if(countZeros == 0){
            int prod = 1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    prod = prod * nums[i];
                }
            }
            for(int i = 0; i < n; i++){
                ans[i] = prod/nums[i];
            }
            
        }
        return ans;
    }
}  
