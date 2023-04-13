import java.util.ArrayList;
import java.util.List;

class PacificAtlanticWaterFlow {
    private int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] map;
    public List<List<Integer>> pacificAtlantic(int[][] matrix){
        List<List<Integer>> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        map = matrix;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfs(canReachPacific, i, 0);
            dfs(canReachAtlantic, i, n - 1);
        }
        for(int j = 0; j < n; j++){
            dfs(canReachPacific, 0, j);
            dfs(canReachAtlantic, m - 1, j);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(canReachPacific[i][j] && canReachAtlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    private void dfs(boolean[][] canReach, int i, int j) {
        canReach[i][j] = true;
        for(int[] dir : d){
            int x = i + dir[0], y = j + dir[1];
            if(x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] >= map[i][j] && !canReach[x][y])
                dfs(canReach, x, y);
        }
    }
}
