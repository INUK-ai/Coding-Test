import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int k;
    private static int[] nums;
    private static int[] lotto;
    private static boolean[] visited;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            nums = new int[k];
            lotto = new int[6];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            backtrace(0, 0);

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void backtrace(int index, int count) {

        if (count == 6) {
            for (int lottoNum : lotto) {
                sb.append(lottoNum).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                lotto[count] = nums[i];
                backtrace(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}
