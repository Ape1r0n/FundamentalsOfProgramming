public class ArrayOperations{

    public static int square(int[] v){
        int res = 0;
        for(int element : v) res += element*element;
        return res;
    }

    public static int[][] scalarMultiplication(int[][] m, int s) {
        if (m.length == 0 || m[0].length == 0) {
            return new int[][]{};
        } else {
            int[][] newArr = new int[m.length][m[0].length];
            for(int i = 0; i < m.length; i++){
                for(int j = 0; j < m[i].length; j++){
                    newArr[i][j] = s * m[i][j];
                }
            }
            return newArr;
        }
    }

    public static int[][] transpose(int[][] m) {
        if (m.length == 0 || m[0].length == 0) {
            return new int[][]{};
        } else {
            int[][] arr = new int[m[0].length][m.length];

            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    arr[j][i] = m[i][j];
                }
            }

            return arr;
        }
    }

    public static void main(String[] args) {
//        int[][] arr = { {23, 24, 25},
//                        {32, 64, 78},
//                        {12, 76, 113},
//                        {15, 67, 123}};
//        int[][] arr2 = transpose(arr);
//        for(int i=0; i<arr.length; i++){
//            for(int j=0; j<arr2[0].length; j++){
//                System.out.print(arr2[i][j] + " ");
//            }
//            System.out.println();
//        }

//        int[] v = {1,2,3,4};
//        System.out.println(square(v));

        int[][] a = { {1,5,1},
                      {2,7,2},
                      {3,8,3},
                      {4,4,9}};
        int[][] a2 = scalarMultiplication(a,5);
        for(int i=0; i<a2.length; i++){
            for(int j=0; j<a2[i].length; j++){
                System.out.print(a2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
