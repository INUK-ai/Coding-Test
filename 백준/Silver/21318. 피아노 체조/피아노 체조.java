import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, Q;
    private static int[] book, prefix;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        book = new int[N + 1];
        prefix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            book[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1];
            if (book[i] < book[i - 1]) prefix[i]++;
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int mistake = prefix[y] - prefix[x];
            sb.append(mistake).append("\n");
        }

        System.out.println(sb);
    }
}