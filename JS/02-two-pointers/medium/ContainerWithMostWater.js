// Time = O(n), Space = O(1)
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let max=0, l=0, r=height.length-1;
    while(r>l){
        let area = Math.min(height[l], height[r]) * (r - l);
        max=Math.max(max,area);
        if(height[l] > height[r])   r--;
        else l++;
    }
    return max;
};
