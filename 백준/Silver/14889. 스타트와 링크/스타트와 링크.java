import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, minDiff = Integer.MAX_VALUE;
    private static int[][] S;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrace(0, 0);

        System.out.println(minDiff);
    }

    private static void backtrace(int idx, int count) {

        if (count == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                backtrace(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    private static void calculateDiff() {

        int startTeam = 0, linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) startTeam += S[i][j];
                if (!selected[i] && !selected[j]) linkTeam += S[i][j];
            }
        }

        minDiff = Math.min(minDiff, Math.abs(startTeam - linkTeam));
    }
}
