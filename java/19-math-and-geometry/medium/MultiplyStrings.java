// Time = O(m*n)   ,   Space = O(m+n)
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int c=0, m = num1.length(), n = num2.length();
        int[] result = new int[m+n];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int product=0,  d1=num1.charAt(m - i)-'0',d2=num2.charAt(n - j)-'0';
                product = d1*d2;
                result[result.length - i - j + 1] += product;
            }
        }
        for(int i=result.length-1; i>0; i--)
            if(result[i]>9) {result[i-1]+=result[i]/10; result[i]%=10;}
        while (c < result.length && result[c] == 0) c++;
        for(int i=c; i<result.length; i++)  sb.append(result[i]);
        return sb.toString();
    }
}
