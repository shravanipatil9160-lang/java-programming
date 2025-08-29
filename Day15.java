import java.util.HashSet;

public class LongestUniqueSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> seen = new HashSet<>();

        while (right < n) {
            char currentChar = s.charAt(right);

        
            if (!seen.contains(currentChar)) {
                seen.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
            
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); 
        System.out.println(lengthOfLongestSubstring("bbbbb"));    
        System.out.println(lengthOfLongestSubstring("pwwkew"));   
        System.out.println(lengthOfLongestSubstring("abcdefgh")); 
        System.out.println(lengthOfLongestSubstring("a"));       
    }
}
