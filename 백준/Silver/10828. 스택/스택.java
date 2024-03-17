import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] stack = new int[100001];

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(bf.readLine());
        int current_idx = -1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String command = bf.readLine();

            if(command.equals("top")) {
                if(current_idx == -1) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack[current_idx]).append("\n");
                }
            } else if(command.equals("empty")) {
                if(current_idx == -1) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if(command.equals("size")) {
                sb.append(current_idx + 1).append("\n");
            } else if(command.equals("pop")) {
                if(current_idx == -1) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack[current_idx]).append("\n");
                    current_idx--;
                }
            } else {
                StringTokenizer st = new StringTokenizer(command);
                String p = st.nextToken();

                current_idx++;
                stack[current_idx] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(sb);
    }
}