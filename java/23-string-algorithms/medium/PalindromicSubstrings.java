// Time = O(n^2)   ,   Space = O(1)
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            count += countPali(s, i, i);
            count += countPali(s, i, i + 1);
        }
        return count;
    }

    private int countPali(String s, int left, int right){
        int count=0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
