import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] actionsOfDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                if((curr[0] == 0 || curr[0] == m - 1 || curr[1] == 0 || curr[1] == n - 1) && !(curr[0] == entrance[0] && curr[1] == entrance[1])) return steps;
                for(int[] direction : actionsOfDirections){
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') continue;
                    maze[x][y] = '+';
                    queue.offer(new int[] {x, y});
                }
            }
            steps++;
        }
        return -1;
    }
}