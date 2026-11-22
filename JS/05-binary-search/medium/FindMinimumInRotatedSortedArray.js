// Time: O(log n)
// Space: O(1)
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let l = 0, r = nums.length - 1;
    while(r>l){
        let mid = l + Math.floor((r - l) / 2);
        if (nums[mid] > nums[r])  l=mid+1;
        else  r=mid;
    }
    return nums[l];
};
