// Time = O(1)   ,   Space = O(1)
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int c=0, res=0;
        for( int i=0; i<32; i++){ 
            if( ((a>>i)&1)==1 && ((b>>i)&1)==1 && c==1 )        res |= (1 << i);
            else if( ((a>>i)&1)==0 && ((b>>i)&1)==0 && c==1 )   {res |= (1 << i); c=0;}
            else if( ((a>>i)&1)==0 && ((b>>i)&1)==1 && c==0 )   res |= (1 << i);
            else if( ((a>>i)&1)==0 && ((b>>i)&1)==1 && c==1 )   c=1;
            else if( ((a>>i)&1)==1 && ((b>>i)&1)==0 && c==0 )   res |= (1 << i);
            else if( ((a>>i)&1)==1 && ((b>>i)&1)==0 && c==1 )   c=1;
            else if( ((a>>i)&1)==1 && ((b>>i)&1)==1 && c==0 )   c=1;
        }
        return res;
    }
}
