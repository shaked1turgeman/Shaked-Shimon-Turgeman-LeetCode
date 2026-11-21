// Time: O(|s| + |t|)
// Space: O(1)
/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if(t.length>s.length)   return "";
    let l=0, r=0, min=Infinity, start = 0, matched = 0;
    const need = Array(128).fill(0), window = Array(128).fill(0);
    for(let i=0; i<t.length; i++)  need[t.charCodeAt(i)]++;
    while(r<s.length){
        let index = s.charCodeAt(r);
        window[index]++;
        if (window[index] <= need[index])   matched++;
        while(matched === t.length){
            let curr = r - l + 1;
            if(curr<min)    {min=curr;   start=l;}
            let i = s.charCodeAt(l);
            if (window[i] <= need[i])   matched--;
            window[i]--;
            l++;
        }
        r++;
    }
    return min === Infinity ? "" : s.substring(start, start + min);
};
