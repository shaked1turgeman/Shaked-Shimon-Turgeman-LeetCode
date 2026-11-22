// Time: O(log n)
// Space: O(1)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let l=0, r=nums.length-1;
    while(r>=l){
       let mid = l + Math.floor((r - l) / 2);
       if(nums[mid]>target)     r = mid-1;
       else if(nums[mid]<target)      l = mid+1;
       else return mid;
    }
    return -1;
};
