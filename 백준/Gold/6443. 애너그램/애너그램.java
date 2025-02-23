import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static char[] alphabets;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            alphabets = br.readLine().toCharArray();
            visited = new boolean[alphabets.length];

            Arrays.sort(alphabets);

            backtrace(0, new StringBuilder());
        }

        System.out.println(sb);
    }

    private static void backtrace(int index, StringBuilder temp) {

        if (index == alphabets.length) {
            sb.append(temp).append("\n");
            return;
        }

        char lastChar = '\0';

        for (int i = 0; i < alphabets.length; i++) {
            if (visited[i]) continue;
            if (alphabets[i] == lastChar) continue;

            visited[i] = true;
            temp.append(alphabets[i]);
            backtrace(index + 1, temp);
            temp.deleteCharAt(temp.length() - 1);
            visited[i] = false;

            lastChar = alphabets[i];
        }
    }
}
