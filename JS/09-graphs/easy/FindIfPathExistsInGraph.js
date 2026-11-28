// Time: O(V + E)   ,   Space: O(V + E)
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} source
 * @param {number} destination
 * @return {boolean}
 */
var validPath = function(n, edges, source, destination) {
    if (source === destination) return true;
    const adj = Array.from({ length: n }, () => []);
    const stack = [source];
    const visited = new Set();
    for (const [u, v] of edges) 
        {adj[u].push(v);    adj[v].push(u);}
    while (stack.length > 0) {
        const node = stack.pop();
        if (visited.has(node)) continue;
        visited.add(node);
        for (const neighbor of adj[node]){
            if(neighbor === destination)    return true;
            if (!visited.has(neighbor))    stack.push(neighbor);
        }
    }
    return false;
};
