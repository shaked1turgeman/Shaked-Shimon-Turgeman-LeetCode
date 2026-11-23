// Time: O(n log n)
// Space: O(n) for output, excluding sorting
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    const res = [];
    let k=0;
    while(k < intervals.length){
        let next = intervals[k];
        for(let i = k+1; i < intervals.length; i++){
            if(next[1]>=intervals[i][0])
                {next[1]=Math.max(next[1],intervals[i][1]);  k++;}
            else    break;
        }
        res.push(next);
        k++;
    }
    
    return res;
};
