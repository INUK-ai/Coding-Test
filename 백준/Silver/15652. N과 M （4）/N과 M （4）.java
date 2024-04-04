import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[M];

        dfs(1, 0);

        System.out.println(sb);
    }

    private static void dfs(int at, int count) {

        if(count == M) {
            for(int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = at; i < N + 1; i++) {
            array[count] = i;
            dfs(i, count + 1);
        }
    }
}