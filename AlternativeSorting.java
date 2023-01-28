public class AlternativeSorting extends MiniJava{
    public static int[] otherSort(int[] a,int[] b){
        int[] masivi = new int[a.length];
        int counter = 0;

        for(int i=0; i < b.length; i++){
            for(int j=0; j< a.length; j++){
                if(a[j]==b[i]){
                    masivi[counter] = a[j];
                    counter++;
                }
            }
        }

        for(int i=0; i<a.length; i++){
            if(!CheckIfExists(b,a[i])){
                masivi[counter] = a[i];
                counter++;
            }
        }


        return masivi;
    }

    public static boolean CheckIfExists(int[] arr1, int x){
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] == x) return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] arr3 = otherSort(arr1, arr2);
        for(int i=0;i<arr3.length;i++){
            write(arr3[i]);
        }
    }
}
