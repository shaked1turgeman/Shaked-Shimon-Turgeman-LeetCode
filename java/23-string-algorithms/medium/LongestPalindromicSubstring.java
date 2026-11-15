// Time = O(n^2)   ,   Space = O(result length)
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start=0, max=0;
        for (int i = 0; i < s.length(); i++) {
            int temp=max;
            int odd = maxLenPali(s, i, i);
            int even = maxLenPali(s, i, i + 1);
            max = Math.max(max, Math.max(odd, even));
            if(temp!=max)   start = i-(max-1)/2;
        }
        return s.substring(start, start + max);
    }

    private int maxLenPali(String s, int left, int right){
        int length = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            length = right - left + 1;
            left--;
            right++;
        }
        return length;
    }
}
