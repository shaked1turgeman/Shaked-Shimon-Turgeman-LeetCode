public class SortColors {
    // Time = O(n)  ,   Space = O(1)    | One pass over the array
    public void sortColors(int[] nums) {
        int r=0,    w=0,    b=nums.length-1, temp=0;
        while (w <= b){
            if(nums[w]==1)  w++;
            else if (nums[w]==0){temp=nums[r];   nums[r]=0;  r++;  nums[w]=temp;    w++;}
            else    {temp=nums[b];   nums[b]=2;  b--;  nums[w]=temp;}
        }
    }



    //Time = O(n)   ,   Space = O(1)    | Two passes over the array
    public void twoPassesSortColors(int[] nums) {
        int r=0,    w=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)  r++;
            else if(nums[i]==1) w++;
        }
        for(int j=0; j<nums.length; j++){
            if(r!=0)    {nums[j]=0; r--;}
            else if(w!=0)   {nums[j]=1; w--;}
            else    nums[j]=2;
        }
    }
}
