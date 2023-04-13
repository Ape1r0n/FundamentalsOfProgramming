import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class ShortestPathInABinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid){
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1) return -1;

        int[][] actionsOfDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] dist = new int[grid.length][grid.length];
        for(int i=0; i<grid.length; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for(int[] dir : actionsOfDirections){
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid.length && grid[nextRow][nextCol] == 0){
                    if(dist[nextRow][nextCol] > dist[row][col] + 1){
                        dist[nextRow][nextCol] = dist[row][col] + 1;
                        queue.offer(new int[] {nextRow, nextCol});
                    }
                }
            }
        }

        return dist[grid.length-1][grid.length-1] == Integer.MAX_VALUE ? -1 : dist[grid.length-1][grid.length-1];
    }
}