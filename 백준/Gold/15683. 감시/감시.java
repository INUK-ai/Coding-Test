import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M, minBlindSpot = Integer.MAX_VALUE;
    private static int[][] office;
    private static List<CCTV> cctvList = new ArrayList<>();

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static final int[][][] directions = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    private static class CCTV {

        int x, y, type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, office[i][j]));
                }
            }
        }

        dfs(0);

        System.out.println(minBlindSpot);
    }

    private static void dfs(int depth) {

        if (depth == cctvList.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpot());
            return;
        }

        CCTV cctv = cctvList.get(depth);
        int type = cctv.type;

        for (int[] direction : directions[type]) {
            int[][] backup = copyOffice();
            monitor(cctv.y, cctv.x, direction);
            dfs(depth + 1);
            restoreOffice(backup);
        }
    }

    private static void monitor(int y, int x, int[] direction) {

        for (int d : direction) {
            int nx = x, ny = y;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) break;
                if (office[ny][nx] == 6) break;
                if (office[ny][nx] == 0) office[ny][nx] = -1;
            }
        }
    }

    private static int countBlindSpot() {

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) count++;
            }
        }

        return count;
    }

    private static int[][] copyOffice() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = office[i].clone();
        }
        return copy;
    }

    private static void restoreOffice(int[][] backup) {
        for (int i = 0; i < N; i++) {
            office[i] = backup[i].clone();
        }
    }
}
