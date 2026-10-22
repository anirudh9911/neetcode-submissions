class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<Integer>[] adj = new List[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n ; i++){
            if(!vis[i]){
                count++;
                if(cycleCheck(i, adj, vis)){
                    return false;
                }
            }
        }

        return count == 1;
    }

    private boolean cycleCheck(int i , List<Integer>[] adj, boolean[] vis){
        Queue<int[]>q = new LinkedList<>();
        vis[i] = true;
        q.offer(new int[]{i, -1});

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int curr = arr[0];
            int prev = arr[1];
            for(int nei : adj[curr]){
                if(!vis[nei]){
                    q.offer(new int[]{nei, curr});
                    vis[nei] = true;
                }
                else if(nei != prev){ 
                    return true;
                }
            }
        }
        return false;
    }
}
