public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2)   return false;
        HashMap<Integer,Integer> modulo = new HashMap<>();
        modulo.put(0, -1);
        int sum=0;
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
            int m = sum % k;
            if(modulo.containsKey(m)){
                if(i - modulo.get(m) >= 2)  return true;
                else continue;
            } 
            else modulo.put(m,i);
        }
        return false;
    }
}
