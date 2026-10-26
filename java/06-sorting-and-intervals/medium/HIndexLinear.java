// Time = Space = O(n)
public class HIndexLinear {
    public int hIndex(int[] citations) {
        int sum=0, n=citations.length;
        int[] count = new int[n + 1];
        for (int i=0; i<citations.length; i++)  count[Math.min(citations[i], n)]++;
        for(int j=n; j>=0; j--) {sum+=count[j];    if(sum>=j) return j;}
        return 0;
    }
}
