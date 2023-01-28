public class TrivialArrayOperations extends MiniJava{
    public static void print(int[] arr) {
        writeConsole("{");
        for(int i=0; i<arr.length; i++){
            if(i != (arr.length-1))
                writeConsole(arr[i] + ", ");
            else
                writeConsole(arr[i]);
        }
        writeConsole("}");
    }

    public static void minAndMax(int[] arr){
        int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE;
        for(int number : arr){
            if(number < minimum){
                minimum = number;
            }else if(number > maximum){
                maximum = number;
            }
        }
        writeConsole("Minimum = " + minimum + ", Maximum = " + maximum);
    }

    public static int[] invert(int[] arr){
        int[] rArr = new int[arr.length];
        int counter = 0;
        for(int j=(arr.length-1); j>=0;--j){
                rArr[j] = arr[counter];
                ++counter;
        }
        return rArr;
    }

    public static int[] cut(int[] arr, int len){
        int[] newArr = new int[len];
        if(len <= arr.length){
            for(int i = 0;i<len;++i){
                newArr[i] = arr[i];
            }
        }else if(len > arr.length){
            for(int i=0;i<arr.length;i++){
                newArr[i] = arr[i];
            }
            for(int i=arr.length;i<len;i++){
                newArr[i] = 0;
            }
        }
        return newArr;
    }

    public static int[] linearize(int[][] arr){
        int total_length = 0, counter = 0;
        for(int l[]: arr){
            total_length += l.length;
        }
        int[] oneD = new int[total_length];
        for(int[] l: arr){
            for(int a: l){
                oneD[counter++] = a;
            }
        }
        return oneD;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 3}, {25}, {7, 4, 6, 9}};
        int[] arr2 = linearize(arr1);
        for(int element : arr2) write(element);

        write("TrivialArrayOperations");
    }
}
