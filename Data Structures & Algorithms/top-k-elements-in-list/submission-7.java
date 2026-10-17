class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        int index = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            if(mp.containsKey(num)){
                mp.put(num, mp.get(num)+1);
            }
            else{
                mp.put(num, 1);
            }
        }

        List<Integer>[] hash = new List[n+1];
        
        for(int key : mp.keySet()){
            int freq = mp.get(key);
            if(hash[freq] == null)hash[freq] = new ArrayList<>();
            hash[freq].add(key);
        }

        for(int i = n; i>0; i--){
            if(hash[i] != null){
                for(int it : hash[i]){
                    ans[index] = it;
                    index++;
                    if(index == k){
                        return ans;
                    }
                }
            }
        }
        return new int[0];
    }
}
