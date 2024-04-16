import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int r1, c1, r2, c2;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs(r1, c1);

        if(visited[r2][c2] == 0) {
            sb.append(-1);
        } else {
            sb.append(visited[r2][c2]);
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = 0;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(visited[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = visited[cx][cy] + 1;
                    }
                }
            }
        }
    }
}