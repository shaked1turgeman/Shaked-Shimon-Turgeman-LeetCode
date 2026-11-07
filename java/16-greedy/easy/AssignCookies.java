import java.util.Arrays;

// Time = O(n*log(n) + m*log(m)) 
// Space = O(n*log(n) + m*log(m)) for sorting
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cont=0, ig=0, is=0;
        while(ig<g.length && is<s.length){
            if (g[ig]<=s[is])   {cont++; ig++; is++;}
            else is++;
        }
        return cont;
    }
}
