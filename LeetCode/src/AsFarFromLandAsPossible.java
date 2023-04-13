public class AsFarFromLandAsPossible{
    public int maxDistance(int[][] grid){
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int landCount = 0;

        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1) {
                    dist[i][j] = 0;
                    landCount++;
                } else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        if(landCount == 0 || landCount == n * n) return -1;

        int[] queueX = new int[n * n];
        int[] queueY = new int[n * n];
        int queueHead = 0, queueTail = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j] == 0){
                    visited[i][j] = true;
                    queueX[queueTail] = i;
                    queueY[queueTail++] = j;
                }
            }
        }
        while(queueHead < queueTail){
            int x = queueX[queueHead];
            int y = queueY[queueHead];
            queueHead++;
            for(int k=0; k<4; k++){
                if(x + dx[k] >= 0 && x + dx[k] < n && y + dy[k] >= 0 && y + dy[k] < n && !visited[x + dx[k]][y + dy[k]]){
                    visited[x + dx[k]][y + dy[k]] = true;
                    dist[x + dx[k]][y + dy[k]] = dist[x][y] + 1;
                    queueX[queueTail] = x + dx[k];
                    queueY[queueTail] = y + dy[k];
                    queueTail++;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dist[i][j] != Integer.MAX_VALUE && dist[i][j] > ans) ans = dist[i][j];
            }
        }
        return ans;
    }
}
