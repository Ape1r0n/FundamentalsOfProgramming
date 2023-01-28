public class HungryPenguin extends MiniJava {
    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
        for(int i=0; i < world.length; i++){
            for(int j=0; j < world[0].length; j++){
                switch (world[i][j]) {
                    case 0 -> writeConsole("L");
                    case 1 -> writeConsole("I");
                    case 2 -> writeConsole("W");
                    case 3 -> writeConsole("S");
                    case 4 -> writeConsole("F");
                }

                if(i == pinguRow && j == pinguColumn)
                    writeConsole("(P)");

                if(j != world[0].length-1)
                    writeConsole("\t");
            }
            write("");
        }
    }


    public static int[][] landDirections = {{1,0},{-1,0},{0,-1},{0,1}};
    public static int[][] iceDirections = {{1,1},{1,-1},{-1,-1},{-1,1}};
    public static int[][] waterDirections = {{3,3},{3,-3},{-3,-3},{-3,3}};
    public static boolean[][] path;

    public static boolean reachable(int[][] world, int pinguRow, int pinguColumn){
        boolean matrixBounds = false;
        switch(world[pinguRow][pinguColumn]){
            case 0:
                path[pinguRow][pinguColumn] = true;
                for(int i=0; i<4; i++){
                    matrixBounds = pinguRow + landDirections[i][0] >= 0 && pinguColumn + landDirections[i][1] >= 0 && (pinguRow + landDirections[i][0]) < world.length && (pinguColumn + landDirections[i][1] < world[0].length);
                    if (matrixBounds && !(path[pinguRow + landDirections[i][0]][pinguColumn + landDirections[i][1]]) && reachable(world, pinguRow + landDirections[i][0], pinguColumn + landDirections[i][1]))
                        return true;
                }
                break;
            case 1:
                path[pinguRow][pinguColumn] = true;
                for(int i=0; i<4; i++){
                    matrixBounds = pinguRow + iceDirections[i][0] >= 0 && pinguColumn + iceDirections[i][1] >= 0 && (pinguRow + iceDirections[i][0]) < world.length && (pinguColumn + iceDirections[i][1] < world[0].length);
                    if (matrixBounds && !(path[pinguRow + iceDirections[i][0]][pinguColumn + iceDirections[i][1]]) && reachable(world, pinguRow + iceDirections[i][0], pinguColumn + iceDirections[i][1]))
                        return true;
                }
                break;
            case 2:
                path[pinguRow][pinguColumn] = true;
                for(int i=0; i<4; i++){
                    matrixBounds = pinguRow + waterDirections[i][0] >= 0 && pinguColumn + waterDirections[i][1] >= 0 && (pinguRow + waterDirections[i][0]) < world.length && (pinguColumn + waterDirections[i][1] < world[0].length);
                    if (matrixBounds && !(path[pinguRow + waterDirections[i][0]][pinguColumn + waterDirections[i][1]]) && reachable(world, pinguRow + waterDirections[i][0], pinguColumn + waterDirections[i][1]))
                        return true;
                }
                break;
            case 3:
                path[pinguRow][pinguColumn] = true;
                return false;
            case 4:
                return true;

        }
        return false;
    }

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn) {
        path = new boolean[world.length][world[0].length];
        return reachable(world,pinguRow,pinguColumn);
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An    example world
     */
    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};
    }

    /**
     * returns the example world 2.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
    }

    /**
     *  You may use the main method for testing your program.
     */
    public static void main(String[] args){
        int pinguRow = 0;
        int pinguColumn = 0;
        int[][] world = generateExampleWorldOne();
        printWorld(world, pinguRow, pinguColumn);
        boolean res = isFishReachable(world, pinguRow, pinguColumn);
        write("" + res);
    }
}
