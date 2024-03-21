import java.io.*;
import java.util.*;

public class Main {

    public static class Print {
        int index;
        int value;

        public Print(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());

            Queue<Print> q = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(new Print(j, num));
                list.add(num);
            }

            Collections.sort(list, Collections.reverseOrder());

            int answer = 0;
            int value_idx = 0;
            while(!q.isEmpty()) {
                Print current = q.poll();

                if(current.value == list.get(value_idx)) {
                    if(current.index == M) {
                        answer++;
                        break;
                    }

                    answer++;
                    value_idx++;
                }

                q.offer(current);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}