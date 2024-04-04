import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long answer = dfs(A, B, C);

        System.out.println(answer);
    }

    private static long dfs(long a, long b, long c) {

        if(b == 1) {
            return a % c;
        }

        long half = dfs(a, b / 2, c);

        if(b % 2 == 0) {
            return half * half % c;
        } else {
            return (half * half) % c * a % c;
        }
    }
}