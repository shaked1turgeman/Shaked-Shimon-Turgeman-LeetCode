// Time = Space = O(n)
public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int min=nums.length;
        long sum=0, sum2=0;
        for(int i=0; i<nums.length;i++)    sum+=nums[i];
        sum=sum%p;
        if(sum==0)  return 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
            int currentRemainder = (int) (sum2 % p);
            int required = (int) ((currentRemainder - sum + p) % p);
            if (map.containsKey(required))  min = Math.min(i - map.get(required), min);
            map.put(currentRemainder, i);
        }
        if(min==nums.length)    return -1;
        return min;
    }
}
