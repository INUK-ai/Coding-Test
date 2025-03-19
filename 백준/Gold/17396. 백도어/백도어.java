import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] visibility;
    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visibility = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visibility[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            if (visibility[u] == 1 && u != N - 1) continue;
            if (visibility[v] == 1 && v != N - 1) continue;

            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }

        long result = dijkstra();

        System.out.println(result);
    }

    private static long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.cost));
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.index;
            long cost = cur.cost;

            if (cost > dist[node]) continue;

            for (Node next : graph[node]) {
                int nextNode = next.index;
                long nextCost = cost + next.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new Node(nextNode, nextCost));
                }
            }
        }

        return (dist[N - 1] == Long.MAX_VALUE) ? -1 : dist[N - 1];
    }

    public static class Node {
        int index;
        long cost;

        public Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}