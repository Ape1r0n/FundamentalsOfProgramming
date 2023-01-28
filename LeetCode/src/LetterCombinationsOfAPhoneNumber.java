import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0) return list;

        list.add("");

        for(int i=0; i<digits.length(); i++) {
            ArrayList<String> arr = new ArrayList<>();
            String temp = mp.get(digits.charAt(i));

            for(int j=0; j<list.size(); j++){
                for(int p=0; p<temp.length(); p++){
                    arr.add(new StringBuilder(list.get(j)).append(temp.charAt(p)).toString());
                }
            }

            list.clear();
            list.addAll(arr);
        }

        return list;
    }
}