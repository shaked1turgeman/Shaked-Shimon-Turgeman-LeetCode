// Time = O(n)   ,   Space = O(1)
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0, i=0, temp=0;
        for (int num : nums)   xor ^= num;
        temp=xor;
        while((temp&1)!=1)  {temp>>=1; i++;}
        temp=0;
        for (int num : nums) {if(((num>>i)&1)==1)  temp ^= num;}
        return new int[] {temp,temp^xor};
    }
}
