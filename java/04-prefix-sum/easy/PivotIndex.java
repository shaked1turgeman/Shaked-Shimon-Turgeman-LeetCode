// Time = O(n)  ,   Space = O(1)
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int total=0, left=0;
        for(int i=0; i<nums.length;i++) total+=nums[i];
        for(int i=0;i<nums.length;i++){
            if(total-left-nums[i]==left)    return i;
            left+=nums[i];
        }
        return -1;
    }
}
