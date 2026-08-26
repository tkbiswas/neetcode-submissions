/*
Definition for a Node.
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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        var map = new HashMap<Node, Node>();
        return clone(node, map);
        
    }

    public Node clone(Node node, HashMap<Node, Node> map){
       if(map.containsKey(node)){
            return map.get(node);
        }
        var copy = new Node(node.val);
        map.put(node, copy);
        for(Node item : node.neighbors){
            copy.neighbors.add(clone(item, map));
        }
        return copy;
    }
}