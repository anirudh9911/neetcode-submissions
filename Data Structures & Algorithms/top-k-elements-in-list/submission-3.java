class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
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
        List<Pair> list = new ArrayList<>();
        for(int key : mp.keySet()){
            Pair p = new Pair(key, mp.get(key));
            list.add(p);
        }

        list.sort((a, b) -> Integer.compare(b.second, a.second));

        for(int i = 0; i < k; i++){
            ans[i] = list.get(i).first;
        }
        return ans;

        



    }
}
