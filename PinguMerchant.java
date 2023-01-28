public class PinguMerchant extends MiniJava{
    public static int[] pinguMerchant(int[] a){
        int min = a[0], indexMin = 0, indexMax = 0, max = 0;

        for(int i=1; i<a.length; i++){
            if(a[i] < min){
                min = a[i];
                indexMin = i;
            }
        }

        for(int j=indexMin; j<a.length; j++){
            if(a[j] > max){
                max = a[j];
                indexMax = j;
            }
        }

        if(indexMax <= indexMin){
            return new int[]{0,0,0};
        } else {
            return new int[]{indexMin, indexMax, max - min};
        }
    }

    public static void main(String[] args){
        int[] arr1 = {7,1,5,3,6,4};
        int[] arr_1 = pinguMerchant(arr1);
        int[] arr2 = {7,6,5,4,3,2,1};
        int[] arr_2 = pinguMerchant(arr2);

        for(int element : arr_1){
            writeConsole(element + "\t");
        }
        write("");
        for(int element : arr_2){
            writeConsole(element + "\t");
        }
    }
}
