// Time: O(n)
// Space: O(n)
/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
    const stack = [], res = Array(temperatures.length).fill(0);
    let i=temperatures.length-1;
    while(i>=0){
        while(stack.length>0 && temperatures[i]>=temperatures[stack[stack.length-1]])
            stack.pop();
        if(stack.length!==0)    res[i]=stack[stack.length-1]-i;
        stack.push(i);
        i--;
    }
    return res;
};
