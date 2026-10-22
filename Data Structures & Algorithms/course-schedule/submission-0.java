class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int count = 0;
        List<Integer>[] adj = new List[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] arr : prerequisites){
            int u = arr[0];
            int v = arr[1];
            adj[v].add(u);
            inDegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int nei : adj[curr]){
                inDegree[nei]--;
                if(inDegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        return count == numCourses;
    }
}
