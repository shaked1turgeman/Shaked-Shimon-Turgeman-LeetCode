// Time = O(n) average, Space = O(n)
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    const map = new Map();
    const buckets = Array.from({ length: nums.length + 1 }, () => []);
    for(const num of nums)      map.set(num,(map.get(num) ?? 0)+1);
    for (const [num, freq] of map)     buckets[freq].push(num);
    const res = [];
    for (let i = buckets.length - 1; i > 0; i--) {
        for (const num of buckets[i]) {
            res.push(num);
            if (res.length === k) return res;
        }
    }
    return res;
};
