import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int sharkX, sharkY, sharkSize, eatCount = 0, totalTime = 0;

    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {-1, 0, 0, 1};

    private static class Fish {

        int x;
        int y;
        int dist;

        public Fish(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        sharkSize = 2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = j;
                    sharkY = i;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish fish = bfs();
            if (fish == null) break;

            sharkX = fish.x;
            sharkY = fish.y;
            totalTime += fish.dist;
            map[sharkY][sharkX] = 0;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(totalTime);
    }

    private static Fish bfs() {

        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];
        queue.add(new int[]{sharkY, sharkX, 0});
        visited[sharkY][sharkX] = true;

        List<Fish> fishList = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1], dist = cur[2];

            if (dist > minDist) break;

            if (map[y][x] > 0 && map[y][x] < sharkSize) {
                fishList.add(new Fish(y, x, dist));
                minDist = dist;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] > sharkSize) continue;

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx, dist + 1});
            }
        }

        if (fishList.isEmpty()) return null;

        fishList.sort((f1, f2) -> f1.y == f2.y ? f1.x - f2.x : f1.y - f2.y);
        return fishList.get(0);
    }
}
