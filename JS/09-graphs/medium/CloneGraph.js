// Time: O(V + E)   ,   Space: O(V)
/**
 * // Definition for a _Node.
 * function _Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {_Node} node
 * @return {_Node}
 */
var cloneGraph = function(node) {
    const copies = new Map();

    function dfs(current) {
        if (current === null) return null;
        if(copies.has(current))   return copies.get(current); 
        copies.set(current,new _Node(current.val));
        for (const neighbor of current.neighbors)
            copies.get(current).neighbors.push(dfs(neighbor));
        return copies.get(current);
    }

    return dfs(node);
};
