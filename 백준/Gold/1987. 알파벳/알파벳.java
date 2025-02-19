import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int R, C;
    private static char[][] board;
    private static boolean[] visited = new boolean[26];
    private static int maxDepth = Integer.MIN_VALUE;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        backtrace(0, 0, 1);

        System.out.println(maxDepth);
    }

    private static void backtrace(int y, int x, int depth) {

        maxDepth = Math.max(maxDepth, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
            int index = board[ny][nx] - 'A';
            
            if (visited[index]) continue;
            visited[index] = true;
            backtrace(ny, nx, depth + 1);
            visited[index] = false;
        }
    }
}
