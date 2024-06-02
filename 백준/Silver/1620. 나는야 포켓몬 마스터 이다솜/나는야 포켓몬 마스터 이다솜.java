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

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        String[] poketmon = new String[N + 1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            poketmon[i] = br.readLine();
            map.put(poketmon[i], i);
        }

        for(int i = 1; i <= T; i++) {
            String line = br.readLine();
            if(map.containsKey(line)) {
                sb.append(map.get(line)).append('\n');
            } else {
                int idx = Integer.parseInt(line);
                sb.append(poketmon[idx]).append('\n');
            }
        }

        System.out.println(sb);
    }
}