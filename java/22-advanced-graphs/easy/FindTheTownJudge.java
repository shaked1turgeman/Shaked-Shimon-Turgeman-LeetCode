// Time = O(n+E)   ,   Space = O(n)
public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n], out = new int[n];
        for(int i=0; i<trust.length; i++){
            out[trust[i][0]-1]++;
            in[trust[i][1]-1]++;
        }
        for(int i=0; i<n; i++)  if(in[i]==n-1 && out[i]==0) return i+1;
        return -1;
    }
}
