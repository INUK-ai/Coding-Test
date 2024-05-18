import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int answer;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            boolean[] numArray = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) {
                int a = Integer.parseInt(st.nextToken());

                numArray[a] = true;
            }

            StringBuilder numString = new StringBuilder();
            for(int i = 1; i <= N; i++) {
                if(!numArray[i]) {
                    numString.append(i).append(" ");
                }
            }

            sb.append("#").append(t).append(" ");
            sb.append(numString.toString());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}