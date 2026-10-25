// Time = O(log(n)) ,  Space = O(1)
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(right>=left){
            int i = left + (right - left) / 2;
            if(nums[i]<target)  left = i + 1;
            else if (nums[i]==target) return i;
            else right = i - 1;
        }
        return left;
    }
}
