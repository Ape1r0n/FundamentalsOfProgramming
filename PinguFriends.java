public class PinguFriends extends MiniJava{

    public static int countOccurence(int[] a, int x){
        int counter = 0;
        for (int j : a)
            if (j == x)
                counter++;

        return counter;
    }

    public static boolean CheckIfExists(int[] arr1, int x){
        for (int j : arr1) {
            if (j == x) return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,2,3,3};
        int counter = 1, sum = 0, result;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = 0;
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for(int i = 1; i < arr.length; i++)
            if(arr[i - 1] != arr[i]) ++counter;

        int[] arr0 = new int[counter];
        int[] occurenceArr = new int[counter];
        int[] modArr = new int[counter];

        for(int i=0; i<arr0.length; i++){
            for(int j=0; j<arr.length; j++) {
                if (!CheckIfExists(arr0, arr[j])) {
                    arr0[i] = arr[j];
                }
            }
        }

       for(int element = 0; element < arr0.length; element++){
           occurenceArr[element] = countOccurence(arr,arr0[element]);
       }

        for(int k=0; k<modArr.length; k++){
            modArr[k] = (occurenceArr[k]%2);
        }

        boolean davigale = CheckIfExists(modArr,1);

        if(davigale){
            result = 0;
        } else{
            result = modArr.length;
        }

        write(result);
    }
}