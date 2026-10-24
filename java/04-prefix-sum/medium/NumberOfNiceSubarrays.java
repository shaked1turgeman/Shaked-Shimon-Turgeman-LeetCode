// Time = Space = O(n)
public class NumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0, result=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i] % 2;
            result += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
