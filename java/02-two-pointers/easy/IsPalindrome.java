public class IsPalindrome {
    //time=O(n) space=O(n)
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (Character c : lower.toCharArray())
            if (Character.isLetterOrDigit(c))   sb.append(Character.toLowerCase(c));
        int l=0, r=sb.length()-1;
        while(r>l){
            if(sb.charAt(l)!=sb.charAt(r)) return false;
            l++;    r--;
        }
        return true;
    }

    //time=O(n) space=O(1)
    public boolean isPalindrome1(String s) {
        int l=0, r=s.length()-1;
        while(r>l){
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            while(!Character.isLetterOrDigit(cl)&&r>l)  {l++; cl=s.charAt(l);}
            while(!Character.isLetterOrDigit(cr)&&r>l)  {r--; cr=s.charAt(r);}
            cl=Character.toLowerCase(cl);
            cr=Character.toLowerCase(cr);
            if(cl!=cr) return false;
            r--;    l++;
        }
        return true;
    }
}
