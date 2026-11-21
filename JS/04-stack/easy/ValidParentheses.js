// Time: O(n)
// Space: O(n)
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if (s.length % 2 !== 0) return false;
    const stack = [];
    let i=0;
    while(i<s.length){
        if(s[i]==="{" || s[i]==="(" || s[i]==="[") stack.push(s[i]);
        else{
            if(s[i]==="}" && stack[stack.length-1]!=="{")    return false;
            else if(s[i]==="]" && stack[stack.length-1]!=="[")    return false;
            else if(s[i]===")" && stack[stack.length-1]!=="(")    return false;
            stack.pop();
        }
        i++;
    }
    return stack.length===0;
};
