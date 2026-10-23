//  Time = O(n)  ,  Space = O(1)
public class MaxConsecutiveOnesIII {
    public int maxConsecutiveOnesIII(int[] nums, int k) {
        int left=0, right=0, max=0, remain=k;
        while(right<nums.length){
            if(nums[right]==0)  {
                remain--;
                while(remain<0){
                    if(nums[left]==0)   remain++;
                    left++;
                }
            }
            max=Math.max(max,right-left+1);
            right++;  
        }
        return max;
    }
}
