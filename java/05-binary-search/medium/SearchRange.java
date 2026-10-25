// Time = O(log(n))  ,  Space = O(1)
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] pos = {-1,-1};
        int left=0, right=nums.length-1;
        //for first pos
        while(right>=left){
            int i = left + (right - left) / 2;
            if(nums[i]<target) left=i+1;
            else if (nums[i]>target)    right=i-1;
            else  {pos[0]=i;  right = i - 1;}
        }
        left=0;
        right=nums.length-1;
        //for second pos
        while(right>=left){
            int i = left + (right - left) / 2;
            if(nums[i]<target) left=i+1;
            else if (nums[i]>target)    right=i-1;
            else  {pos[1]=i;  left=i+1;}
        }
        return pos;
    }
}
