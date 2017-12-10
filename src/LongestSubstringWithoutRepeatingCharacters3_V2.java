
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3_V2 {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3_V2 sol = new LongestSubstringWithoutRepeatingCharacters3_V2();
        System.out.println(sol.lengthOfLongestSubstring("abcabxyzqcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
        System.out.println(sol.lengthOfLongestSubstring("cdd"));
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
                System.out.println(set);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
