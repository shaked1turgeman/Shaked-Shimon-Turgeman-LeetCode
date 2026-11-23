// Time: O(n log n)   ,   Space: O(1) excluding sorting
/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    let num = 0, prevEnd = intervals[0][1];
    for(let i = 1; i<intervals.length; i++){
        if(prevEnd<=intervals[i][0])  prevEnd=intervals[i][1];
        else{
            num++;
            prevEnd=Math.min(prevEnd,intervals[i][1]);
        }
    }
    return num;
};
