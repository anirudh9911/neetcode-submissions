class Solution {
    private int[] nr = {-1, 0, 1, 0};
    private int[] nc = {0, -1, 0, 1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0){
                    if(!pacific[i][j]){
                        pacificCheck(heights, pacific, i, j);
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == n-1 || j == m-1){
                    if(!atlantic[i][j]){
                        atlanticCheck(heights, atlantic, i, j);
                    }
                }
            }
        }

        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    out.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return out;
    }


    private void pacificCheck(int[][] grid, boolean[][]pacific, int r, int c){
        int currHeight = grid[r][c];
        pacific[r][c] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < 4; i++){
            int newRow = r + nr[i];
            int newCol = c + nc[i];
            if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m &&!pacific[newRow][newCol] && currHeight <= grid[newRow][newCol]){
                pacificCheck(grid, pacific, newRow, newCol);
            }
        }
    }


    private void atlanticCheck(int[][] grid, boolean[][]atlantic, int r, int c){
        int currHeight = grid[r][c];
        atlantic[r][c] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < 4; i++){
            int newRow = r + nr[i];
            int newCol = c + nc[i];
            if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m &&!atlantic[newRow][newCol] && currHeight <= grid[newRow][newCol]){
                atlanticCheck(grid, atlantic, newRow, newCol);
            }
        }
    }


}
