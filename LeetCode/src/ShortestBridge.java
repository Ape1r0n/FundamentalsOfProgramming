import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    boolean[][] visited;
    int[][] map;
    int[][] actionsOfDirections = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    Queue<int[]> queue;

    public int shortestBridge(int[][] grid) {
        map = grid;
        visited = new boolean[map.length][map.length];
        queue = new LinkedList<>();
        boolean b = false;

        for(int i=0; i<map.length; i++){
            if(b) break;
            for(int j=0; j<map.length; j++){
                if(map[i][j] == 1){
                    dfs(i, j);
                    b = true;
                    break;
                }
            }
        }

        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for(int[] direction : actionsOfDirections){
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if(newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map.length && !visited[newRow][newCol]){
                        if(grid[newRow][newCol] == 1) return steps;
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int row, int col) {
        int n = map.length;
        if(row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || map[row][col] == 0) return;
        visited[row][col] = true;
        queue.offer(new int[]{row, col});
        for(int[] direction : actionsOfDirections)
            dfs(row + direction[0], col + direction[1]);
    }
}