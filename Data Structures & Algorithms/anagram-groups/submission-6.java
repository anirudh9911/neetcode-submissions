class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> answer = new ArrayList<>();

        if(strs.length == 1){
            answer.add(new ArrayList<>(List.of(strs)));
            return answer;
        }
        Map<String, List<String>> mp = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            int[] arr = new int[26];
            for(int j =0 ; j < str.length(); j++){
                arr[str.charAt(j) - 'a']++;
            }
            String freqString = "";
            for(int j = 0; j < 26; j++){
                freqString =freqString+ Integer.toString(arr[j])+ ",";
            }
            // System.out.println(freqString);
            if(!mp.containsKey(freqString)){
                mp.put(freqString, new ArrayList<>());
            }            
            mp.get(freqString).add(strs[i]);
        }

        for(List<String> ls : mp.values()){
            answer.add(ls);
        }
        return answer;
    }
}
