// Time = O((n^2)*(2^n))    ,    Space = O(n*2^n)
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTrack(res,new ArrayList<>(),s,0);
        return res;
    }

    public void backTrack(List<List<String>> res, List<String> p, String s, int j){
        if (j>=s.length())  {res.add(new ArrayList<>(p));  return; }   
        for (int i = s.length() - j; i > 0; i--){
            if (isPali(s.substring(j, j + i))) {
                p.add(s.substring(j, j + i));
                backTrack(res,p,s,j+i);
                p.remove(p.size() - 1);
            }
        }
    }

    public boolean isPali(String s){
        int left=0, right=s.length()-1;
        while (right>=left){
            if(s.charAt(left)!=s.charAt(right))   return false;
            right--;    left++;
        }
        return true;
    }
}
