// Time: O(n)
// Space: O(1)
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function(s, k) {
    const freq = Array(26).fill(0);
    let max=0, res=0, l=0, r=0;
    while(r<s.length){
        freq[s.charCodeAt(r) - 65]++;
        max=maxFrequency(freq);
        while(r - l + 1-max>k) {
            freq[s.charCodeAt(l) - 65]--;
            l++;
            max=maxFrequency(freq);
        }
        r++;
        res=Math.max(res,r - l);
    }
    return res;
};

function maxFrequency(freq) {
    let max = 0;
    for (let i = 0; i < 26; i++) {
        max = Math.max(max, freq[i]);
    }
    return max;
}
