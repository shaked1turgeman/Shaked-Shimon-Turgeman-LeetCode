// Time: O(n)   ,   Space: O(n) for output
/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    let k=0;
    const res = [];
    while (k < intervals.length && intervals[k][1] < newInterval[0])   
        {res.push(intervals[k]); k++;}
    while (k < intervals.length && intervals[k][0] <= newInterval[1])     {
        newInterval[0]=Math.min(newInterval[0],intervals[k][0]);
        newInterval[1]=Math.max(newInterval[1],intervals[k][1]);
        k++;
    }
    res.push(newInterval);
    while(k<intervals.length)   {res.push(intervals[k]); k++;}
    return res;
};
