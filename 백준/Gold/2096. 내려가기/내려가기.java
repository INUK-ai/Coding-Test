import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[][] map, minDp, maxDp;

    private static int[] dx = {-1, 0, 1};
    private static int[] dy = {1, 1, 1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][3];
        minDp = new int[N][3];
        maxDp = new int[N][3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            map[0][i] = minDp[0][i] = maxDp[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + map[i][0];
            maxDp[i][1] = Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2])) + map[i][1];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + map[i][2];

            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + map[i][0];
            minDp[i][1] = Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2])) + map[i][1];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + map[i][2];
        }

        int maxScore = Math.max(maxDp[N - 1][0], Math.max(maxDp[N - 1][1], maxDp[N - 1][2]));
        int minScore = Math.min(minDp[N - 1][0], Math.min(minDp[N - 1][1], minDp[N - 1][2]));

        System.out.println(maxScore + " " + minScore);
    }
}
