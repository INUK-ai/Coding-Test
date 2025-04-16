import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int T, N;
    private static int[] height, arranged;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            height = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(height);

            arranged = new int[N];

            int left = 0, right = N - 1;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    arranged[left++] = height[i];
                } else {
                    arranged[right--] = height[i];
                }
            }

            int maxDiff = 0;
            for (int i = 0; i < N; i++) {
                int diff = Math.abs(arranged[i] - arranged[(i + 1) % N]);
                maxDiff = Math.max(maxDiff, diff);
            }

            sb.append(maxDiff).append("\n");
        }
        
        System.out.println(sb);
    }
}