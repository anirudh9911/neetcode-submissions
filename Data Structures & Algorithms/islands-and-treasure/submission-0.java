class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int[] nr = {-1, 0, 1, 0};
        int[] nc = {0, -1, 0, 1};

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int d = arr[2];
            for(int i =0; i < 4; i++){
                int row = r + nr[i];
                int col = c + nc[i];
                if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 2147483647){
                    grid[row][col] = d+1;
                    q.offer(new int[]{row, col, d + 1});
                }
            }
        }
        
    }
}
