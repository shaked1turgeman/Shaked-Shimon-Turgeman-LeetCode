// Time = O(n)   ,   Space = O(1)
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1)    return 1;
        if(n==2)    return 2;
        int dp1=2, dp2=1;
        for(int i=3; i<=n; i++){
            int temp=dp1;
            dp1+=dp2;
            dp2=temp;
        }
        return dp1;
    }
}
