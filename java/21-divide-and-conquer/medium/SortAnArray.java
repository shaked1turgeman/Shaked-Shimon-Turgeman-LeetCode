// Time = O(n*log(n))   ,   Space = O(n)
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        return divideAndConquer(nums,0,nums.length-1);
    }

     private int[] divideAndConquer(int[] nums, int left, int right){
        if(left==right) return new int[] {nums[left]};
        int mid = left + (right - left) / 2;
        int[] arr1 = divideAndConquer(nums,left,mid);
        int[] arr2 = divideAndConquer(nums,mid+1,right);
        int[] res = new int[right-left+1];
        int i1=0, i2=0;
        for(int i =0; i<res.length; i++){
            if(i1==arr1.length)  {
                for(int j=i; j<res.length; j++) {res[j]=arr2[i2]; i2++;}
                break;
            }
            else if(i2==arr2.length)  {
                for(int j=i; j<res.length; j++) {res[j]=arr1[i1]; i1++;}
                break;
            }
            else{
                if(arr1[i1]<=arr2[i2])  {res[i]=arr1[i1];   i1++;}
                else    {res[i]=arr2[i2];   i2++;}
            }
        }
        return res;
    }
}
