import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] budgets;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        budgets = new int[N];

        int maxBudget = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(maxBudget, budgets[i]);
        }
        M = Integer.parseInt(br.readLine());

        int low = 0, high = maxBudget, result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long total = getTotalBudget(mid);

            if (total <= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static long getTotalBudget(int cap) {

        long sum = 0;
        for (int budget : budgets) {
            sum += Math.min(budget, cap);
        }

        return sum;
    }
}