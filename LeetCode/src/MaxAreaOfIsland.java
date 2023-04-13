public class MaxAreaOfIsland{
    int[][] d = {{1,0}, {0,-1}, {-1,0}, {0,1}};
    int[][] map;
    public int maxAreaOfIsland(int[][] grid){
        int ans = 0, temp;
        map = grid;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j] != 1) continue;
                temp = helper(i, j);
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    private int helper(int x, int y){
        if(map[x][y] == 0) return 0;
        int count = 1;
        map[x][y] = 0;
        for(int i=0; i<4; i++){
            if(x + d[i][0] >= 0 && x + d[i][0] < map.length && y + d[i][1] >= 0 && y + d[i][1] < map[0].length)
                count += helper(x + d[i][0], y + d[i][1]);
        }
        return count;
    }

//    public static void main(String[] args) {
//        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
//        grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0,}};
//        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
//    }
}