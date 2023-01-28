public class Pascal extends MiniJava{
    public static int[][] pascal(int n){
        if(n==1){
            return new int[][]{{1}};
        } else {
            int[][] matrix = new int[n][];
            matrix[0] = new int[1];
            matrix[0][0] = 1;
            matrix[1] = new int[2];
            matrix[1][0] = 1;
            matrix[1][1] = 1;

            for (int i = 2; i < n; i++) {
                matrix[i] = new int[i+1];
                for(int j = 0; j <= i; j++) {
                    if ((j == 0) || (j == i)) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
                    }
                }
            }
            return matrix;
        }
    }

    public static void main(String[] args){
        int rows = readInt("Please insert number of rows:");
        int[][] dasaprinti = pascal(rows);
        for(int k = 0; k < dasaprinti.length; k++){
            writeConsole("n=" + k);
            for(int g = 0; g <= k; g++){
                writeConsole("\t");
                writeConsole(dasaprinti[k][g]);
            }
            write("");
        }
    }
}