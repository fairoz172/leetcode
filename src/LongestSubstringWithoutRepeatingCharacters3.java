
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 sol = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
        System.out.println(sol.lengthOfLongestSubstring("cdd"));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, currLength = 0;

        Queue<String> charQueue = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
            if (charQueue.contains(s.charAt(i)+"")) {
                if(maxLength < currLength){
                    maxLength = currLength;
                }
                while(!charQueue.peek().equalsIgnoreCase(s.charAt(i)+"")){
                    charQueue.remove();
                }
                charQueue.add(s.charAt(i) + "");
                charQueue.remove();
                currLength = charQueue.size();

            }else{
                charQueue.add(s.charAt(i)+"");
                currLength++;
            }
        }
        if(maxLength < currLength){
            maxLength = currLength;
        }

        //System.out.println("charQueue = "+ charQueue);
        return maxLength;
    }
}
