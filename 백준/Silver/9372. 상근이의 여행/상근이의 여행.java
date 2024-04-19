import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int r1, c1, r2, c2;
    static int T;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            }

            sb.append(N - 1).append("\n");
        }

        System.out.println(sb);
    }
}