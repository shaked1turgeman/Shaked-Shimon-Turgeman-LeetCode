// Time = O(n*log(n))   ,   Space = O(log(n))
public class MajorityElement {
    public int majorityElement(int[] nums) {
        return divideAndConquer(nums,0,nums.length-1);
    }

    private int divideAndConquer(int[] nums, int left, int right){
        if(left==right) return nums[left];
        int mid = left + (right - left) / 2;
        int num1=divideAndConquer(nums,left,mid);   
        int num2=divideAndConquer(nums,mid+1,right);
        if (num1==num2) return num1;
        int c1=0, c2=0;
        for(int i=left; i<=right; i++){
            if(nums[i]==num1)   c1++;
            else if(nums[i]==num2)  c2++;
        }
        return c2>c1 ? num2:num1;
    }
}
