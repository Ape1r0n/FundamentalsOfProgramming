public class probabilisticSearch extends MiniJava {
    /**
     * Binary search slightly modified from the lecture
     */
    public static int[] find (int[] a, int x) {
        return find0(a, x, 0, a.length-1, 1);
    }

    public static int[] find0 (int[] a, int x, int n1, int n2, int numberOfSteps) {
        int t = (n1+n2)/2;
        if (a[t] == x)
            return new int[]{t, numberOfSteps};
        else if (n1 >= n2)
            return new int[]{-1, numberOfSteps};
        else if (x > a[t])
            return find0 (a,x,t+1,n2, numberOfSteps + 1);
        else if (n1 < t)
            return find0 (a,x,n1,t-1, numberOfSteps + 1);
        else return new int[]{-1, numberOfSteps};
    }


    public static int[] probalisticSearch(int[] arr, int value) {
        float min = arr[0], max = arr[arr.length - 1], elements = arr.length;
        int counter = 1, i = Math.round((value - min) / ((max - min) / (elements - 1))), temp;

        if (arr[i] > value) {
            while (true) {
                temp = i;
                i -= Math.pow(2,counter - 1);
                counter++;

                if(i < 0){
                    if(arr[0] == value) return new int[]{0, counter};
                    i = 0;
                    break;
                }else if(arr[i] == value){
                    return new int[]{i, counter};
                }else if(arr[i] < value){
                    break;
                }
            }
            return find0(arr, value, i + 1, temp - 1, counter);
        } else if (arr[i] < value) {
            while (true) {
                temp = i;
                i += Math.pow(2,counter - 1);
                counter++;

                if(i > arr.length - 1){
                    if(arr[arr.length - 1] == value) return new int[]{arr.length - 1, counter};
                    i = arr.length - 1;
                    break;
                }else if(arr[i] == value){
                    return new int[]{i, counter};
                } else if (arr[i] > value) {
                    break;
                }
            }
            return find0(arr, value, temp + 1, i - 1,counter);
        } else {
            return new int[]{i, 1};
        }

    }



    public static void compareApproaches(int[] arr, int min, int max) {
        long calls = 0, t_calls = 0;
        int maxCalls = 0, maxCallsCounter = 0, t_maxCalls = 0, t_maxCallsCounter = 0;

        if(min < 0) min = 0;
        if(max >= arr.length) max = arr.length - 1;

        for(int i = min; i <= max; i++){
            int[] findArray = find(arr, i);
            int[] probabilisticArray = probalisticSearch(arr, i);

            if(findArray[1] > maxCalls){
                maxCalls = findArray[1];
                maxCallsCounter = i;
            }

            if(probabilisticArray[1] > t_maxCalls){
                t_maxCalls = probabilisticArray[1];
                t_maxCallsCounter = i;
            }

            calls += findArray[1];
            t_calls+= probabilisticArray[1];
        }

        System.out.println("Binary Search:\nMaximum number of calls\n" + maxCalls + "\nValue at which the maximum number of calls occurs:\n" + maxCallsCounter + "\nNumber of total calls:\n" + calls + "\nProbabilistic Search:\nMaximum number of calls\n" + t_maxCalls + "\nValue at which the maximum number of calls occurs:\n" + t_maxCallsCounter + "\nNumbers of total calls:\n" + t_calls);

    }

    public static void main(String[] args) {
        // Not part of the exercise but can be helpful for debugging purposes
        // int[] exampleArray = new int[]{6, 20, 22, 35, 51, 54, 59, 74, 77, 80, 87, 94, 97};

    }
}