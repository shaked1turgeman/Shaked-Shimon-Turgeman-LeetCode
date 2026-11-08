// Time = (n)   ,   Space = O(1)
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length==1)    return nums[0];
        if(nums.length==2)    return Math.max(nums[0],nums[1]);
        int dp1=0, dp2=0;
        dp1=robRange(nums,1,nums.length);
        dp2=robRange(nums,0,nums.length-1);
        return Math.max(dp1,dp2);
    }

    public int robRange(int[] nums, int start, int end){
        int dp1=Math.max(nums[start], nums[start+1]), dp2=nums[start],dp=0;
        for(int i=start+2; i<end; i++){
            dp= Math.max(dp1,dp2 + nums[i]);
            dp2=dp1;
            dp1=dp;
        }
        return dp1;
    }
}
