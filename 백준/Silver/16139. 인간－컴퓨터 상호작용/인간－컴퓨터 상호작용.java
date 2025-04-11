import java.io.*;
import java.util.*;

public class Main {

    static int[][] prefix; // 26개의 알파벳 * 문자열 길이
    static int q;
    static String s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine();
        int n = s.length();
        q = Integer.parseInt(br.readLine());

        // prefix[c][i] = s의 0~i까지 c 알파벳 등장 횟수
        prefix = new int[26][n];

        // 초기 누적합 구성
        prefix[s.charAt(0) - 'a'][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                prefix[c][i] = prefix[c][i - 1];
            }
            prefix[s.charAt(i) - 'a'][i]++;
        }

        // 질의 처리
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = alpha - 'a';

            if (l == 0) {
                sb.append(prefix[c][r]).append("\n");
            } else {
                sb.append(prefix[c][r] - prefix[c][l - 1]).append("\n");
            }
        }

        System.out.print(sb);
    }
}