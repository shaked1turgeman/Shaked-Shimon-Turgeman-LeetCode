// Time: O(n log M)
// Space: O(1)
/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
var minEatingSpeed = function(piles, h) {
    let l = 1, r = Math.max(...piles);
    while(r>l){
        let mid = l + Math.floor((r - l) / 2), hours = 0;
        for(let pile of piles)    hours += Math.ceil(pile / mid);
        if(hours > h)   l = mid + 1;
        else    r = mid;
    }
    return l;
};
