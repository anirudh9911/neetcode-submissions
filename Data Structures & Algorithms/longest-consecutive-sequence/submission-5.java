class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        int lastNumber = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] - lastNumber == 1){
                count++;
                lastNumber = nums[i];
            }
            else if(lastNumber != nums[i]){
                count = 1;
                lastNumber = nums[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
