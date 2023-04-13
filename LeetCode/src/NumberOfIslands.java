class NumberOfIslands {
    private int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int boundX, boundY;

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boundX = grid.length;
        boundY = grid[0].length;
        int count = 0;
        for(int i = 0; i< boundX; i++){
            for(int j = 0; j< boundY; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if(x < 0 || x >= boundX || y < 0 || y >= boundY || grid[x][y] != '1') return;
        grid[x][y] = '0';
        for(int[] dir : d) dfs(grid, x + dir[0], y + dir[1]);
    }
}
