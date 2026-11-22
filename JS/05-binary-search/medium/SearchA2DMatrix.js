// Time: O(log(m * n))
// Space: O(1)
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if(target<matrix[0][0]) return false;
    let m = matrix.length, n = matrix[0].length, r = m-1, l=0;
    while (l < r) {
        let mid = l + Math.ceil((r - l) / 2);
        if (matrix[mid][0] <= target)   l = mid;
        else    r = mid - 1;
    }
    let row = l;
    l=0;
    r=n-1;
    while (l <= r){
        let mid = l + Math.floor((r - l) / 2);
        if(matrix[row][mid]===target)   return true;
        else if(matrix[row][mid]>target) r=mid-1;
        else l=mid+1;
    }
    return false;
};
