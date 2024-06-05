import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] brand = new int[M][2];
        int minLines = 1001;
        int minLine = 1001;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            brand[i][0] = Integer.parseInt(st.nextToken());
            brand[i][1] = Integer.parseInt(st.nextToken());

            minLines = Math.min(minLines, brand[i][0]);
            minLine = Math.min(minLine, brand[i][1]);
        }

        int answer = 0;

        if(minLine * 6 <= minLines) {
            answer = minLine * N;
        } else {
            int bundle = N / 6;
            int single = N % 6;

            if(single * minLine > minLines) {
                answer = (bundle + 1) * minLines;
            } else {
                answer = bundle * minLines + single * minLine;
            }

        }

        sb.append(answer).append("\n");

        System.out.println(sb);
    }
}