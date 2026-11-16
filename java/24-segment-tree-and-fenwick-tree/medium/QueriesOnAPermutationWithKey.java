// Time = ((m+q)*log(m+q))   ,   Space = O(m+q)
public class QueriesOnAPermutationWithKey {
    private int[] bit;
    
    public int[] processQueries(int[] queries, int m) {
        int q = queries.length, front = q;
        this.bit = new int[m + q + 1];
        int[] pos = new int[m + 1];
        int[] result = new int[q];
        for (int value = 1; value <= m; value++) 
            {pos[value] = q + value;    add(pos[value], 1);}
        for(int i=0; i<q; i++){
            int index = pos[queries[i]];
            result[i]=prefixSum(index - 1);
            add(index, -1);
            add(front, 1);
            pos[queries[i]]=front;
            front--;
        }
        return result;
    }

    private int prefixSum(int i) {
        int sum = 0;
        while (i > 0) {sum += bit[i];    i -= i & -i;}
        return sum;
    }

    private void add(int i, int delta) {
        while (i < bit.length)  {bit[i] += delta;    i += i & -i;}
    }
}
