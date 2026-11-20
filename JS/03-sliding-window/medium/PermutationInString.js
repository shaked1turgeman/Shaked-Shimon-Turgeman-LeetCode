// Time: O(n + m)
// Space: O(1)
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function(s1, s2) {
    if (s1.length > s2.length) return false;
    let l=0, r=s1.length;
    const arr1 = Array(26).fill(0), arr2 = Array(26).fill(0);
    for(let i=0; i<s1.length; i++)  arr1[s1[i].charCodeAt(0) - 97]++;
    for(let i=0; i<s1.length; i++)  arr2[s2[i].charCodeAt(0) - 97]++;
    if(sameFrequency(arr1,arr2))    return true;
    while(r<s2.length){
        arr2[s2[l].charCodeAt(0) - 97]--;
        l++;
        arr2[s2[r].charCodeAt(0) - 97]++;
        if(sameFrequency(arr1,arr2))    return true;
        r++;
    }
    return false;
};

function sameFrequency(a, b) {
    for (let i = 0; i < 26; i++) {
        if (a[i] !== b[i]) return false;
    }
    return true;
}
