public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int counter = 0;
        for(int i=0; i<strs[0].length(); i++){
            int k = 1;
            for(int j=0; j<strs.length; j++){
                if(counter >= strs[j].length() || strs[j].charAt(counter) != strs[0].charAt(counter)){
                    k = 0;
                    break;
                }
            }
            if(k == 1)
                counter++;
            else
                break;

        }
        return strs[0].substring(0,counter);
    }

    public static void main(String[] args) {
        String[] arr = {"Mariam Garuchava", "Mariam Gogoxia", "Mariam Ilashvili", "Mariam Gadelia", "Mariam Khokiashvili"};
        String result = longestCommonPrefix(arr);
        System.out.println("Answer: " + result);
    }

}
