// Time = O(arr.length+queries.length)   ,   Space = O(arr.length+queries.length)
public class XorQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xors = new int[arr.length], res = new int[queries.length] ;
        int xor=0;
        for(int i=0; i<arr.length; i++){xor^=arr[i];    xors[i]=xor;}
        for(int i=0; i<queries.length; i++){
            if  (queries[i][0] == 0) res[i] = xors[queries[i][1]];
            else    res[i] = xors[queries[i][0] - 1] ^ xors[queries[i][1]];
        }
        return res;
    }
}
