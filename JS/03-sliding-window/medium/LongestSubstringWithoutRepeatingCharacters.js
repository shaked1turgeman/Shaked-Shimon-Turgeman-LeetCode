// Time: O(n)   ,   Space: O(min(n, |Σ|))
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    const set = new Set();
    let l=0, r=0, max=0;
    while(r<s.length){   
        while(set.has(s[r]))    {set.delete(s[l]); l++;}
        set.add(s[r]);   
        max=Math.max(max,set.size);
        r++;
    }
    return max;
};
