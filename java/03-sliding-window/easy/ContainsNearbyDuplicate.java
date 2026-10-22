import java.util.*;
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int start=0, end=Math.min(nums.length,k+1);
        Set <Integer> set = new HashSet<>();
        for(int i=0; i<end; i++) set.add(nums[i]);
        if(set.size()<end)   return true;
        while(end<nums.length){
            set.remove(nums[start]);
            start++;
            set.add(nums[end]);
            end++;
            if(set.size()<k+1)   return true;
        }
        return false;
    }
}
