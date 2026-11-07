// Time = O(n)   ,   Space = O(1)
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int start = 0, end=nums[0], farthest=0, jumps=1;
        while(end<nums.length-1){
            for (int i =start; i<=end; i++){
                farthest=Math.max(farthest,i+nums[i]);
            }
            start=end+1;
            end=farthest;
            jumps++;
        }
        return jumps;
    }
}
