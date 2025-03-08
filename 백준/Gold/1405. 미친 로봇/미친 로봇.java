import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static double[] probabilities = new double[4];
    private static boolean[][] visited;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static double result = 0.0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            probabilities[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited = new boolean[2 * N + 1][2 * N + 1];
        visited[N][N] = true;

        backtrace(N, N, 0, 1.0);

        System.out.printf("%.9f", result);
    }

    private static void backtrace(int x, int y, int step, double probability) {

        if (step == N) {
            result += probability;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            backtrace(nx, ny, step + 1, probability * probabilities[i]);
            visited[nx][ny] = false;
        }
    }
}