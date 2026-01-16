import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int MAX = 2 * 123456 + 1;

        boolean[] isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < MAX; j += i) {
                isPrime[j] = false;
            }
        }

        int[] primePrefix =  new int[MAX];
        for (int i = 1; i < MAX; i++) {
            primePrefix[i] = primePrefix[i - 1] + (isPrime[i] ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int answer = primePrefix[2 * n] - primePrefix[n];
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}