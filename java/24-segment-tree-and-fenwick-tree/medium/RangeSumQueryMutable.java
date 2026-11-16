// Space = O(n)
class NumArray {
    private int[] bit;
    private int[] nums;

    // Time = O(n)
    public NumArray(int[] nums) {
        this.nums=nums;
        this.bit = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            bit[i] += nums[i - 1];
            int parent = i + (i & -i);
            if (parent <= nums.length)    bit[parent] += bit[i];
        }
    }
    //Time = O(log(n))
    public void update(int index, int val) {
        int delta = val-nums[index], i = index+1;
        nums[index] = val;
        while (i <= nums.length) {
            bit[i] += delta;
            i += i & -i;
        }
    }
    //Time = O(log(n))
    private int prefixSum(int i) {
        int sum = 0;
        while (i > 0) {sum += bit[i];    i -= i & -i;}
        return sum;
    }
    //Time = O(log(n))
    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
