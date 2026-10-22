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
        Map<Node, Node> hash = new HashMap<>();
        hash.put(node, new Node(node.val));
        Queue<Node> q = new LinkedList<>();

        q.offer(node);
        while(!q.isEmpty()){
            Node og = q.poll();
            for(Node nei : og.neighbors){
                if(!hash.containsKey(nei)){
                    hash.put(nei, new Node(nei.val));
                    q.offer(nei);
                }

                hash.get(og).neighbors.add(hash.get(nei));
            }
        }
        return hash.get(node);
    }
    
    
}