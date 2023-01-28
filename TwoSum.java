import java.util.Scanner;

public class TwoSum{
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i < nums.length; i++){
            for(int j=0; j < nums.length; j++){
                if((i != j) && (nums[i] + nums[j] == target)){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        if(result[1] < result[0]){
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            System.out.println("Enter element " + (i+1) + " of the array");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter target number:");

        int target = scanner.nextInt();
        int[] result = twoSum(arr, target);

        System.out.print("result = [" + result[0] + ", " + result[1] + "]");
    }
}
