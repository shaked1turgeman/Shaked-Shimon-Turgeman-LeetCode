// Time = O(n)   ,   Space = O(n)
public class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length, r=0, l=0, counter=0, h=0;
        int[] left = new int[n], right = new int[n];
        for(int i=0; i<n; i++){
            if(nums[i]<pivot)   {left[l]=nums[i];   l++;}
            else if(nums[i]>pivot)  {right[r]=nums[i];  r++;}
            else counter++;
        }
        for(int i=0; i<l;  i++) nums[i]=left[i];
        for(int i=l; i<l+counter;  i++) nums[i]=pivot;
        for(int i=l+counter; i<l+counter+r;  i++) {nums[i]=right[h]; h++;}
        return nums;
    }
}
