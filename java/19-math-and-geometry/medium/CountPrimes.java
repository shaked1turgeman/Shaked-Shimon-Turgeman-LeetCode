// Time = O(n*log(log(n)))   ,   Space = O(n)
public class CountPrimes {
    public int countPrimes(int n) {
        if(n<=2)    return 0;
        boolean[] p = new boolean[n];
        for (int i = 2; i <= n / i; i++) 
            if(p[i]==false)  {for (int j=i*i; j<n; j+=i)  p[j]=true;}
        int c=0;
        for (int i = 2; i < n; i++) {if (!p[i]) c++;}
        return c;
    }
}
