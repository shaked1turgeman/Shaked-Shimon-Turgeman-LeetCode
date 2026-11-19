// Time = O(n^2), Space = O(1) excluding sorting and output
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    nums.sort((x, y) => x - y);
    const res = []; 
    for (let i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] === nums[i - 1])  continue;
        let left = i + 1;
        let right = nums.length - 1;
        while (left < right) {
            let sum = nums[i]+nums[left]+nums[right];
            if(sum===0){
                const another = [nums[i],nums[left],nums[right]];
                res.push(another);
                right--;
                left++;
                while (left<right && nums[right]===nums[right+1])   right--;
                while (left<right && nums[left]===nums[left-1])   left++;
            }
            else if(sum>0)  right--;
            else left++;
        }
    }
    return res;
};
