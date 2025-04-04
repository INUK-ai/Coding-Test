import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[][] profit;
    private static int[][] prefixSum;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        profit = new int[N + 1][N + 1];
        prefixSum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                profit[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = profit[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        int maxProfit = Integer.MIN_VALUE;

        for (int k = 1; k <= N; k++) {
            for (int i = k; i <= N; i++) {
                for (int j = k; j <= N; j++) {
                    int total = query(i - k + 1, j - k + 1, i, j);
                    maxProfit = Math.max(maxProfit, total);
                }
            }
        }

        System.out.println(maxProfit);
    }

    private static int query(int y1, int x1, int y2, int x2) {
        return prefixSum[y2][x2] - prefixSum[y1 - 1][x2] - prefixSum[y2][x1 - 1] + prefixSum[y1 - 1][x1 - 1];
    }
}