
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i], mp.get(nums[i])+1);
            }
            else{
                mp.put(nums[i], 1);
            }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            list.add(new ArrayList<>());
        }
        
        for(int key : mp.keySet()){
            list.get(mp.get(key)).add(key);
        }
        int index = 0;
        for(int i = nums.length; i >0; i-- ){
            if(list.get(i).size() != 0){
                for(int it : list.get(i)){
                    ans[index] = it;
                    index++;
                    if(index == k){
                        return ans;
                    }
                }
            }
        }
        return ans;



    }
}
