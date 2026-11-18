/**
 * @param {number[]} nums
 * @return {boolean}
 */
// Time = O(n) average, Space = O(n)
var containsDuplicate = function(nums) {
    const seen = new Set();
    for(const i of nums){
        if(!seen.has(i)) seen.add(i);
        else return true;
    }    
    return false;
};
