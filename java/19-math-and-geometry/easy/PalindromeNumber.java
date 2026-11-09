// Time = O(log(n))   ,   Space = O(1)
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x%10==0 && x!=0) return false;
        if(x<0) return false;
        int left=0, right=0, divisor=1, temp=x;
        while(temp>=10)  {temp/=10; divisor*=10;}
        if(divisor!=0) left  = x / divisor;
        right = x % 10;
        while(right==left && x!=0){
            left  = x / divisor;
            right = x % 10;
            if(left==right) x = (x % divisor) / 10;
            divisor/=100;
        }
        return x==0;
    }
}
