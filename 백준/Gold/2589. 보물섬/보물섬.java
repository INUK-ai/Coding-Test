import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int W, H;
    private static char[][] map;

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        // 입력값 받고
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[W][H];

        for (int i = 0; i < W; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // L 하나당 최대 거리 구하고 비교
        int maxDiff = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (map[i][j] == 'L') {
                    int diff = bfs(i, j);
                    maxDiff = Math.max(maxDiff, diff);
                }
            }
        }

        System.out.println(maxDiff);
    }

    private static int bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int[][] visited = new int[W][H];
        visited[x][y] = 1;
        int diff = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if (visited[nx][ny] != 0) continue;
                if (map[nx][ny] == 'W') continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                diff = Math.max(diff, visited[nx][ny]);
            }
        }

        return diff - 1;
    }
}