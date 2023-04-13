class CountSubIslands{

    int[][] map1, map2;
    boolean[][] visited;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        map1 = grid1;
        map2 = grid2;
        visited = new boolean[grid1.length][grid1[0].length];
        int ans = 0;
        boolean isSubIsland;

        for(int i=0; i<grid1.length; i++){
            for(int j=0; j<grid1[0].length; j++){
                if(grid2[i][j] == 1 && !visited[i][j]){
                    isSubIsland = dfs(i, j);
                    if(isSubIsland)
                        ans++;
                }
            }
        }

        return ans;
    }

    private boolean dfs(int i, int j){
        if(i < 0 || i >= map1.length || j < 0 || j >= map1[0].length || map2[i][j] == 0 || visited[i][j]) return true;
        visited[i][j] = true;
        boolean isSubIsland = map1[i][j] == map2[i][j];

        isSubIsland &= dfs(i + 1, j);
        isSubIsland &= dfs(i - 1, j);
        isSubIsland &= dfs(i, j + 1);
        isSubIsland &= dfs(i, j - 1);

        return isSubIsland;
    }
}
