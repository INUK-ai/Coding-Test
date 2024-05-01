import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            String original = br.readLine();
            int changes = 0;
            char lastChar = '0';

            for(int i = 0; i < original.length(); i++) {
                if(original.charAt(i) != lastChar) {
                    changes++;
                    lastChar = original.charAt(i);
                }
            }

            sb.append("#").append(tc).append(" ").append(changes).append("\n");
        }
        
        System.out.println(sb);
    }
}
