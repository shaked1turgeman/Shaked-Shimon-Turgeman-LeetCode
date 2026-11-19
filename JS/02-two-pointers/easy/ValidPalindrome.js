// Time = O(n), Space = O(1)
/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let right=s.length-1,   left=0;
    while(right>left){
        const lch=s[left].toLowerCase(), rch=s[right].toLowerCase();
        if (!/[a-z0-9]/.test(lch)) left++;
        else if (!/[a-z0-9]/.test(rch)) right--;
        else if(lch!==rch)   return false;
        else    {right--; left++;}
    }
    return true;
};
