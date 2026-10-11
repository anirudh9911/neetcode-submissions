
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
        
        List<Integer>[] list = new List[nums.length+1];
        
        
        for(int key : mp.keySet()){
            if(list[mp.get(key)] == null){
                list[mp.get(key)] = new ArrayList<>();
            }
            list[mp.get(key)].add(key);
        }
        int index = 0;
        for(int i = nums.length; i >0; i-- ){
            if(list[i] != null){
                for(int it : list[i]){
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
