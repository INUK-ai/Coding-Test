import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, D;
    static final int INF = Integer.MAX_VALUE;

    public static class Node implements Comparable<Node> {
        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new List[D + 1];

        for(int i = 0; i < D + 1; i++) {
            graph[i] = new ArrayList<>();

            if(i < D) {
                graph[i].add(new Node(i + 1, 1));
            }
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if(end < D + 1) {
                graph[start].add(new Node(end, distance));
            }
        }

        int[] dist = dijkstra(graph);

        System.out.println(dist[D]);
    }

    private static int[] dijkstra(List<Node>[] graph) {

        int[] dist = new int[D + 1];

        Arrays.fill(dist, INF);
        dist[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(dist[current.end] < current.distance) {
                continue;
            }

            for(Node next : graph[current.end]) {
                if(dist[next.end] > dist[current.end] + next.distance) {
                    dist[next.end] = dist[current.end] + next.distance;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }

        return dist;
    }
}