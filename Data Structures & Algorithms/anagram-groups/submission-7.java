class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        Map<String, List<String>> hash = new HashMap<>();

        for(String str : strs){
            int[] arr = new int[26];
            for(int i  = 0; i < str.length(); i++){
                arr[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                sb.append(arr[i]).append(",");
            }

            if(!hash.containsKey(sb.toString())){
                hash.put(sb.toString(), new ArrayList<>());
            }

            hash.get(sb.toString()).add(str);
        }

        for(List<String> ls : hash.values()){
            out.add(ls);
        }
        return out;
    }
}
