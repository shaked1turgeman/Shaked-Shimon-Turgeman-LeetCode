import java.util.HashSet;
import java.util.Set;
// Time O(n) Space O(n)
class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int maxLen=0;
        Set<Integer> keys = new HashSet<>();
        for(int i=0;i<nums.length;i++)   keys.add(nums[i]);
        for(Integer key : keys){
            if(keys.contains(key-1)) continue;
            else{
                int i=1;
                while(keys.contains(key+i)) i++;
                if(i>maxLen)  maxLen=i; 
            }
        }
        return maxLen;
    }
}
