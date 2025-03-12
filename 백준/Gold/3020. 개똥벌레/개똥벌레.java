import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, H;
    private static int[] bottom, top;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        bottom = new int[H + 1];
        top = new int[H + 1];

        for (int i = 0; i < N; i++) {
            int obstacle = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                bottom[obstacle]++;
            } else {
                top[obstacle]++;
            }
        }

        for (int i = H - 1; i > 0; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        int minObstacles = Integer.MAX_VALUE;
        int count = 0;

        for (int h = 1; h <= H; h++) {
            int obstacles = bottom[h] + top[H - h + 1];

            if (obstacles < minObstacles) {
                minObstacles = obstacles;
                count = 1;
            } else if (obstacles == minObstacles) {
                count++;
            }
        }

        System.out.println(minObstacles + " " + count);
    }
}