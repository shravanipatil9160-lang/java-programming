import java.util.HashMap;

public class SubstringWithKDistinctChars {

    
    public static int countExactlyK(String s, int k) {
        if (k > s.length()) return 0; 
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    
    private static int countAtMostK(String s, int k) {
        if (k == 0) return 0;
        int left = 0, right = 0, result = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            result += right - left + 1;
            right++;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(countExactlyK("pqpqs", 2));        
        System.out.println(countExactlyK("aabacbebebe", 3));  
        System.out.println(countExactlyK("a", 1));            
        System.out.println(countExactlyK("abc", 3));         
        System.out.println(countExactlyK("abc", 2));          
        System.out.println(countExactlyK("aaaa", 1));        
        System.out.println(countExactlyK("abc", 4));          
    }
}
