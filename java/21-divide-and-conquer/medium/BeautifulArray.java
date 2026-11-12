// Time = O(n*log(n))   ,   Space = O(n)
public class BeautifulArray {
    public int[] beautifulArray(int n) {
        if(n==1)     return new int[]{1};
        int[] odd = beautifulArray((n+1)/2);
        int[] even = beautifulArray(n/2);
        for(int i=0; i<odd.length; i++) odd[i] = 2 * odd[i] - 1;
        for(int i=0; i<even.length; i++) even[i] = 2 * even[i];
        int[] result = new int[odd.length + even.length];

        System.arraycopy(odd, 0, result, 0, odd.length);
        System.arraycopy(even, 0, result, odd.length, even.length);

        return result;
    }
}
