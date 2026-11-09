// Time = O(log|n|)   ,   Space = O(1)
public class PowXN {
    public double myPow(double x, int n) {
        if (x==0.0 && n==0) return 1.0;
        if(x==0.0)  return 0.0;

        double base=x, result=1.0;
        long exp = n;
        if(exp<0)   exp=-exp;
        while (exp > 0) {
            if (exp % 2 != 0)   result *= base;
            base *= base;
            exp /= 2;
        }
        if(n<0) return (double)1/result;
        return result;
    }
}
