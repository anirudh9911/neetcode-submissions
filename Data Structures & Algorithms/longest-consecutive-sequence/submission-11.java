class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int it : set){
            if(set.contains(it-1)){
                continue;
            }
            int currLong = 0;
            int currElement = it;
            while(set.contains(currElement)){
                currElement++;
                currLong++;
            }

            longest = Math.max(longest, currLong);
        }
        return longest;
    }
}
