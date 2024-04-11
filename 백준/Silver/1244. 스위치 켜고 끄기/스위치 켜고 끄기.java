import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;
    static boolean[] lights;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        lights = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            lights[i] = st.nextToken().equals("0") ? false : true;
        }


        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                for(int j = num - 1; j < N; j += num) {
                    lights[j] = !lights[j];
                }
            }

            if(sex == 2) {
                int index = num - 1;
                lights[index] = !lights[index];

                if(index == 0 || index == N - 1) {
                    continue;
                }

                int left = index - 1;
                int right = index + 1;

                while(lights[left] == lights[right]) {
                    lights[left] = !lights[left];
                    lights[right] = !lights[right];

                    left--;
                    right++;

                    if(left < 0) {
                        break;
                    }

                    if(right >= N) {
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {

            if(lights[i]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }

            if(i % 20 == 19) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}