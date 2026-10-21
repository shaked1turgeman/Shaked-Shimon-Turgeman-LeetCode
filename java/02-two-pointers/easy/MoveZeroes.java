//Time = O(n) , Space = O(1)
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0 && nums[j]!=0)    j=i;
            if(nums[i]!=0 && nums[j]!=0)    continue;
            if(nums[i]!=0 && nums[j]==0)    {nums[j]=nums[i];  nums[i]=0;}
            while(nums[j]!=0)  j++;
        }
    }
}
