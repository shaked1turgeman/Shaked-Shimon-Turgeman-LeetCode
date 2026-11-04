// Time = O(2^n)   ,   Space = O(n)
public class SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int currentXor=0;
        return dfs(nums,0,currentXor);
    }

    public int dfs(int[] nums, int i, int currentXor){
        if (i == nums.length)   return currentXor;
        return dfs(nums, i + 1, currentXor) + dfs(nums, i + 1, currentXor ^ nums[i]);
    }
}




// Time = O(n)   ,   Space = O(1)
public class SumOfAllSubsetXORTotalsWithMathTrick {
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int num : nums)    or |= num;
        return or * (1 << (nums.length - 1));
    }
}
