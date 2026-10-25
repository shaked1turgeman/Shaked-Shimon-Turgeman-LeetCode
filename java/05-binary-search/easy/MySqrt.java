// Time = O(log(n))  ,  Space = O(1)
public class MySqrt {
    public int mySqrt(int x) {
        int left=0, right=x;
        while(left<=right){
            int i = left + (right-left)/2;
            long power = (long)i*i;
            if (power>x)  right=i-1;
            else if(power<x) left=i+1;
            else return i;
        }
        return right;
    }
}
