import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, D;
    static int answer;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            int water = 1 + 2 * D;
            int answer = N / water;
            if(N % water > 0) {
                answer++;
            }

            sb.append("#").append(t).append(" ");
            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}