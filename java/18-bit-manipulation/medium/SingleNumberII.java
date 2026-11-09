// Time = O(n)   ,   Space = O(1)
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int res=0, count=0;
        for( int i=0; i<32; i++){
            count=0;
            for(int j=0; j<nums.length; j++){
                if(((nums[j] >> i) & 1)==1) count++;
            }
            if((count%3)==1)  res |= (1 << i);
        }
        return res;
    }
}
