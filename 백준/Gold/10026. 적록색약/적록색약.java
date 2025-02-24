import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static char[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int normalCount = countAreas(false);
        int blindCount = countAreas(true);

        sb.append(normalCount).append(" ").append(blindCount);
        System.out.println(sb);
    }

    private static int countAreas(boolean isBlind) {

        int count = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                bfs(i, j, map[i][j], isBlind);
                count++;
            }
        }

        return count;
    }

    private static void bfs(int y, int x, char targetChar, boolean isBlind) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[ny][nx]) continue;

                if (!isBlind) {
                    if (map[ny][nx] != targetChar) continue;

                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                } else {
                    if ((targetChar == 'R' || targetChar == 'G') && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    } else if (targetChar == 'B' && map[ny][nx] == 'B') {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}