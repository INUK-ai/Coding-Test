import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(bf.readLine());

        ArrayList<long[]> lines = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            long start = Integer.parseInt(st.nextToken());
            long end = Integer.parseInt(st.nextToken());
            long[] line = new long[]{start, end};

            lines.add(line);
        }

        Collections.sort(lines, Comparator.comparing(line -> line[0]));

        long start = lines.get(0)[0];
        long end = lines.get(0)[1];
        long answer = end - start;

        for(int i = 1; i < N; i++) {
            long current_start = lines.get(i)[0];
            long current_end = lines.get(i)[1];

            if(current_end < end) {
                continue;
            }

            if(current_start < end) {
                current_start = end;
            }

            answer += (current_end - current_start);
            end = current_end;
        }

        System.out.println(answer);
    }
}