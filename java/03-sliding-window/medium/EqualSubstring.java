// Time = O(n)  ,  Space = O(1)
public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0, right=0, max=0, remain=maxCost;
        while(right<s.length()){
            if(s.charAt(right)!=t.charAt(right)){
                remain-=Math.abs(s.charAt(right) - t.charAt(right));
                while(remain<0){
                    if(s.charAt(left)!=t.charAt(left))  
                           remain+=Math.abs(s.charAt(left) - t.charAt(left));
                    left++;  
                }
            }
            max=Math.max(right-left+1,max);
            right++;
        }
        return max;
    }
}
