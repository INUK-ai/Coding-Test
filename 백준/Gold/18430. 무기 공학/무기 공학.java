import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[][] board;
    private static boolean[][] visited;

    private static final int[][] dx = {
            {0,1},
            {0,1},
            {-1,0},
            {-1,0}
    };

    private static final int[][] dy = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    private static int max = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0, 0);

        System.out.println(max);
    }

    private static void backtracking(int x, int y, int sum) {

        if (x == N) {
            max = Math.max(max, sum);
            return;
        }

        int nx = x;
        int ny = y + 1;
        if (ny == M) {
            nx = x + 1;
            ny = 0;
        }

        if (!visited[x][y]) {
            for (int d = 0; d < 4; d++) {
                int ax = x + dx[d][0], ay = y + dy[d][0];
                int bx = x + dx[d][1], by = y + dy[d][1];

                if (isInRange(ax, ay) && isInRange(bx, by)) {
                    if (!visited[ax][ay] && !visited[bx][by]) {
                        visited[x][y] = visited[ax][ay] = visited[bx][by] = true;
                        int strength = board[x][y] * 2 + board[ax][ay] + board[bx][by];
                        backtracking(nx, ny, sum + strength);
                        visited[x][y] = visited[ax][ay] = visited[bx][by] = false;
                    }
                }
            }
        }

        backtracking(nx, ny, sum);
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}