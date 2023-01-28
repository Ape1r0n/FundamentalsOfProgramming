public class Alps extends MiniJava{
    public static boolean alps(int[] arr) {
        int max = 0, counter = 0;
        boolean answer = false;

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                counter = i;
            }
        }


        int j = (counter+1);
        while(j < (arr.length-1)) {
            if(arr[j] > arr[j + 1] && arr[j] < arr[j-1]){
                answer = true;
            }else{
                answer = false;
            }

            j++;
        }


        return answer;
    }

    public static void main(String[] args){
        int[] arr = {3,5,6,7,5,3,1};
        boolean answer = alps(arr);
        if(answer)
            write("It is alps");
        else
            write("It is not alps");
    }
}
