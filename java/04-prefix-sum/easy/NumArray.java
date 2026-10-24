public class NumArray {
    private int[] nums, prefixSum;

    public NumArray(int[] nums) {
        int sum=0;
        this.nums = new int [nums.length];
        this.prefixSum = new int [nums.length];
        for(int i=0; i<nums.length;i++){
            this.nums[i]=nums[i];
            sum+=nums[i];
            prefixSum[i]=sum;
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return  prefixSum[right]; 
        return prefixSum[right]-prefixSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
