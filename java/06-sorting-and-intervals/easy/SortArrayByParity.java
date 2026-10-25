// Time = O(n)   ,   Space = O(1)
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int temp=0, left=0, right=nums.length-1;
        while(right>left){
            if(nums[left]%2==0) left++;
            else if(nums[right]%2==1)    right--;
            else {
                temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                right--;
                left++;
            }
        }
        return nums;   
    }
}
