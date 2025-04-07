import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(dist[N - 1][M - 1]);
    }

    private static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int cost = dist[x][y] + map[nx][ny];
                if (cost < dist[nx][ny]) {
                    dist[nx][ny] = cost;
                    if (map[nx][ny] == 0) {
                        dq.addFirst(new int[]{nx, ny}); // 빈 방은 우선 탐색
                    } else {
                        dq.addLast(new int[]{nx, ny});  // 벽은 뒤에 탐색
                    }
                }
            }
        }
    }
}