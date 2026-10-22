class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0;j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j, 0});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[] nr = {-1, 0, 1, 0};
        int[] nc = {0, -1, 0, 1};

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int t = arr[2];
            time = Math.max(t, time);
            for(int i =0; i < 4; i++){
                int row = r + nr[i];
                int col = c + nc[i];
                if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1){
                    grid[row][col] = 2;
                    fresh--;
                    q.offer(new int[]{row, col, t + 1});
                }
            }
        }

        return fresh== 0? time : -1;
        
    }
}
