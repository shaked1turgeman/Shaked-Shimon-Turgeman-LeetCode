// Time = O(n*log(n))   ,   Space = O(n+k)
public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap <Integer,Integer> map = new HashMap<>();
        Integer[] sorted = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sorted[i] = nums[i]; 
        }
        Arrays.sort(sorted, (a, b) -> {
            int f = Integer.compare(map.get(a), map.get(b));
            if (f == 0)     return Integer.compare(b, a);
            return f;
        });
        for (int i = 0; i < nums.length; i++)   nums[i] = sorted[i];
        return nums;
    }
}
