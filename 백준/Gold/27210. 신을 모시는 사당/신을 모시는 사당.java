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
    private static int[] statues;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        statues = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            statues[i] = Integer.parseInt(st.nextToken());
        }

        int maxLeft = maxKadane(1, -1);
        int maxRight = maxKadane(-1, 1);

        System.out.println(Math.max(maxLeft, maxRight));
    }

    private static int maxKadane(int val1, int val2) {

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int val : statues) {
            int conv = (val == 1) ? val1 : val2;
            curSum = Math.max(conv, curSum + conv);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}