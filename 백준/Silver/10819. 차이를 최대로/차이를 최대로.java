import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[] nums;
    
    private static int maxSum = Integer.MIN_VALUE;
    private static int[] perm;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        perm = new int[N];
        visited = new boolean[N];

        backtrace(0);
        
        System.out.println(maxSum);
    }

    private static void backtrace(int depth) {
        
        if (depth == N) {
            maxSum = Math.max(maxSum, calculateSum());
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = nums[i];
                backtrace(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int calculateSum() {
        
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(perm[i] - perm[i + 1]);
        }
        
        return sum;
    }
}
