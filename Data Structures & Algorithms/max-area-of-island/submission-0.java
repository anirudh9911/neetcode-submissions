class Solution {
    private int[] nr = {-1, 0 ,1, 0};
    private int[] nc = {0, -1, 0, 1};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count = Math.max(count, bfs(grid, vis, i , j));
                }
            }
        }
        return count;
    }


    private int bfs(int[][] grid, boolean[][] vis, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        vis[r][c] = true;
        q.offer(new int[]{r, c});
        count++;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int row = arr[0];
            int col = arr[1];
            for(int i = 0; i < 4; i++){
                int newR = row + nr[i];
                int newC = col + nc[i];

                if(newR >= 0 && newR < n && newC >= 0 && newC < m && grid[newR][newC] == 1 && !vis[newR][newC]){
                    count++;
                    vis[newR][newC] = true;
                    q.offer(new int[] {newR, newC});
                }
            }
        }
        return count;
        
    }
}
