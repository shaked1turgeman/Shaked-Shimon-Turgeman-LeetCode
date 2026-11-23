// Time: O(n log n)   ,   Space: O(1) excluding sorting
/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
    points.sort((a, b) => a[0] - b[0]);
    let pops = 1, right = points[0][1];
    for(let i = 1; i<points.length; i++){
        if(right<points[i][0])  {pops++;    right=points[i][1];}
        else    right = Math.min(right, points[i][1]);
    }
    return pops;
};
