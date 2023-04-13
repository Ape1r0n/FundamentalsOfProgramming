import java.util.LinkedList;
import java.util.Queue;

public class O1Matrix{
    public int[][] updateMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] != 0) result[i][j] = Integer.MAX_VALUE;
                else{
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){
                    result[x][y] = Math.min(result[x][y], result[curr[0]][curr[1]] + 1);
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

        return result;
    }
}
