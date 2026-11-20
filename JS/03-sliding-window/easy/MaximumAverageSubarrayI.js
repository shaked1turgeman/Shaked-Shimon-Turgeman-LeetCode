// Time: O(n)
// Space: O(1)
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let n=nums.length, l=0, r=k-1, max=0, tmp=0;
    for(let i=0; i<k; i++)  tmp+=nums[i];
    max=tmp;
    tmp-=nums[l];
    l++;
    r++;
    while(r<n){
        tmp+=nums[r];
        max=Math.max(max,tmp);
        tmp-=nums[l];
        l++;
        r++;
    }
    return max / k;
};
