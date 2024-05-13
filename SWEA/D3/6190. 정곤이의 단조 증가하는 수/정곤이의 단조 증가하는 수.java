import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    private static int max;
    private static int N;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            max = -1;

            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++) {
                    int product = arr[i] * arr[j];
                    if(isMonoIncreasing(product)) {
                        max = Math.max(max, product);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isMonoIncreasing(int product) {

        char[] digits = String.valueOf(product).toCharArray();
        for(int i = 0; i < digits.length - 1; i++) {
            if(digits[i] > digits[i + 1]) {
                return false;
            }
        }
        return true;
    }
}