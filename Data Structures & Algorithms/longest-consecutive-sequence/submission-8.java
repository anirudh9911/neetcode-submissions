class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        if(n <= 1){
            return n == 1? 1 : 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        int lastVal = nums[0];
        int currLongest = 1;
        int index = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] - lastVal == 1){
                currLongest++;
                lastVal = nums[i];
            }
            else if(nums[i] - lastVal > 1){
                currLongest = 1;
                lastVal = nums[i];
            }

            longest = Math.max(currLongest, longest);
        }
        return longest;
    }
}
