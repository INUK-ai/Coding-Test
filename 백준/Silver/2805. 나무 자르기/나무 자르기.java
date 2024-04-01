import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] stairs;
    static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Long M = Long.parseLong(st.nextToken());

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());

        long max = 0;
        for(int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(trees[i], max);
        }

        long low = 0;
        long high = max;

        while(low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for(long tree : trees) {
                if(tree > mid) {
                    sum += tree - mid;
                }
            }

            if(sum < M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        sb.append(high);

        System.out.println(sb);
    }
}