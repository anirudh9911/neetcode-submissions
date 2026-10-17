class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> out = new ArrayList<>();
        int i = 0;
        int n = str.length();
        while(i < n){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int currLen = Integer.parseInt(str.substring(i, j));
            out.add(str.substring(j+1, j+ 1 + currLen));
            i = j + currLen + 1;
        }
        return out;
    }
}
