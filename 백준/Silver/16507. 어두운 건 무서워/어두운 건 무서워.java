import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int R, C, Q;
    private static int[][] picture, prefix;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        picture = new int[R + 1][C + 1];
        prefix = new int[R + 1][C + 1];

        for (int x = 1; x <= R; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= C; y++) {
                picture[x][y] = Integer.parseInt(st.nextToken());
                prefix[x][y] = prefix[x - 1][y] + prefix[x][y - 1] - prefix[x - 1][y - 1] + picture[x][y];
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
            int count = (x2 - x1 + 1) * (y2 - y1 + 1);
            sb.append(result / count).append("\n");
        }

        System.out.println(sb);
    }
}