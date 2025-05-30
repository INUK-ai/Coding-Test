import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Wire implements Comparable<Wire> {
        int a;
        int b;

        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Wire o) {
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        Wire[] wires = new Wire[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            wires[i] = new Wire(a, b);
        }

        Arrays.sort(wires);

        int[] dp = new int[N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(dp, 0, len, wires[i].b);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = wires[i].b;
            if (pos == len) {
                len++;
            }
        }

        System.out.println(N - len);
    }
}
