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

            Set<String> stringSet = new HashSet<>();
            for (int i = 0; i < N; i++) {
                stringSet.add(br.readLine());
            }

            List<String> stringList = new ArrayList<>(stringSet);
            Collections.sort(stringList, (a, b) -> {
                if(a.length() != b.length()) {
                    return a.length() - b.length();
                } else {
                    return a.compareTo(b);
                }
            });

            sb.append("#").append(t).append("\n");
            for (String s : stringList) {
                sb.append(s);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}