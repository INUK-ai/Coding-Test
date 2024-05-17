import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int answer;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String X = st.nextToken();

            answer = 0;
            for (int i = 0; i < X.length(); i++) {
                answer += (X.charAt(i) - '0');
            }

            answer = answer % (N - 1);

            sb.append("#").append(t).append(" ");
            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}