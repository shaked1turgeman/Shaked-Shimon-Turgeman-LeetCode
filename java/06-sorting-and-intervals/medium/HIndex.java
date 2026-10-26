import java.util.Arrays;
// Time = O(n*log(n))   ,   Space = o(n)
public class HIndex  {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h=0, n=citations.length;
        for(int i=citations.length-1; i>=0; i--) {if (citations[i]>=n-i) h=n-i;}
        return h;
    }
}
