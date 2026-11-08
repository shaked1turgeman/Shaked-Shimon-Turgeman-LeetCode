// Time = O(n)   ,   Space = O(1)
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2)    return Math.min(cost[0], cost[1]);
        int dp1=cost[1], dp2=cost[0],dp=0;
        for(int i=2; i<cost.length; i++){
            dp= cost[i] + Math.min(dp1,dp2);
            dp2=dp1;
            dp1=dp;
        }
        return Math.min(dp1, dp2);
    }
}
