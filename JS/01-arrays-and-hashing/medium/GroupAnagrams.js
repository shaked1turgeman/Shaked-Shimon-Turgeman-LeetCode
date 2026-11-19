// Time = O(n * (k + 26)) average, Space = O(n)
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const map = new Map();
    for(const str of strs){
        const count = new Array(26).fill(0);
        for (const ch of str) {
            const index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
            count[index]++;
        }
        const key = count.join("#");
        if (!map.has(key)) map.set(key, []);
        map.get(key).push(str);
    }
    return [...map.values()];
};
