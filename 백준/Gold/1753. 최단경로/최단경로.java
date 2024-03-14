import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Edge>[] graph;
    static int[] dist;
    static boolean[] visited;

    static class Edge implements Comparable<Edge> {
        int targetId;
        int cost;

        public Edge(int targetId, int cost) {
            this.targetId = targetId;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(bf.readLine());

        graph = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        dist = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
        }

        dijkstra(start, V);

        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void dijkstra(int start, int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if(visited[current.targetId]) {
                continue;
            }

            visited[current.targetId] = true;

            for(Edge next : graph[current.targetId]) {
                if(dist[next.targetId] > dist[current.targetId] + next.cost) {
                    dist[next.targetId] = dist[current.targetId] + next.cost;
                    pq.offer(new Edge(next.targetId, dist[next.targetId]));
                }
            }
        }
    }
}
