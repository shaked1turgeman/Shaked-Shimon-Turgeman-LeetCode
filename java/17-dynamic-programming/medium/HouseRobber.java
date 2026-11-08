// Time = O(n)   ,   Space = O(1)
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length==1)    return nums[0];
        int dp1=Math.max(nums[1],nums[0]), dp2=nums[0],dp=0;
        for(int i=2; i<nums.length; i++){
            dp= Math.max(dp1,dp2 + nums[i]);
            dp2=dp1;
            dp1=dp;
        }
        return dp1;
    }
}
