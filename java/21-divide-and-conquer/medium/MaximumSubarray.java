// Time = O(n*log(n))   ,   Space = O(log(n))
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums,0,nums.length-1);
    }

    private int divideAndConquer(int[] nums, int left, int right){
        if(left==right) return nums[left];
        int mid = left + (right - left) / 2;
        int suml=divideAndConquer(nums,left,mid);
        int sumr=divideAndConquer(nums,mid+1,right);
        int sum=0, maxSum1=Integer.MIN_VALUE, maxSum2=Integer.MIN_VALUE;
        for(int i=mid; i>=left; i--)   {sum+=nums[i]; maxSum1=Math.max(sum,maxSum1);}
        sum=0;
        for(int i=mid+1; i<=right; i++)  {sum+=nums[i]; maxSum2=Math.max(sum,maxSum2);}
        return Math.max(Math.max(suml, sumr), maxSum1+maxSum2);
    }
}
