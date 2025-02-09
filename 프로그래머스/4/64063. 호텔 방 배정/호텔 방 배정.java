import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static class Node {

        private int depth = 1;
        private Node parent = null;

        private long max;

        public Node(long value) {
            this.max = value;
        }

        public Node root() {
            if (parent == null) return this;
            return parent.root();
        }

        public boolean isConnected(Node n) {
            return root() == n.root();
        }

        public long max() {
            return root().max;
        }

        public void merge(Node n) {

            if (isConnected(n)) return;

            Node root1 = root();
            Node root2 = n.root();

            if (root1.depth > root2.depth) {
                root2.parent = root1;
            } else if (root2.depth > root1.depth) {
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth += 1;
            }

            root1.max = root2.max = Math.max(root1.max, root2.max);
        }
    }

    public long[] solution(long k, long[] room_number) {

        List<Long> assigned = new ArrayList<>();
        Map<Long, Node> nodes = new HashMap<>();

        for (long number : room_number) {
            if (nodes.containsKey(number)) {
                number = nodes.get(number).max() + 1;
            }

            Node node = new Node(number);
            nodes.put(number, node);

            if (nodes.containsKey(number - 1)) {
                node.merge(nodes.get(number - 1));
            }

            if (nodes.containsKey(number + 1)) {
                node.merge(nodes.get(number + 1));
            }

            assigned.add(number);
        }

        return assigned.stream().mapToLong(Long::longValue).toArray();
    }
}