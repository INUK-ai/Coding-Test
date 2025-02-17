import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int R, C, K;
    private static char[][] map;

    private static int caseNum = 0;
    private static boolean[][] visited;

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        backtrace(0, 0, R - 1);

        System.out.println(caseNum);
    }

    private static void backtrace(int depth, int x, int y) {

        if (depth == K - 1) {
            if (x == C - 1 && y == 0) {
                caseNum++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
            if (visited[ny][nx] || map[ny][nx] == 'T') continue;

            visited[ny][nx] = true;
            backtrace(depth + 1, nx, ny);
            visited[ny][nx] = false;
        }
    }
}
