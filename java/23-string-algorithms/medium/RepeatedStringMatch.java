// Time = O(n+m)   ,   Space = O(n+m)
public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int n=a.length(), m=b.length(), min=(m+n-1)/n, res=0;
        StringBuilder sb = new StringBuilder(a);
        if(min>1)   {int i=1;       while(min>i){sb.append(a); i++;}}
        res=strStr(sb.toString(), b);
        if(res!=-1) return min;
        else {sb.append(a);  res=strStr(sb.toString(), b);}
        return res==-1 ? -1:min+1;
    }

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
