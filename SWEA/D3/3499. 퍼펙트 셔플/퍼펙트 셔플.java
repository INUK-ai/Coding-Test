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

            String[] strArray = new String[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                strArray[i] = st.nextToken();
            }

            StringBuilder str = new StringBuilder();

            if(N % 2 == 0) {
                for(int i = 0; i < N / 2; i++) {
                    str.append(strArray[i]);
                    str.append(" ");
                    str.append(strArray[N / 2 + i]);
                    str.append(" ");
                }
            } else {
                for(int i = 0; i < N / 2; i++) {
                    str.append(strArray[i]);
                    str.append(" ");
                    str.append(strArray[N / 2 + 1 + i]);
                    str.append(" ");
                }
                
                str.append(strArray[N / 2]);
            }

            sb.append("#").append(t).append(" ");
            sb.append(str.toString());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}