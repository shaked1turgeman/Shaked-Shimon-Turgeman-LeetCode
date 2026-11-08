// Time = O(m*n)   ,   Space = O(min(m,n))
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int rows = Math.max(m, n);
        int cols = Math.min(m, n);
        int[] dp = new int[cols];
        Arrays.fill(dp, 1);
        for (int i = 1; i < rows; i++)  for (int j = 1; j < cols; j++)    dp[j] += dp[j - 1];
        return dp[dp.length-1];
    }
}
