// Time = O(n)  ,   Space = O(1)
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left=0, right=0, replacement=0, maxFreq=0, best=0;
        int[] freq = new int[26];
        while(right<s.length()){
            int index = s.charAt(right) - 'A';
            freq[index]++;
            maxFreq = Math.max(maxFreq, freq[index]);
            replacement = (right - left + 1) - maxFreq;
            if(replacement>k){
                freq[s.charAt(left) - 'A']--;
                maxFreq=0;
                for (int count : freq)      maxFreq = Math.max(maxFreq, count);
                left++;
            }
            best = Math.max(best, right - left + 1);
            right++;
        }
        return best;
    }
}
