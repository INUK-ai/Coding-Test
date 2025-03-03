import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] costs;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        costs = new int[N];

        int maxCost = 0, totalCost = 0;
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(br.readLine());
            maxCost = Math.max(maxCost, costs[i]);
            totalCost += costs[i];
        }

        int low = maxCost, high = totalCost, result = high;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isValid(int limit) {

        int count = 1, sum = 0;
        for (int cost : costs) {
            if (sum + cost > limit) {
                count++;
                sum = cost;
            } else {
                sum += cost;
            }
        }

        return count <= M;
    }
}