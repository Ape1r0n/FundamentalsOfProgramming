public class FairFriends extends MiniJava{
    public static int[] fairFriends(int[] a,int[] b){
        int sum1 = 0, sum2 = 0;
        int[] result = new int[2];

        for(int element: a){
            sum1 += element;
        }

        for(int element: b){
            sum2 += element;
        }

        int comp = (sum1 + sum2)/2;

        if(sum1 > comp){
            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < b.length; j++) {
                    if (a[i] - b[j] == sum1 - comp) {
                        result[0] = a[i];
                        result[1] = b[j];
                    }
                }
            }
        }else{
            for(int i = 0; i < b.length; i++){
                for(int j = 0; j < a.length; j++) {
                    if (b[i] - a[j] == comp - sum1) {
                        result[0] = a[j];
                        result[1] = b[i];
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] A = {1,1};
        int[] B = {2,2};
        int[] C = fairFriends(A,B);

        write(C[0]);
        write(C[1]);
    }
}