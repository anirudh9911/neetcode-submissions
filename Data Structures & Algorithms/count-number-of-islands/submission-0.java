class Solution {
    private int[] nr = {-1, 0, 1, 0};
    private int[] nc = {0, -1, 0, 1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] =='1' && !vis[i][j]){
                    count++;
                    bfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][]grid, boolean[][] vis, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        vis[i][j] = true;
        q.offer(new int[]{i, j});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int index = 0; index < 4; index++){
                int rowNum = row + nr[index];
                int colNum = col + nc[index];

                if(rowNum >=0 && rowNum < n && colNum >=0 && colNum < m && grid[rowNum][colNum] == '1' && !vis[rowNum][colNum]){
                    vis[rowNum][colNum] = true;
                    q.offer(new int[]{rowNum, colNum});
                }
            }
        }

    }
}
