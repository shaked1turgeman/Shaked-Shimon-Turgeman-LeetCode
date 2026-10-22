//  Time = O(n)  ,  Space = O(1)
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int check=0, i=0, index=0,sum=0;
        while(index<k){
            check+=nums[index];
            index++;
        }
        sum=check;
        while(index<nums.length){
            check-=nums[i];
            i++;
            check+=nums[index];
            index++;
            if(sum<check)       sum=check;     
        }
        return (double) sum / k;
    }
}
