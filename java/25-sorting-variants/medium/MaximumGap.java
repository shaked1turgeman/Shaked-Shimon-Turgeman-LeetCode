// Time = O(n)   ,   Space = O(n)
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min=nums[0], max=nums[0], n=nums.length;
        for(int i=0; i<n; i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int bucketSize = Math.max(1,(int) Math.ceil((double)(max - min) / (n - 1)));
        int bucketCount = (max - min) / bucketSize + 1;
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for(int num : nums){
            int index = (num - min) / bucketSize;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }
        int maxGap = 0;
        int prevMax = min;
        for(int i=0; i<bucketCount; i++){
            if (bucketMin[i] == Integer.MAX_VALUE)  continue;
            maxGap=Math.max(maxGap,bucketMin[i]-prevMax);
            prevMax=bucketMax[i];
        }
        return maxGap;
    }
}
