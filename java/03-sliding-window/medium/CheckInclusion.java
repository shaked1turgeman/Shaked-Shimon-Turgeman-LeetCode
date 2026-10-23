// Time = O(n+m)    ,    Space = O(1)
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int left=0, right=0;
        int[] freq = new int[26];
        int[] windowFreq = new int[26];
        for(int i=0; i<s1.length();i++)     freq[s1.charAt(i) - 'a']++;
        while(right<s2.length()){
            windowFreq[s2.charAt(right) - 'a']++;
            right++;
            if(right-left==s1.length()){
                if (Arrays.equals(windowFreq, freq)) return true;
                windowFreq[s2.charAt(left) - 'a']--;
                left++;
            }
        }
        return false;
    }
}
