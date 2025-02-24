import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        if (list.size() > N) {
            System.out.println(list.get(N));
        } else {
            System.out.println(-1);
        }
    }

    private static void dfs(long num, int lastDigit) {

        list.add(num);

        for (int i = 0; i < lastDigit; i++) {
            dfs(num * 10 + i, i);
        }
    }
}
