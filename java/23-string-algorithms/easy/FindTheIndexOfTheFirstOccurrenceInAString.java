// Time = O(m+n)   ,   Space = O(m)
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int m = needle.length();
        int[] lps = new int[m];
        int i=1, len=0;
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) 
                { len++;  lps[i] = len;   i++; } 
            else if (len > 0) len = lps[len - 1];
            else { lps[i] = 0;  i++; }
        }
        i=0;
        int j = 0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j))    {j++; i++;}
            else if (j>0) j=lps[j - 1];
            else i++;
            if(j==needle.length())   return i - needle.length();
        }
        return -1;
    }
}
