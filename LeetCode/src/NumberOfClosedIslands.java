public class NumberOfClosedIslands{
    int[][] map;

    public int closedIsland(int[][] grid){
        map = grid;
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0 && (i == 0 || i == grid.length-1 || j == 0 || j == grid[0].length-1))
                    markIsland(i, j);
            }
        }

        for(int i=1; i<grid.length-1; i++){
            for(int j=1; j<grid[0].length-1; j++){
                if(grid[i][j] == 0){
                    markIsland(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void markIsland(int i, int j){
        if(i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == 1) return;
        map[i][j] = 1;
        markIsland(i-1, j);
        markIsland( i+1, j);
        markIsland(i, j-1);
        markIsland(i, j+1);
    }

//    public static void main(String[] args) {
//        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
//        grid = new int[][]{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
//        grid = new int[][]{{1,1,1,1,1,1,1}, {1,0,0,0,0,0,1}, {1,0,1,1,1,0,1}, {1,0,1,0,1,0,1}, {1,0,1,1,1,0,1}, {1,0,0,0,0,0,1}, {1,1,1,1,1,1,1}};
//        System.out.println(new NumberOfClosedIslands().closedIsland(grid));
//    }
}