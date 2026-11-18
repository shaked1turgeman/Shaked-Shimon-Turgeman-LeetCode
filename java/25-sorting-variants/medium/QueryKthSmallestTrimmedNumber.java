// Time = O(n*d+q)   ,   Space = O(n*d)
public class QueryKthSmallestTrimmedNumber {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length, d = nums[0].length();
        int[] result = new int[queries.length];
        int[][] sorted = new int[d + 1][n];
        for (int i = 0; i < n; i++)     sorted[0][i] = i;
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++)    buckets[i] = new ArrayList<>();
        //Radix Sort
        for(int i=d-1; i>=0; i--){
            int trim = d - i;
            for (int j : sorted[trim - 1]) {
                int digit = nums[j].charAt(i) - '0';
                buckets[digit].add(j);
            }
            int index = 0;
            for (int b = 0; b < 10; b++) {
                for (int value : buckets[b])    sorted[trim][index++] = value;
                buckets[b].clear();
            }
        }
        //Checking the querie
        for(int i=0; i<queries.length; i++) 
            result[i]=sorted[queries[i][1]][queries[i][0]-1];
        return result;
    }
}
