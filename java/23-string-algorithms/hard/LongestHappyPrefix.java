// Time = O(n)   ,   Space = O(n)
public class LongestHappyPrefix {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i=1, len=0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) 
                { len++;  lps[i] = len;   i++; } 
            else if (len > 0) len = lps[len - 1];
            else { lps[i] = 0;  i++; }
        }
        int length = lps[s.length() - 1];
        return length==0 ? "":s.substring(0,length);
    }
}
