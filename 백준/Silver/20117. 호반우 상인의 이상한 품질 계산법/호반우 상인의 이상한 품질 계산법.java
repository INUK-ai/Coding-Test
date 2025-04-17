import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[] products;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        products = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            products[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(products);

        int result = 0;
        int left = 0, right = N - 1;

        while (left < right) {
            result += products[right] * 2;
            right--;
            left++;
        }

        if (left == right) result += products[left];

        System.out.println(result);
    }
}