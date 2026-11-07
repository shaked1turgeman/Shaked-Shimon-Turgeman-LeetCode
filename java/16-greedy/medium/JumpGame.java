// Time = O(n)   ,   Space = O(1)
public class JumpGame {
    public boolean canJump(int[] nums) {
        int temp=0;
        for(int i=0; i<nums.length; i++){
            if (i > temp) return false;
            if(nums[i]+i>=nums.length-1) return true;
            temp = Math.max(temp, i + nums[i]);
        }
        return true;
    }
}
