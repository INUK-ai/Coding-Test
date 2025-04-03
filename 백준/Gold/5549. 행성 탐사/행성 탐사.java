import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int M, N;
    private static int K;
    private static int[][] sumJ, sumO, sumI;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        sumJ = new int[M + 1][N + 1];
        sumO = new int[M + 1][N + 1];
        sumI = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                char terrain = line.charAt(j - 1);
                sumJ[i][j] = sumJ[i - 1][j] + sumJ[i][j - 1] - sumJ[i - 1][j - 1];
                sumO[i][j] = sumO[i - 1][j] + sumO[i][j - 1] - sumO[i - 1][j - 1];
                sumI[i][j] = sumI[i - 1][j] + sumI[i][j - 1] - sumI[i - 1][j - 1];

                if (terrain == 'J') sumJ[i][j]++;
                else if (terrain == 'O') sumO[i][j]++;
                else if (terrain == 'I') sumI[i][j]++;
            }
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int j = query(sumJ, y1, x1, y2, x2);
            int o = query(sumO, y1, x1, y2, x2);
            int i = query(sumI, y1, x1, y2, x2);

            sb.append(j).append(" ").append(o).append(" ").append(i).append("\n");
        }

        System.out.println(sb);
    }

    private static int query(int[][] sum, int y1, int x1, int y2, int x2) {
        return sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1];
    }
}