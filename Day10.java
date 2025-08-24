import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
    
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); 

    
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {

        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input1));

        
        String[] input2 = {""};
        System.out.println(groupAnagrams(input2));

        
        String[] input3 = {"a"};
        System.out.println(groupAnagrams(input3));

    
        String[] input4 = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        System.out.println(groupAnagrams(input4));


        String[] input5 = {"abc", "def", "ghi"};
        System.out.println(groupAnagrams(input5));
    }
}
