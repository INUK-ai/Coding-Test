import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] deque = new int[10001];
        int current_idx = -1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String command = bf.readLine();

            if(command.equals("size")) {
                sb.append(current_idx + 1).append("\n");
                continue;
            }

            if(command.equals("empty")) {
                if(current_idx == -1) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                continue;
            }

            if(command.equals("front")) {
                if(current_idx == -1) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque[0]).append("\n");
                }
                continue;
            }

            if(command.equals("back")) {
                if(current_idx == -1) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque[current_idx]).append("\n");
                }
                continue;
            }

            if(command.equals("pop_front")) {
                if(current_idx == -1) {
                    sb.append(-1).append("\n");
                    continue;
                } else {
                    sb.append(deque[0]).append("\n");
                }
                for(int j = 0; j <= current_idx; j++) {
                    deque[j] = deque[j + 1];
                }
                current_idx--;
                continue;
            }

            if(command.equals("pop_back")) {
                if(current_idx == -1) {
                    sb.append(-1).append("\n");
                    continue;
                } else {
                    sb.append(deque[current_idx]).append("\n");
                }
                deque[current_idx--] = 0;
                continue;
            }

            StringTokenizer st = new StringTokenizer(command);
            String command2 = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(command2.equals("push_back")) {
                current_idx++;
                deque[current_idx] = num;
                continue;
            }

            if(command2.equals("push_front")) {
                current_idx++;
                for(int j = current_idx; j > 0; j--) {
                    deque[j] = deque[j - 1];
                }
                deque[0] = num;
                continue;
            }
        }

        System.out.println(sb);
    }
}