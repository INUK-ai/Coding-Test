import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] dist;
    private static List<List<Node>> graph;

    private static final int INF = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node> {

        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        System.out.println(dijkstra(1, N));
    }

    public static int dijkstra(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentIndex = currentNode.index;
            int currentCost = currentNode.cost;

            if (currentCost > dist[currentIndex]) continue;

            for (Node neighbor : graph.get(currentIndex)) {
                int neighborCost = dist[currentIndex] + neighbor.cost;

                if (neighborCost < dist[neighbor.index]) {
                    dist[neighbor.index] = neighborCost;
                    pq.offer(new Node(neighbor.index, neighborCost));
                }
            }
        }

        return dist[end];
    }
}