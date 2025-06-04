import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int r, c, d;

    private static int[][] map;
    private static boolean[][] cleaned;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cleaned = new boolean[N][M];

        st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate(d);

        System.out.println(result);
    }

    private static void simulate(int direction) {

        while (true) {

            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                result++;
            }

            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4;
                int nr = r + dx[direction];
                int nc = c + dy[direction];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (map[nr][nc] == 1 || cleaned[nr][nc]) {
                    continue;
                }

                r = nr;
                c = nc;
                moved = true;
                break;
            }

            if (moved) {
                continue;
            }

            int backDirection = (direction + 2) % 4;
            int backR = r + dx[backDirection];
            int backC = c + dy[backDirection];

            if (map[backR][backC] == 1) {
                break;
            }

            r = backR;
            c = backC;
        }
    }
}