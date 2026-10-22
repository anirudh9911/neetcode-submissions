class Solution {
    private boolean[] vis;
    private Set<Integer> cycle;
    private int cycleStart = -1;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] adj = new List[n+1];

        for(int i = 0; i < n+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        vis= new boolean[n+1];
        cycle = new HashSet<>();
        cycleStart = -1;
        dfs(1, -1, adj);

        for(int i = edges.length -1; i >= 0; i--){
            if(cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])){
                return edges[i];
            }
        }
        return new int[]{};
    }

    private boolean dfs(int node, int prev, List<Integer>[] adj){
        if(vis[node]){
            cycleStart = node;
            return true;
        }
        
        vis[node] = true;
        for(int nei : adj[node]){
            if(nei != prev){
                if(dfs(nei, node, adj)){
                    if(cycleStart != -1) cycle.add(node);

                    if(node == cycleStart){
                        cycleStart = -1;
                        
                    }

                    return true;
                }
            }
        }
        return false;
    }
}
