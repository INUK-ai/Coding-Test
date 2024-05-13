import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    private static int max;
    private static int N;
    private static int K;

    public static class Product {

        int size;
        int value;

        public Product(int size, int value) {
            this.size = size;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            Product[] products = new Product[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int size = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                products[i] = new Product(size, value);
            }

            int[] dp = new int[K + 1];

            for(int i = 0; i < N; i++) {
                for(int j = K; j >= products[i].size; j--) {
                    dp[j] = Math.max(dp[j], dp[j - products[i].size] + products[i].value);
                }
            }

            sb.append("#").append(t).append(" ").append(dp[K]).append("\n");
        }

        System.out.println(sb);
    }
}