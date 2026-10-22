class Solution {

    static class Pair{
        String str;
        int time;
        Pair(String str, int time){
            this.str = str;
            this.time = time;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hash = new HashSet<>();
        for(String str : wordList){
            hash.add(str);
        }

        if(!hash.contains(endWord))return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.str;
            int time = curr.time;
            if(word.equals(endWord)){
                return time;
            }
            for(int i = 0; i < word.length(); i++){
                char[] arr = word.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    arr[i] = c;
                    String newWord = new String(arr);
                    if(hash.contains(newWord)){
                        q.offer(new Pair(newWord, time+1));
                        hash.remove(newWord);
                    }
                }
            }
        }

        return 0;



    }
}
