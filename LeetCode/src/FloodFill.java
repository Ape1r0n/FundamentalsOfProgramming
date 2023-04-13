public class FloodFill {
    private int [][] ans, d = {{0,1},{1,0},{0,-1},{-1,0}};
    private int boundX, boundY, oldColor;

    private int[][] floodFill(int[][] image, int sr, int sc, int color) {
        oldColor = image[sr][sc];
        ans = new int[image.length][image[0].length];
        boundX = image.length;
        boundY = image[0].length;
        for(int i=0; i<boundX; i++)
            for(int j=0; j<boundY; j++) ans[i][j] = image[i][j];

        filler(sr, sc, color);
        return ans;
    }

    private void filler(int x, int y, int color){
        if(ans[x][y] == color) return;
        ans[x][y] = color;
        for(int i=0; i<4; i++){
            if(x + d[i][0] >= 0 && x + d[i][0] < boundX && y + d[i][1] >= 0 && y + d[i][1] < boundY){
                if(ans[x+d[i][0]][y+d[i][1]] == oldColor)
                    filler(x+d[i][0], y+d[i][1], color);
            }
        }
    }
}
