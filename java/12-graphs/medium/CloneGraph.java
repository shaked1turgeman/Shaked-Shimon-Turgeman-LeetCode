package medium;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Time = O(V+E)   ,   Space = O(V+E)
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)   return null;
        Map<Node, Node> map = new HashMap<>();
        Node curr = new Node(node.val);
        Queue<Node> q = new ArrayDeque<>();
        map.put(node,curr);
        q.offer(node);
        while(!q.isEmpty()){
            Node A = q.poll();
            for (Node i : A.neighbors) {
                if (!map.containsKey(i))   {map.put(i,new Node(i.val));    q.offer(i);} 
                map.get(A).neighbors.add(map.get(i));  
            }
        }
        return curr;
    }
}
