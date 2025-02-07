import java.util.Arrays;
import java.util.Comparator;

class Solution {

    private static class Node {

        private int depth = 1;
        private Node parent = null;

        public boolean isConnected(Node n) {
            return root() == n.root();
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
        }

        public Node root() {
            if (parent == null) return this;

            return parent.root();
        }
    }

    private static class Edge {

        public final int u;
        public final int v;
        public final int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {

        Edge[] edges = Arrays.stream(costs)
                .map(edge -> new Edge(edge[0], edge[1], edge[2]))
                .sorted(Comparator.comparing(e -> e.cost))
                .toArray(Edge[]::new);

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        int totalCost = 0;
        for (Edge edge : edges) {
            Node n1 = nodes[edge.u];
            Node n2 = nodes[edge.v];

            if (n1.isConnected(n2)) continue;
            n1.merge(n2);
            totalCost += edge.cost;
        }
        return totalCost;
    }
}