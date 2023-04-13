public class NumberOfEnclaves{

    int[][] map;

    public int numEnclaves(int[][] grid){
        int m = grid.length, n = grid[0].length, ans = 0;
        map = grid;

        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if((i == 0 || i == m - 1 || j == 0 || j == n - 1) && map[i][j] == 1)
                    dfs(i, j);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1)
                    ans++;
            }
        }

        return ans;
    }

    private void dfs(int i, int j){
        if(i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == 0) return;
        map[i][j] = 0;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}