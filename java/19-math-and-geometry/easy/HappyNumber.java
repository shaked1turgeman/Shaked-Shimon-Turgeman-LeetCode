// Time = O(1)   ,   Space = O(1)
public class HappyNumber {
    public boolean isHappy(int n) {
        int slow=n, fast=n;
        while(slow!=1 && fast!=1){
            fast=next(next(fast));
            slow=next(slow);
            if (fast == slow && fast != 1) return false;
        }
        return true;
    }

    public int next(int n){
        int res=0;
        while(n!=0) {int j=n%10; n/=10; res+=j*j;}
        return res;
    }
}
