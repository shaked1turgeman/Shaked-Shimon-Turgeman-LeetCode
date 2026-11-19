// Time = O(n) average, Space = O(n)
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {
    const set = new Set(nums);
    var max=0;
    for(const c of set){
        if(set.has(c-1))    continue;
        let counter=1, temp=c;
        while(set.has(temp+1))  {
            counter++;
            temp+=1;
        }
        max=Math.max(max,counter);
    }
    return max;
};
