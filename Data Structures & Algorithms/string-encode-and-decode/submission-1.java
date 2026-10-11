class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0)return "";   
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();
        List<String> strs = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            StringBuilder curr = new StringBuilder();
            while(str.charAt(i) != '#'){
                curr.append(str.charAt(i));
                i++;
            }
            i++;
            int length = Integer.parseInt(curr.toString());
            strs.add(str.substring(i, i + length));
            i += length;
        }
        return strs;
    }
}
